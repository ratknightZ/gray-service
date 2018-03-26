package com.arms.service.service;

import com.arms.service.bo.UserLendInfoBo;
import com.arms.service.exception.LendInfoException;
import com.arms.service.model.LendInfo;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/7
 */
public interface LendInfoService {

    void add(LendInfo lendInfo) throws LendInfoException;

    void update(LendInfo lendInfo);

    LendInfo get(int userId);

    List<LendInfo> getList(Timestamp startTime, Timestamp endTime, int page, int pageSize);

    int countAll(Timestamp startTime, Timestamp endTime);

    List<UserLendInfoBo> getUserLendInfoBo(String source, String terraceName, Timestamp startTime, Timestamp endTime, int page, int pageSize);

    int countUserLendInfoBo(String source, String terraceName, Timestamp startTime, Timestamp endTime);

    int getIndependentUserApplyForCount(int terraceId);

    int getYesterdayIndependentUserApplyForCount(int terraceId);
}
