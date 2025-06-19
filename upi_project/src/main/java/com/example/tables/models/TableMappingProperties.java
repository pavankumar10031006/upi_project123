package com.example.tables.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TableMappingProperties {

    @Value("${table-mapping.EMP}")
    private String emp;

    @Value("${table-mapping.UPIHOST}")
    private String uPIHOST;

    @Value("${table-mapping.UPISMS}")
    private String uPISMS;

    @Value("${table-mapping.SYS}")
    private String sys;

    public String getTableName(String code) {
        Map<String, String> map = new HashMap<>();
        map.put("EMP", emp);
        map.put("UPIHOST", uPIHOST);
        map.put("UPISMS", uPISMS);
        map.put("SYS", sys);
        return map.get(code);
    }
}
