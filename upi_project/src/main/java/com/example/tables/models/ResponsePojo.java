package com.example.tables.models;

import java.util.List;
import java.util.Map;

public class ResponsePojo {

    private List<ColumnMetaData> metaData;
    private List<Map<String, Object>> data;

    public List<ColumnMetaData> getMetaData() {
        return metaData;
    }

    public void setMetaData(List<ColumnMetaData> metaDataList) {
        this.metaData = metaDataList;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }
}
