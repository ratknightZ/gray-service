package com.arms.service.service;

import com.arms.service.model.TerraceNotify;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/11
 */
public interface TerraceNotifyService {

    void dealNotify(int terraceId, double amount, String cellphone, int timeLimit);

    List<TerraceNotify> getByUserId(int userId, int page, int pageSize);

    List<TerraceNotify> get(int page, int pageSize);

    List<TerraceNotify> getByTerraceId(int terraceId, int page, int pageSize);
}
