package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2017/12/5
 */
public enum RepaymentWay {

    BY_STAGE(1,"分期还款"),

    BY_EXPIRE(2,"到期还款");

    private int value;

    private String desc;

    private RepaymentWay(int value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static RepaymentWay getWay(int value) {
        for (RepaymentWay repaymentWay : RepaymentWay.values()) {
            if (repaymentWay.getValue() == value) {
                return repaymentWay;
            }
        }
        return null;
    }
}
