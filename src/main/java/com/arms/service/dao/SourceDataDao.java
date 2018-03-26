package com.arms.service.dao;

import com.arms.service.model.SourceData;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author liuchen
 * @since 2018/1/2
 */
public interface SourceDataDao {

    void statistics();

    //数据库中的数据记录的是GMT_CREATE前一天的数据
    List<SourceData> selectHistoryData(@Param("startTime") Timestamp startTime , @Param("endTime") Timestamp endTime, @Param("source") String source);

    List<SourceData> selectTodayData(@Param("source") String source);

    List<SourceData> selectYesterdayData();
}
