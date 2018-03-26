package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2018/2/28
 */
public enum ShowChannel {

    ANDROID(1,"android"),

    IOS(2,"ios"),

    H5(3,"h5");

    private int value;

    private String desc;

    private ShowChannel(int value,String desc){
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

    public static ShowChannel getShowChannel(int value) {
        for (ShowChannel showChannel : ShowChannel.values()) {
            if (showChannel.getValue() == value) {
                return showChannel;
            }
        }
        return null;
    }
}
