package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2018/3/2
 */
public enum UnitOfRate {

    RATE_MONTH(0,"%/月"),

    RATE_DAY(1,"%/日");

    private int    value;

    private String desc;

    private UnitOfRate(int value, String desc) {
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

    public static UnitOfRate getUnitOfRate(int value) {
        for (UnitOfRate unitOfRate : UnitOfRate.values()) {
            if (unitOfRate.getValue() == value) {
                return unitOfRate;
            }
        }
        return null;
    }
}
