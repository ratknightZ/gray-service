package com.arms.service.service.imp;

import com.arms.common.util.PageUtil;
import com.arms.service.dao.GoldStatisticsDao;
import com.arms.service.model.GoldStatistics;
import com.arms.service.service.GoldStatisticsService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/15
 */
@Service("goldStatisticsService")
public class GoldStatisticsServiceImp implements GoldStatisticsService {

    @Resource
    private GoldStatisticsDao goldStatisticsDao;

    @Override
    public List<GoldStatistics> getRankList(int page, int pageSize) {
        return goldStatisticsDao.selectRankList(PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public int getGoldRankLocation(int userId) {
        Integer location = goldStatisticsDao.selectGoldRankLocation(userId);
        if (location == null){
            return 0;
        }
        return location;
    }

    @Override
    @Scheduled(cron="0 0 0 * * ?")
    public void statistic() {
        goldStatisticsDao.statistic();
    }
}
