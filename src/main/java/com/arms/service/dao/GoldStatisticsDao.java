package com.arms.service.dao;

import com.arms.service.model.GoldStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/15
 */
public interface GoldStatisticsDao {

    List<GoldStatistics> selectRankList(@Param("start") int start, @Param("limit") int limit);

    Integer selectGoldRankLocation(int userId);

    void statistic();
}
