package com.arms.service.enums;

/**
 * Created by Administrator on 2017/11/26.
 */
public enum Frequency {

    UNLIMITED(0,"无限制",0,0),

    UNIQUENESS(1,"一个帐号一次",0,1),

    TEN(2,"一共10次",0,10),

    ONCE_A_DAY(3,"每天一次",1,1);

    private int type;

    private String desc;

    //单位编码 0.无 1.日 2.周 3.月
    private int unitCode;

    //单位时间内允许参加次数 0.无限制
    private int time;

    private Frequency(int type, String desc, int unitCode, int time){
        this.type = type;
        this.desc = desc;
        this.unitCode = unitCode;
        this.time = time;
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

    public int getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(int unitCode) {
        this.unitCode = unitCode;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static Frequency getFrequency(int type) {
        for (Frequency frequency : Frequency.values()) {
            if (frequency.type == type) {
                return frequency;
            }
        }
        return null;
    }
}
