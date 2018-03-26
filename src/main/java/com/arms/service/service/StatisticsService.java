package com.arms.service.service;

import com.arms.service.model.SourceData;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/29
 */
public interface StatisticsService {

    void addVisitRecord(String source, String ip);

    void statistics();

    List<SourceData> getSourceData(Timestamp startTime, Timestamp endTime, String source);
}
