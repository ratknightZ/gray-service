package com.arms.service.service;

import com.arms.service.exception.ActivityException;
import com.arms.service.exception.AssetsException;
import com.arms.service.model.ActivityAssets;

/**
 * Created by Administrator on 2017/11/26.
 */
public interface ActivityAssetsService {

    ActivityAssets get(int id);

    void reward(int userId, int activityId) throws ActivityException, AssetsException;
}
