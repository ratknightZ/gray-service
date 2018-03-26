package com.arms.service.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author liuchen
 * @since 2017/12/29
 */
public interface UserSourceDao {

    void insert(@Param("userId") int userId, @Param("source") String source);

    String select(int userId);
}
