package com.arms.service.dao;

import com.arms.service.bo.UserLendInfoBo;
import com.arms.service.model.LendInfo;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/7
 */
public interface LendInfoDao {

    void insert(LendInfo lendInfo);

    int update(LendInfo lendInfo);

    LendInfo select(int userId);

    List<LendInfo> selectList(@Param("startTime") Timestamp startTime,@Param("endTime") Timestamp endTime,@Param("start") int start, @Param("limit") int limit);

    int countAll(@Param("startTime") Timestamp startTime,@Param("endTime") Timestamp endTime);

    List<UserLendInfoBo> selectUserLendInfoBo(@Param("source") String source,@Param("terraceName") String terraceName,
                                              @Param("startTime") Timestamp startTime,@Param("endTime") Timestamp endTime,
                                              @Param("start") int start, @Param("limit") int limit);

    int countUserLendInfoBo(@Param("source") String source,@Param("terraceName") String terraceName,
                            @Param("startTime") Timestamp startTime,@Param("endTime") Timestamp endTime);

    int independentUserApplyForCount(int terraceId);

    int yesterdayIndependentUserApplyForCount(int terraceId);
}
