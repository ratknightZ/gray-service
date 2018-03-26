package com.arms.service.dao;

import com.arms.service.model.TerraceNotify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/11
 */
public interface TerraceNotifyDao {

    void insert(TerraceNotify terraceNotify);

    TerraceNotify select(int id);

    List<TerraceNotify> selectByCellphone(@Param("cellphone") String cellphone, @Param("start") int start, @Param("limit") int limit);

    List<TerraceNotify> selectList(@Param("start") int start, @Param("limit") int limit);

    List<TerraceNotify> selectByTerraceId(@Param("terraceId") int terraceId, @Param("start") int start, @Param("limit") int limit);
}
