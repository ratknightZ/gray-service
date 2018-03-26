package com.arms.service.enums;

public enum LoginType {

    USERNAME("username"), EMAIL("email"), CELLPHONE("cellphone"), WECHAT("wechat"), QQ("qq"), FACEBOOK(
                                                                                                       "facebook"), WEIBO(
                                                                                                                          "weibo");

    private String value;

    private LoginType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static LoginType getType(String value) {
        for (LoginType loginType : LoginType.values()) {
            if (loginType.value.equals(value)) {
                return loginType;
            }
        }
        return null;
    }

}
