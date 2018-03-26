package com.arms.service.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/11/26.
 */
public interface InviteCodeDao {

    String selectInviteCode(int userId);

    void insert(@Param("userId") int userId, @Param("inviteCode") String inviteCode);

    Integer selectUserId(String inviteCode);
}
