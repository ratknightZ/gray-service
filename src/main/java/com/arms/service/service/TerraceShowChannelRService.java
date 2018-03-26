package com.arms.service.service;

import com.arms.service.exception.TerraceException;
import com.arms.service.model.TerraceShowChannelR;

import java.util.List;

/**
 * @author liuchen
 * @since 2018/2/28
 */
public interface TerraceShowChannelRService {

    void add(int terraceId, String showChannelIds) throws TerraceException;

    List<TerraceShowChannelR> getByTerraceId(int terraceId);
}
