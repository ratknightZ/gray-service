package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2017/12/7
 */
public enum  TerraceType {

    SPEED(1,"综合排序"),

    PAYROLL(2,"小额贷"),

    CREDIT_CARD(3,"大额贷"),

    NEW_CUT(4,"新口子");

    private int value;

    private String desc;

    private TerraceType(int value,String desc){
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

    public static TerraceType getTerraceType(int value) {
        for (TerraceType terraceType : TerraceType.values()) {
            if (terraceType.getValue() == value) {
                return terraceType;
            }
        }
        return null;
    }
}
