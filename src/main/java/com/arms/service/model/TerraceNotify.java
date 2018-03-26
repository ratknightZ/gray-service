package com.arms.service.model;

import java.sql.Timestamp;

/**
 * @author liuchen
 * @since 2017/12/11
 */
public class TerraceNotify {

    private int id;

    private String cellphone;

    private double amount;

    private int terraceId;

    private int timeLimit;

    private Timestamp gmtCreate;

    private Timestamp gmtUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getTerraceId() {
        return terraceId;
    }

    public void setTerraceId(int terraceId) {
        this.terraceId = terraceId;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Timestamp gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}
