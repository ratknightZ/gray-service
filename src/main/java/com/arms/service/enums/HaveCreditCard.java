package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2017/12/5
 */
public enum HaveCreditCard {

    HAVE(1,"有信用卡"),

    NOT_HAVE(2,"没有信用卡");

    private int value;

    private String desc;

    private HaveCreditCard(int value,String desc){
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

    public static HaveCreditCard getCard(int value) {
        for (HaveCreditCard haveCreditCard : HaveCreditCard.values()) {
            if (haveCreditCard.getValue() == value) {
                return haveCreditCard;
            }
        }
        return null;
    }
}
