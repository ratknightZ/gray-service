package com.arms.service.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author liuchen
 * @since 2017/12/29
 */
public interface VisitRecordDao {

    void insert(@Param("source") String source,@Param("ip") String ip);

    int countByIP(@Param("ip") String ip, @Param("unitCode") int unitCode);

    void deleteYesterdayRecord();
}
