package com.example.tables.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SysConfigModel {

    @JsonProperty("ID")
    private String id;

    @JsonProperty("VALUE")
    private String value;

    @JsonProperty("READPERM")
    private String readPerm;

    @JsonProperty("WRITEPERM")
    private String writePerm;

    @JsonProperty("DATA_TYPE")
    private String dataType;

    @JsonProperty("NAME")
    private String name;

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public String getReadPerm() { return readPerm; }
    public void setReadPerm(String readPerm) { this.readPerm = readPerm; }

    public String getWritePerm() { return writePerm; }
    public void setWritePerm(String writePerm) { this.writePerm = writePerm; }

    public String getDataType() { return dataType; }
    public void setDataType(String dataType) { this.dataType = dataType; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
