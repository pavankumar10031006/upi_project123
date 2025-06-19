package com.example.tables.models;

public class SysConfigModel {

    private String id;
    private String value;
    private String readPerm;
    private String writePerm;
    private String dataType = "String";

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getReadPerm() {
        return readPerm;
    }

    public void setReadPerm(String readPerm) {
        this.readPerm = readPerm;
    }

    public String getWritePerm() {
        return writePerm;
    }

    public void setWritePerm(String writePerm) {
        this.writePerm = writePerm;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
