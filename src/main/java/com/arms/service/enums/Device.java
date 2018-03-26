package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2018/3/20
 */
public enum Device {

    ANDROID(1,"综合排序"),

    IOS(2,"小额贷");

    private int value;

    private String desc;

    private Device(int value,String desc){
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

    public static Device getDevice(int value) {
        for (Device device : Device.values()) {
            if (device.getValue() == value) {
                return device;
            }
        }
        return null;
    }
}
