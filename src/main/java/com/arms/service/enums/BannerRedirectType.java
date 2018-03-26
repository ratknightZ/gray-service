package com.arms.service.enums;

public enum BannerRedirectType {

    H5(1), NATIVE(2);

    private int value;

    private BannerRedirectType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static BannerRedirectType getType(int value) {
        for (BannerRedirectType bannerRedirectType : BannerRedirectType.values()) {
            if (bannerRedirectType.value == value) {
                return bannerRedirectType;
            }
        }
        return null;
    }

}
