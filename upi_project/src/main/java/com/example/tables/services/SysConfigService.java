package com.example.tables.services;

import com.example.tables.Entity.SysConfig;
import com.example.tables.Entity.UpiHostEntity;
import com.example.tables.Entity.UpiSmsEntity;
import com.example.tables.models.*;
import com.example.tables.repo.SysConfigRepo;
import com.example.tables.repo.UpiHostRepo;
import com.example.tables.repo.UpiSmsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.*;

@Service
public class SysConfigService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final TableMappingProperties tableMappingProperties;

    @Autowired
    public SysConfigService(TableMappingProperties tableMappingProperties) {
        this.tableMappingProperties = tableMappingProperties;
    }

    @Autowired
    SysConfigRepo sysConfigRepo;

    @Autowired
    UpiHostRepo upiHostRepo;

    @Autowired
    UpiSmsRepo upiSmsRepo;

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

        if (filters != null) {
            for (FilterModel filter : filters) {
                if (filter.getColumn() != null && filter.getOperator() != null && filter.getValue() != null) {
                    String colUpper = filter.getColumn().toUpperCase();
                    boolean isValid = validColumns.stream().map(String::toUpperCase).anyMatch(c -> c.equals(colUpper));
                    if (isValid) {
                        queryBuilder.append(" AND ").append(colUpper)
                                .append(" ").append(filter.getOperator())
                                .append(" '").append(filter.getValue()).append("'");
                    }
                }
            }
        }

        if (sortColumn != null && sortDirection != null &&
                validColumns.stream().map(String::toUpperCase).anyMatch(c -> c.equals(sortColumn.toUpperCase()))) {
            queryBuilder.append(" ORDER BY ").append(sortColumn).append(" ").append(sortDirection);
        } else {
            queryBuilder.append(" ORDER BY ID");
        }

        queryBuilder.append(" OFFSET ").append(offset)
                .append(" ROWS FETCH NEXT ").append(limit).append(" ROWS ONLY");

        String finalQuery = queryBuilder.toString();
        System.out.println("Executing SQL: " + finalQuery);

        List<Map<String, Object>> dataList = jdbcTemplate.queryForList(finalQuery);

        List<ColumnMetaData> metaDataList = jdbcTemplate.query(finalQuery, rs -> {
            List<ColumnMetaData> metaList = new ArrayList<>();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            for (int i = 1; i <= colCount; i++) {
                ColumnMetaData meta = new ColumnMetaData();
                meta.setName(rsmd.getColumnName(i));
                meta.setType(mapSqlTypeToJavaClass(rsmd.getColumnType(i)).getSimpleName());
                metaList.add(meta);
            }
            return metaList;
        });

        ResponsePojo response = new ResponsePojo();
        response.setMetaData(metaDataList);
        response.setData(dataList);
        return response;
    }

    private Class<?> mapSqlTypeToJavaClass(int sqlType) {
        switch (sqlType) {
            case Types.VARCHAR:
            case Types.CHAR:
            case Types.LONGVARCHAR:
                return String.class;
            case Types.INTEGER:
            case Types.SMALLINT:
            case Types.TINYINT:
                return Integer.class;
            case Types.BIGINT:
                return Long.class;
            case Types.NUMERIC:
            case Types.DECIMAL:
                return Long.class;
            case Types.FLOAT:
            case Types.REAL:
            case Types.DOUBLE:
                return Double.class;
            case Types.BOOLEAN:
            case Types.BIT:
                return Boolean.class;
            case Types.DATE:
            case Types.TIME:
            case Types.TIMESTAMP:
                return java.sql.Timestamp.class;
            default:
                return Object.class;
        }
    }

    public void updateSysConfig(SysConfigModel payload) {
        SysConfig existing = sysConfigRepo.findById(payload.getId())
                .orElseThrow(() -> new RuntimeException("ID not found. Please check ID"));

        existing.setValue(payload.getValue());
        existing.setReadPerm(payload.getReadPerm());
        existing.setWritePerm(payload.getWritePerm());
        existing.setDataType(payload.getDataType());
        sysConfigRepo.save(existing);
    }

    public boolean deleteConfigById(String id) {
        if (sysConfigRepo.existsById(id)) {
            sysConfigRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public void updateUpiHostTable(UpiHostModel payload) {
        UpiHostEntity existing = upiHostRepo.findById(payload.getId())
                .orElseThrow(() -> new RuntimeException("ID not found. Please check ID"));

        existing.setHost(payload.getHost());
        existing.setUrl(payload.getUrl());
        existing.setEnableProxy(payload.getEnableProxy());
        existing.setProxyAddress(payload.getProxyAddress());
        existing.setProxyPort(payload.getProxyPort());
        existing.setProtocol(payload.getProtocol());
        existing.setMethod(payload.getMethod());
        existing.setTruststorePath(payload.getTruststorePath());
        existing.setTruststorePassword(payload.getTruststorePassword());
        existing.setKeystorePath(payload.getKeystorePath());
        existing.setKeystorePassword(payload.getKeystorePassword());
        existing.setReadTimeout(payload.getReadTimeout());
        existing.setConnectTimeout(payload.getConnectTimeout());
        existing.setMaxConnections(payload.getMaxConnections());
        existing.setMaxPerRoute(payload.getMaxPerRoute());
        existing.setTlsVersion(payload.getTlsVersion());

        upiHostRepo.save(existing);
    }

    public void updateUpiSmsTable(UpiSmsModel payload) {
        UpiSmsEntity existing = upiSmsRepo.findById(payload.getId())
                .orElseThrow(() -> new RuntimeException("ID not found. Please check ID"));

        existing.setName(payload.getName());
        existing.setTemplate(payload.getTemplate());
        existing.setType(payload.getType());
        existing.setTarget(payload.getTarget());
        existing.setTranType(payload.getTranType());
        existing.setCdciStatus(payload.getCdciStatus());
        existing.setNfsStatus(payload.getNfsStatus());
        existing.setNfsResponseCode(payload.getNfsResponseCode());
        existing.setCdciResponseCode(payload.getCdciResponseCode());

        upiSmsRepo.save(existing);
    }

    public boolean deleteupiHostById(Long id) {
        if (upiHostRepo.existsById(id)) {
            upiHostRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteupiSmsById(Long id) {
        if (upiSmsRepo.existsById(id)) {
            upiSmsRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
