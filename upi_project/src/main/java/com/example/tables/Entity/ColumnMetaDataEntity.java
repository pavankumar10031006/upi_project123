package com.example.tables.Entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "COLUMN_METADATA")
public class ColumnMetaDataEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COLUMN_NAME")
    private String name;

    @Column(name = "DATA_TYPE")
    private String type;

    @Column(name = "TABLE_NAME")
    private String tableName;

    // Constructors
    public ColumnMetaDataEntity() {}

    public ColumnMetaDataEntity(String name, String type, String tableName) {
        this.name = name;
        this.type = type;
        this.tableName = tableName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
