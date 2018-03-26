package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2018/2/27
 */
public enum UnitOfQuickestTime {

    MINUTE(0,"分"),

    SECOND(1,"秒");

    private int    value;

    private String desc;

    private UnitOfQuickestTime(int value, String desc) {
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

    public static UnitOfQuickestTime getUnitOfQuickestTime(int value) {
        for (UnitOfQuickestTime unitOfQuickestTime : UnitOfQuickestTime.values()) {
            if (unitOfQuickestTime.getValue() == value) {
                return unitOfQuickestTime;
            }
        }
        return null;
    }
}
