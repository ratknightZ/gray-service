package com.arms.service.model;

import java.sql.Timestamp;

/**
 * @author jinxuan
 * @since 2017/11/22
 */
public class Banner {

    private int       id;

    // banner名称
    private String    bannerName;

    // 跳转类型：H5或原生
    private int       redirectType;

    // 鼠标悬浮时显示的tip
    private String    hoverTip;

    // banner对应的图片地址
    private String    picUrl;

    // 点击banner图片跳转的地址
    private String    linkUrl;

    // banner群组名
    private String    groupName;

    // banner描述
    private String    description;

    private Timestamp gmtCreate;

    private Timestamp gmtUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public int getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(int redirectType) {
        this.redirectType = redirectType;
    }

    public String getHoverTip() {
        return hoverTip;
    }

    public void setHoverTip(String hoverTip) {
        this.hoverTip = hoverTip;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Timestamp gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

}
