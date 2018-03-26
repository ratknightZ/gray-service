package com.arms.service.service.imp;

import com.arms.common.util.PageUtil;
import com.arms.service.bo.UserLendInfoBo;
import com.arms.service.dao.LendInfoDao;
import com.arms.service.dao.UserDao;
import com.arms.service.exception.LendInfoException;
import com.arms.service.model.LendInfo;
import com.arms.service.model.Terrace;
import com.arms.service.model.User;
import com.arms.service.service.LendInfoService;
import com.arms.service.service.TerraceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/7
 */
@Service("lendInfoService")
public class LendInfoServiceImp implements LendInfoService {

    @Resource
    private LendInfoDao lendInfoDao;

    @Resource
    private UserDao userDao;

    @Resource
    private TerraceService terraceService;

    @Override
    public void add(LendInfo lendInfo) throws LendInfoException {
        User user = userDao.select(lendInfo.getUserId());
        if (user == null){
            throw new LendInfoException("用户不存在，userId: " + lendInfo.getUserId());
        }
        Terrace terrace = terraceService.get(lendInfo.getTerraceId());
        if (terrace == null){
            throw new LendInfoException("平台不存在，terraceId: " + lendInfo.getTerraceId());
        }
        lendInfoDao.insert(lendInfo);
    }

    @Override
    public void update(LendInfo lendInfo) {
        if (lendInfoDao.update(lendInfo) < 1){
            lendInfoDao.insert(lendInfo);
        }
    }

    @Override
    public LendInfo get(int userId) {
        return lendInfoDao.select(userId);
    }

    @Override
    public List<LendInfo> getList(Timestamp startTime, Timestamp endTime, int page, int pageSize) {
        return lendInfoDao.selectList(startTime,endTime,PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public int countAll(Timestamp startTime, Timestamp endTime) {
        return lendInfoDao.countAll(startTime,endTime);
    }

    @Override
    public List<UserLendInfoBo> getUserLendInfoBo(String source, String terraceName, Timestamp startTime, Timestamp endTime, int page, int pageSize) {
        return lendInfoDao.selectUserLendInfoBo(source,terraceName,startTime,endTime,PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public int countUserLendInfoBo(String source, String terraceName, Timestamp startTime, Timestamp endTime) {
        return lendInfoDao.countUserLendInfoBo(source,terraceName,startTime,endTime);
    }

    @Override
    public int getIndependentUserApplyForCount(int terraceId) {
        return lendInfoDao.independentUserApplyForCount(terraceId);
    }

    @Override
    public int getYesterdayIndependentUserApplyForCount(int terraceId) {
        return lendInfoDao.yesterdayIndependentUserApplyForCount(terraceId);
    }
}
