package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2017/12/19
 */
public enum  IsHot {

    NO(1,"否"),

    YES(2,"是");

    private int value;

    private String desc;

    private IsHot(int value,String desc){
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

    public static IsHot getIsHot(int value) {
        for (IsHot isHot : IsHot.values()) {
            if (isHot.getValue() == value) {
                return isHot;
            }
        }
        return null;
    }
}
