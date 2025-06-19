/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tables.models;

import java.util.List;

/**
 *
 * @author Abcom
 */
public class DataTablePayloadModel {
    private String tableCode;
    private int limit;
    private int offset;
    private SortModel sort;
    private List<FilterModel> filters;

    // Getters and Setters

    /**
     * @return the tableCode
     */
    public String getTableCode() {
        return tableCode;
    }

    /**
     * @param tableCode the tableCode to set
     */
    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    /**
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @return the sort
     */
    public SortModel getSort() {
        return sort;
    }

    /**
     * @param sort the sort to set
     */
    public void setSort(SortModel sort) {
        this.sort = sort;
    }

    /**
     * @return the filters
     */
    public List<FilterModel> getFilters() {
        return filters;
    }

    /**
     * @param filters the filters to set
     */
    public void setFilters(List<FilterModel> filters) {
        this.filters = filters;
    }
}
