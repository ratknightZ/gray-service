package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2018/3/2
 */
public enum  UnitOfRepaymentTime {

    DAY(0,"天"),

    MONTH(1,"月");

    private int    value;

    private String desc;

    private UnitOfRepaymentTime(int value, String desc) {
        this.desc = desc;
        this.value = value;
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

    public static UnitOfRepaymentTime getUnitOfRepaymentTime(int value) {
        for (UnitOfRepaymentTime unitOfRepaymentTime : UnitOfRepaymentTime.values()) {
            if (unitOfRepaymentTime.getValue() == value) {
                return unitOfRepaymentTime;
            }
        }
        return null;
    }
}
