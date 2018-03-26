package com.arms.service.dao;

import com.arms.service.model.GoldAccount;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
public interface GoldAccountDao {

    int selectUserGold(int userId);

    void insert(GoldAccount goldAccount);

    List<GoldAccount> selectByUserId(@Param("userId") int userId,
                                     @Param(value = "start") int start,
                                     @Param(value = "limit") int limit);

    int sumRoomGold(@Param("roomId") int roomId, @Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);
}
