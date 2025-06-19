package com.example.tables.Entity;

import javax.persistence.*;
@Entity
@Table(name = "UPI_SMS_TEMPLATES")
public class UpiSmsEntity{

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "TEMPLATE", length = 1024)
    private String template;

    @Column(name = "TYPE", length = 20)
    private String type;

    @Column(name = "TARGET", length = 8)
    private String target;

    @Column(name = "TRAN_TYPE", length = 100)
    private String tranType;

    @Column(name = "CDCI_STATUS", length = 4)
    private String cdciStatus;

    @Column(name = "NFS_STATUS", length = 4)
    private String nfsStatus;

    @Column(name = "NFS_RESPONSE_CODE", length = 4)
    private String nfsResponseCode;

    @Column(name = "CDCI_RESPONSE_CODE", length = 4)
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
