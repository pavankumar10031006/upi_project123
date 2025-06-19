package com.example.tables.models;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "table-mapping")
public class TableMappingProperties {

    private Map<String, String> map;

    public Map<String, String> getMappings() {
        return map;
    }

    public void setMappings(Map<String, String> map) {
        this.map = map;
    }

    public String getTableNameByCode(String code) {
        return map.get(code);
    }
}

