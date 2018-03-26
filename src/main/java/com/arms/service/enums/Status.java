package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2017/12/5
 */
public enum  Status {

    UP(2,"上线"),

    DOWN(1,"下线");

    private int value;

    private String desc;

    private Status(int value,String desc){
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

    public static Status getStatus(int value) {
        for (Status status : Status.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        return null;
    }
}
