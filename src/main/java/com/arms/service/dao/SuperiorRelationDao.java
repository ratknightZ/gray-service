package com.arms.service.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/11/26.
 */
public interface SuperiorRelationDao {

    Integer selectSuperiorId(int userId);

    void insert(@Param("userId") int userId, @Param("superiorUserId") int superiorUserId);

    int countJunior(int userId);
}
