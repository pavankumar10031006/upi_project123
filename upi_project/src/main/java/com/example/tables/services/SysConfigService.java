package com.example.tables.services;

import com.example.tables.Entity.UpiSmsEntity;
import com.example.tables.models.ColumnMetaData;
import com.example.tables.models.FilterModel;
import com.example.tables.models.ResponsePojo;
import com.example.tables.models.TableMappingProperties;
import com.example.tables.models.UpiSmsModel;
import com.example.tables.repo.UpiSmsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SysConfigService {

    @Autowired
    private UpiSmsRepo upiSmsRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final TableMappingProperties tableMappingProperties;

    @Autowired
    public SysConfigService(TableMappingProperties tableMappingProperties) {
        this.tableMappingProperties = tableMappingProperties;
    }

    public ResponsePojo getFilteredTableDataSYS(
            String tableCode, int limit, int offset,
            String sortColumn, String sortDirection,
            List<FilterModel> filters) {

        String tableName = tableMappingProperties.getTableName(tableCode);
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ").append(tableName).append(" WHERE 1=1");

        List<Map<String, Object>> previewList = jdbcTemplate.queryForList(
                "SELECT * FROM " + tableName + " FETCH FIRST 1 ROWS ONLY");

        List<String> validColumns = new ArrayList<>();
        if (!previewList.isEmpty()) {
            validColumns.addAll(previewList.get(0).keySet());
        }
        boolean isValid = false;
        if (filters != null && !filters.isEmpty()) {
            for (FilterModel filter : filters) {
                if (filter.getColumn() != null && filter.getOperator() != null && filter.getValue() != null) {
                    String filterColUpper = filter.getColumn().toUpperCase();
                    isValid = validColumns.stream()
                            .map(String::toUpperCase)
                            .anyMatch(col -> col.equals(filterColUpper));

                    if (isValid) {
                        queryBuilder.append(" AND ")
                                .append(filterColUpper).append(" ")
                                .append(filter.getOperator()).append(" '")
                                .append(filter.getValue()).append("'");
                    } else {
                        System.out.println("Skipping invalid filter column: " + filter.getColumn());
                    }
                }
            }

            if (isValid) {
                boolean valid = false;
                if (sortColumn != null && sortDirection != null) {
                    valid = validColumns.stream()
                            .map(String::toUpperCase)
                            .anyMatch(col -> col.equals(sortColumn));
                    queryBuilder.append(" ORDER BY ").append(sortColumn).append(" ").append(sortDirection);
                } else {
                    queryBuilder.append(" ORDER BY ID");
                }
                if (valid) {
                    queryBuilder.append(" OFFSET ").append(offset)
                            .append(" ROWS FETCH NEXT ").append(limit).append(" ROWS ONLY");

                    String finalQuery = queryBuilder.toString();
                    System.out.println("Executing SQL: " + finalQuery);

                    List<Map<String, Object>> dataList = jdbcTemplate.queryForList(finalQuery);

                    List<ColumnMetaData> metaDataList = new ArrayList<>();
                    if (!dataList.isEmpty()) {
                        for (String columnName : dataList.get(0).keySet()) {
                            ColumnMetaData meta = new ColumnMetaData();
                            meta.setName(columnName);
                            meta.setType("String");
                            metaDataList.add(meta);
                        }
                    }

                    ResponsePojo response = new ResponsePojo();
                    response.setMetaData(metaDataList);
                    response.setData(dataList);
                    return response;
                } else {
                    return new ResponsePojo();
                }
            } else {
                return new ResponsePojo();
            }
        } else {
            boolean valid = false;
            if (sortColumn != null && sortDirection != null) {
                valid = validColumns.stream()
                        .map(String::toUpperCase)
                        .anyMatch(col -> col.equals(sortColumn));
                queryBuilder.append(" ORDER BY ").append(sortColumn).append(" ").append(sortDirection);
            } else {
                queryBuilder.append(" ORDER BY ID");
            }
            if (valid) {
                queryBuilder.append(" OFFSET ").append(offset)
                        .append(" ROWS FETCH NEXT ").append(limit).append(" ROWS ONLY");

                String finalQuery = queryBuilder.toString();
                System.out.println("Executing SQL: " + finalQuery);

                List<Map<String, Object>> dataList = jdbcTemplate.queryForList(finalQuery);

                List<ColumnMetaData> metaDataList = new ArrayList<>();
                if (!dataList.isEmpty()) {
                    for (String columnName : dataList.get(0).keySet()) {
                        ColumnMetaData meta = new ColumnMetaData();
                        meta.setName(columnName);
                        meta.setType("String");
                        metaDataList.add(meta);
                    }
                }

                ResponsePojo response = new ResponsePojo();
                response.setMetaData(metaDataList);
                response.setData(dataList);
                return response;
            } else {
                return new ResponsePojo();
            }
        }
    }
}
