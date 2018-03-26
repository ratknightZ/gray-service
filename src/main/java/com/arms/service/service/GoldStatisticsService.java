package com.arms.service.service;

import com.arms.service.model.GoldStatistics;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/15
 */
public interface GoldStatisticsService {

    List<GoldStatistics> getRankList(int page, int pageSize);

    int getGoldRankLocation(int userId);

    void statistic();
}
