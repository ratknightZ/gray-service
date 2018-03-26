package com.arms.service.service.imp;

import com.arms.service.dao.ActivityAssetsDao;
import com.arms.service.dao.ActivityRecordDao;
import com.arms.service.enums.Frequency;
import com.arms.service.enums.GoldType;
import com.arms.service.exception.ActivityException;
import com.arms.service.exception.AssetsException;
import com.arms.service.model.ActivityAssets;
import com.arms.service.model.ActivityRecord;
import com.arms.service.model.GoldAccount;
import com.arms.service.service.ActivityAssetsService;
import com.arms.service.service.GoldAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/26.
 */
@Service("activityAssetsService")
public class ActivityAssetsServiceImp implements ActivityAssetsService {

    @Resource
    private ActivityAssetsDao activityAssetsDao;

    @Resource
    private ActivityRecordDao activityRecordDao;

    @Resource
    private GoldAccountService goldAccountService;

    @Override
    public ActivityAssets get(int id) {
        return activityAssetsDao.select(id);
    }

    @Override
    public void reward(int userId, int activityId) throws ActivityException, AssetsException {
        ActivityAssets activityAssets = activityAssetsDao.select(activityId);
        if (activityAssets == null){
            throw new ActivityException("不存在该活动");
        }

        if (activityAssets.getStatus() == 0){
            throw new ActivityException("该活动已下线");
        }

        Frequency frequency = Frequency.getFrequency(activityAssets.getFrequency());

        int joinCount = activityRecordDao.selectJoinCount(userId,activityId,frequency.getUnitCode());

        //次数限制
        if (frequency == Frequency.UNLIMITED || frequency.getTime() == 0 || joinCount < frequency.getTime()){
            ActivityRecord activityRecord = new ActivityRecord();
            activityRecord.setUserId(userId);
            activityRecord.setActivityId(activityId);
            activityRecordDao.insert(activityRecord);

            GoldAccount goldAccount = new GoldAccount();
            goldAccount.setUserId(userId);
            goldAccount.setValue(activityAssets.getGold());
            goldAccount.setGoldType(GoldType.ACTIVITY.getType());
            goldAccount.setTypeReferencePrimaryKey(activityRecord.getId()+"");
            goldAccount.setSketch(activityAssets.getState());
            goldAccountService.addUserGold(goldAccount);
        }else {
            throw new ActivityException("超过参加活动次数限制");
        }
    }
}
