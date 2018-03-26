package com.arms.service.bo;

/**
 * @author liuchen
 * @since 2018/3/9
 */
public class UserLendInfoBo {

    private long lendInfoId;

    private String source;

    private String cellphone;

    private String terraceName;

    private double applyForAmount;

    private int timeLimit;

    private String applyForTime;

    public long getLendInfoId() {
        return lendInfoId;
    }

    public void setLendInfoId(long lendInfoId) {
        this.lendInfoId = lendInfoId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTerraceName() {
        return terraceName;
    }

    public void setTerraceName(String terraceName) {
        this.terraceName = terraceName;
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

    public String getApplyForTime() {
        return applyForTime;
    }

    public void setApplyForTime(String applyForTime) {
        this.applyForTime = applyForTime;
    }
}
