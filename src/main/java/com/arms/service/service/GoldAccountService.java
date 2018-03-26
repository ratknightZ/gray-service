package com.arms.service.service;

import com.arms.service.exception.AssetsException;
import com.arms.service.exception.UserException;
import com.arms.service.model.GoldAccount;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
public interface GoldAccountService {

    int getUserGold(int userId) throws UserException;

    void addUserGold(GoldAccount goldAccount) throws AssetsException;

    void deductUserGold(GoldAccount goldAccount) throws AssetsException;

    List<GoldAccount> getUserAccountList(int userId, int page, int pageSize);

    int getSumRoomGold(int roomId, Timestamp startTime, Timestamp endTime);

    int getSumRoomGoldToday(int roomId);
}
