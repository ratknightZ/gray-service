package com.arms.service.model;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/11/23.
 */
public class GoldAccount {

    private long id;

    private int userId;

    private int value;

    private int goldType;

    private String typeReferencePrimaryKey;

    private String sketch;

    private Timestamp gmtCreate;

    private Timestamp gmtUpdate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getGoldType() {
        return goldType;
    }

    public void setGoldType(int goldType) {
        this.goldType = goldType;
    }

    public String getTypeReferencePrimaryKey() {
        return typeReferencePrimaryKey;
    }

    public void setTypeReferencePrimaryKey(String typeReferencePrimaryKey) {
        this.typeReferencePrimaryKey = typeReferencePrimaryKey;
    }

    public String getSketch() {
        return sketch;
    }

    public void setSketch(String sketch) {
        this.sketch = sketch;
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
