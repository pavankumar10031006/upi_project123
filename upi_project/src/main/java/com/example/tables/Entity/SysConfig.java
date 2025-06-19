package com.example.tables.Entity;

import javax.persistence.*;
@Entity
@Table(name = "SYSCONFIG")
public class SysConfig {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "READPERM")
    private String readPerm;

    @Column(name = "WRITEPERM")
    private String writePerm;

    @Column(name = "DATA_TYPE")
    private String dataType = "String";

    @Column(name = "NAME")
    private String name; // <- Add this

    // Getters and Setters...

    public String getId() { return id; }
    public String getValue() { return value; }
    public String getReadPerm() { return readPerm; }
    public String getWritePerm() { return writePerm; }
    public String getDataType() { return dataType; }
    public String getName() { return name; } // <- Add getter

    public void setId(String id) { this.id = id; }
    public void setValue(String value) { this.value = value; }
    public void setReadPerm(String readPerm) { this.readPerm = readPerm; }
    public void setWritePerm(String writePerm) { this.writePerm = writePerm; }
    public void setDataType(String dataType) { this.dataType = dataType; }
    public void setName(String name) { this.name = name; } // <- Add setter
}
