package com.arms.service.dao;

import com.arms.service.model.TerraceTypeR;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/5
 */
public interface TerraceTypeRDao {

    void insert(TerraceTypeR terraceTypeR);

    List<TerraceTypeR> selectByTypeId(@Param("typeId") int typeId, @Param("start") int start, @Param("limit") int limit);

    List<TerraceTypeR> selectByTerraceId(int terraceId);

    void delete(TerraceTypeR terraceTypeR);

    void deleteByTerraceId(int terraceId);
}
