package com.arms.service.dao;

import com.arms.service.model.UserReadMessage;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuchen
 * @since 2017/12/14
 */
public interface UserReadMessageDao {

    void insert(@Param("userId") int userId, @Param("messageId") long messageId);

    UserReadMessage select(@Param("userId") int userId, @Param("messageId") long messageId);
}
