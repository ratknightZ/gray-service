package com.arms.service.bo;

import java.sql.Timestamp;

/**
 * @author liuchen
 * @since 2018/3/12
 */
public class UserLendSourceIpBo {

    private int userId;

    private String cellphone;

    private int countLendInfo;

    private Timestamp registerTime;

    private String source;

    private String ip;

    private int countIp;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public int getCountLendInfo() {
        return countLendInfo;
    }

    public void setCountLendInfo(int countLendInfo) {
        this.countLendInfo = countLendInfo;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getCountIp() {
        return countIp;
    }

    public void setCountIp(int countIp) {
        this.countIp = countIp;
    }
}
