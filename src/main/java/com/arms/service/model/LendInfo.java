package com.arms.service.model;

import java.sql.Timestamp;

/**
 * @author liuchen
 * @since 2017/12/7
 */
public class LendInfo {

    private long id;

    private int terraceId;

    private int userId;

    private String name;

    private String idCard;

    private String lendPurpose;

    private double applyForAmount;

    private int timeLimit;

    private String profession;

    private Timestamp gmtCreate;

    private Timestamp gmtUpdate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTerraceId() {
        return terraceId;
    }

    public void setTerraceId(int terraceId) {
        this.terraceId = terraceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLendPurpose() {
        return lendPurpose;
    }

    public void setLendPurpose(String lendPurpose) {
        this.lendPurpose = lendPurpose;
    }

    public double getApplyForAmount() {
        return applyForAmount;
    }

    public void setApplyForAmount(double applyForAmount) {
        this.applyForAmount = applyForAmount;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
