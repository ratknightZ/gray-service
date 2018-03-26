package com.arms.service.model;

import java.sql.Timestamp;

/**
 * Created by zhangchaojie on 2016/11/10.
 */
public class Kvs {

    private int       id;

    private String    kvsName;

    private String    kvsValue;

    private String    kvsGroup;

    private Timestamp gmtCreate;

    private Timestamp gmtUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKvsName() {
        return kvsName;
    }

    public void setKvsName(String kvsName) {
        this.kvsName = kvsName;
    }

    public String getKvsValue() {
        return kvsValue;
    }

    public void setKvsValue(String kvsValue) {
        this.kvsValue = kvsValue;
    }

    public String getKvsGroup() {
        return kvsGroup;
    }

    public void setKvsGroup(String kvsGroup) {
        this.kvsGroup = kvsGroup;
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
