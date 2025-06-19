/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tables.models;

/**
 *
 * @author Abcom
 */
public class UpiSmsModel{
     private Long id;
    private String name;
    private String template;
    private String type;
    private String target;
    private String tranType;
    private String cdciStatus;
    private String nfsStatus;
    private String nfsResponseCode;
    private String cdciResponseCode;

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

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getCdciStatus() {
        return cdciStatus;
    }

    public void setCdciStatus(String cdciStatus) {
        this.cdciStatus = cdciStatus;
    }

    public String getNfsStatus() {
        return nfsStatus;
    }

    public void setNfsStatus(String nfsStatus) {
        this.nfsStatus = nfsStatus;
    }

    public String getNfsResponseCode() {
        return nfsResponseCode;
    }

    public void setNfsResponseCode(String nfsResponseCode) {
        this.nfsResponseCode = nfsResponseCode;
    }

    public String getCdciResponseCode() {
        return cdciResponseCode;
    }

    public void setCdciResponseCode(String cdciResponseCode) {
        this.cdciResponseCode = cdciResponseCode;
    }
}
