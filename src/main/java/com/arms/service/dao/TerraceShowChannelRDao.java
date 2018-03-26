package com.arms.service.dao;

import com.arms.service.model.TerraceShowChannelR;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchen
 * @since 2018/2/28
 */
public interface TerraceShowChannelRDao {

    void insert(TerraceShowChannelR terraceShowChannelR);

    List<TerraceShowChannelR> selectByShowChannelId(@Param("showChannelId") int showChannelId, @Param("start") int start, @Param("limit") int limit);

    List<TerraceShowChannelR> selectByTerraceId(int terraceId);

    void delete(TerraceShowChannelR terraceShowChannelR);

    void deleteByTerraceId(int terraceId);
}
