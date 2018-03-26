package com.arms.service.dao;

import com.arms.service.model.Opinion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/12
 */
public interface OpinionDao {

    Opinion select(int id);

    void insert(Opinion opinion);

    void update(Opinion opinion);

    void delete(int id);

    List<Opinion> selectByLimit(@Param("start") int start, @Param("limit") int limit);

    int count();
}
