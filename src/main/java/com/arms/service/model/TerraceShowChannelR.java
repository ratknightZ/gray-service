package com.arms.service.model;

import java.sql.Timestamp;

/**
 * @author liuchen
 * @since 2018/2/28
 */
public class TerraceShowChannelR {

    private int terraceId;

    private int showChannelId;

    private Timestamp gmtCreate;

    private Timestamp gmtUpdate;

    public int getTerraceId() {
        return terraceId;
    }

    public void setTerraceId(int terraceId) {
        this.terraceId = terraceId;
    }

    public int getShowChannelId() {
        return showChannelId;
    }

    public void setShowChannelId(int showChannelId) {
        this.showChannelId = showChannelId;
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
