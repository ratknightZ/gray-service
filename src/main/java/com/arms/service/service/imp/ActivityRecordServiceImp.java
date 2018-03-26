package com.arms.service.service.imp;

import com.arms.service.dao.ActivityRecordDao;
import com.arms.service.enums.UnitOfTime;
import com.arms.service.service.ActivityRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuchen
 * @since 2017/12/13
 */
@Service("activityRecordService")
public class ActivityRecordServiceImp implements ActivityRecordService {

    @Resource
    private ActivityRecordDao activityRecordDao;


    @Override
    public int getUserJoinCount(int userId, int activityId, UnitOfTime unitOfTime) {
        return activityRecordDao.selectJoinCount(userId,activityId,unitOfTime.getValue());
    }
}
