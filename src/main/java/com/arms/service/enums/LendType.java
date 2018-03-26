package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2017/12/7
 */
public enum LendType {

    PAYDAY_LOAN(1,"现金贷"),

    CREDIT_LOAN(2,"信用贷"),

    LARGE_LOAN(3,"大额贷");

    private int value;

    private String desc;

    private LendType(int value,String desc){
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

    public static LendType getLendType(int value) {
        for (LendType lendType : LendType.values()) {
            if (lendType.getValue() == value) {
                return lendType;
            }
        }
        return null;
    }
}
