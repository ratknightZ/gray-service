package com.arms.service.enums;

/**
 * Created by Administrator on 2017/11/23.
 */
public enum GoldType {

    CHARGE(1,"充值"),

    ACTIVITY(2,"活动奖励"),

    PLAY(3,"游戏扣费");

    private int type;

    private String desc;

    private GoldType(int type, String desc){
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static GoldType getType(int type) {
        for (GoldType goldType : GoldType.values()) {
            if (goldType.type == type) {
                return goldType;
            }
        }
        return null;
    }
}
