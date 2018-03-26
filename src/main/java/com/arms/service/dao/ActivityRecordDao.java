package com.arms.service.dao;

import com.arms.service.model.ActivityRecord;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/11/26.
 */
public interface ActivityRecordDao {

    int selectJoinCount(@Param("userId") int userId, @Param("activityId") int activityId, @Param("unitCode") int unitCode);

    void insert(ActivityRecord activityRecord);
}
