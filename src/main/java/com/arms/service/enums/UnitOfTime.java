package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2017/12/13
 */
public enum UnitOfTime {

    ANY(0, "无单位"),

    DAY(1, "日"),

    WEEK(2,"周"),

    MONTH(3, "月");

    private int    value;

    private String desc;

    private UnitOfTime(int value, String desc) {
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

    public static UnitOfTime getUnitOfTime(int value) {
        for (UnitOfTime unitOfTime : UnitOfTime.values()) {
            if (unitOfTime.getValue() == value) {
                return unitOfTime;
            }
        }
        return null;
    }
}
