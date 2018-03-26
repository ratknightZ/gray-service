package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2018/3/21
 */
public enum IsApplyFor {

    NO(1,"未提交借款申请"),

    YES(2,"已提交借款申请");

    private int value;

    private String desc;

    private IsApplyFor(int value,String desc){
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

    public static IsApplyFor getIsApplyFor(int value) {
        for (IsApplyFor isApplyFor : IsApplyFor.values()) {
            if (isApplyFor.getValue() == value) {
                return isApplyFor;
            }
        }
        return null;
    }
}
