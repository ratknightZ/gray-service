package com.arms.service.model;

import java.sql.Timestamp;

/**
 * Created by zhangchaojie on 2017/4/12.
 */
public class SmsCode {

    private int       id;

    private String    cellphone;

    private String    smsCode;

    private String    systemTimeMillis;

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

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getSystemTimeMillis() {
        return systemTimeMillis;
    }

    public void setSystemTimeMillis(String systemTimeMillis) {
        this.systemTimeMillis = systemTimeMillis;
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
