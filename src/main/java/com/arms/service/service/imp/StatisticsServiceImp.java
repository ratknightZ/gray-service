package com.arms.service.service.imp;

import com.arms.service.dao.SourceDataDao;
import com.arms.service.dao.VisitRecordDao;
import com.arms.service.model.SourceData;
import com.arms.service.service.StatisticsService;
import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/29
 */
@Service("statisticsService")
public class StatisticsServiceImp implements StatisticsService {

    @Resource
    private VisitRecordDao visitRecordDao;

    @Resource
    private SourceDataDao sourceDataDao;

    @Override
    public void addVisitRecord(String source, String ip) {
        visitRecordDao.insert(source,ip);
    }

    @Override
    @Transactional
    @Scheduled(cron="0 0 1 * * ?")
    public void statistics() {
        List<SourceData> sourceDataList = sourceDataDao.selectYesterdayData();
        if (sourceDataList != null && sourceDataList.isEmpty()){
            sourceDataDao.statistics();
            visitRecordDao.deleteYesterdayRecord();
        }
    }

    @Override
    public List<SourceData> getSourceData(Timestamp startTime, Timestamp endTime, String source) {
        DateTime now = DateTime.now();
        DateTime start = new DateTime(startTime.getTime());
        List<SourceData> sourceDataList = null;
        if (now.getYear() == start.getYear() && now.getMonthOfYear() == start.getMonthOfYear() && now.getDayOfMonth() == start.getDayOfMonth()){
            //当日数据
            sourceDataList = sourceDataDao.selectTodayData(source);
            for (SourceData sourceData : sourceDataList){
                sourceData.setGmtCreate(new Timestamp(DateTime.now().getMillis()));
                //sourceData.setGmtUpdate(new Timestamp(DateTime.now().getMillis()));
            }
        }else {
            //历史数据
            sourceDataList = sourceDataDao.selectHistoryData(startTime,endTime,source);
        }
        return sourceDataList;
    }
}
