package com.arms.service.service;

import com.arms.service.exception.TerraceException;
import com.arms.service.model.TerraceTypeR;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/5
 */
public interface TerraceTypeRService {

    List<TerraceTypeR> getListByTypeId(int typeId, int page, int pageSize);

    List<TerraceTypeR> getListByTerraceId(int terraceId);

    void addTerraceTypeRelation(int terraceId, String terraceTypeIds) throws TerraceException;
}
