package com.arms.service.service;

import com.arms.service.enums.UnitOfTime;

/**
 * @author liuchen
 * @since 2017/12/13
 */
public interface ActivityRecordService {

    int getUserJoinCount(int userId, int activityId, UnitOfTime unitOfTime);
}
