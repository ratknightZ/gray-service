package com.arms.service.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.arms.common.util.PageUtil;
import com.arms.service.dao.TerraceDao;
import com.arms.service.dao.TerraceNotifyDao;
import com.arms.service.dao.UserDao;
import com.arms.service.model.Terrace;
import com.arms.service.model.TerraceNotify;
import com.arms.service.model.User;
import com.arms.service.service.TerraceNotifyService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/11
 */
@Service("terraceNotifyService")
public class TerraceNotifyServiceImp implements TerraceNotifyService {

    @Resource
    private TerraceNotifyDao terraceNotifyDao;

    @Resource
    private TerraceDao terraceDao;

    @Resource
    private UserDao userDao;

    @Override
    public void dealNotify(int terraceId, double amount, String cellphone, int timeLimit) {
        Terrace terrace = terraceDao.select(terraceId);
        if (terrace == null){
            return;
        }
        User user = userDao.selectByCellphone(cellphone);
        if (user == null){
            return;
        }
        TerraceNotify terraceNotify = new TerraceNotify();
        terraceNotify.setTerraceId(terraceId);
        terraceNotify.setCellphone(cellphone);
        terraceNotify.setAmount(amount);
        terraceNotify.setTimeLimit(timeLimit);
        terraceNotifyDao.insert(terraceNotify);
        terrace.setSuccessCount(terrace.getSuccessCount() + 1);
        terraceDao.update(terrace);
    }

    @Override
    public List<TerraceNotify> getByUserId(int userId, int page, int pageSize) {
        User user = userDao.select(userId);
        if (user == null){
            return null;
        }
        return terraceNotifyDao.selectByCellphone(user.getCellphone(), PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public List<TerraceNotify> get(int page, int pageSize) {
        return terraceNotifyDao.selectList(PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public List<TerraceNotify> getByTerraceId(int terraceId, int page, int pageSize) {
        return terraceNotifyDao.selectByTerraceId(terraceId,PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }
}
