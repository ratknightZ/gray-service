package com.arms.service.service.imp;

import com.arms.common.util.PageUtil;
import com.arms.service.dao.GoldAccountDao;
import com.arms.service.dao.UserDao;
import com.arms.service.enums.GoldType;
import com.arms.service.exception.AssetsException;
import com.arms.service.exception.UserException;
import com.arms.service.model.GoldAccount;
import com.arms.service.service.GoldAccountService;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
@Service("goldAccountService")
public class GoldAccountServiceImp implements GoldAccountService {

    @Resource
    private UserDao userDao;

    @Resource
    private GoldAccountDao goldAccountDao;

    @Override
    public int getUserGold(int userId) throws UserException {
        if (userDao.select(userId) == null){
            throw new UserException("用户不存在");
        }
        return goldAccountDao.selectUserGold(userId);
    }

    @Override
    public void addUserGold(GoldAccount goldAccount) throws AssetsException {
        if (goldAccount.getValue() < 0 ){
            throw new AssetsException("所增加的金币数小于等于0，不能调用增加方法 value: " + goldAccount.getValue());
        }
        if (GoldType.getType(goldAccount.getGoldType()) == null){
            throw new AssetsException("非法的增加金币渠道");
        }
        if (goldAccount.getUserId() < 0 || userDao.select(goldAccount.getUserId()) == null){
            throw new AssetsException("用户不存在");
        }
        if (StringUtils.isBlank(goldAccount.getTypeReferencePrimaryKey())){
            throw new AssetsException("关联类型主键异常");
        }
        goldAccountDao.insert(goldAccount);
    }

    @Override
    public void deductUserGold(GoldAccount goldAccount) throws AssetsException {
        if (goldAccount.getValue() < 0){
            throw new AssetsException("参数异常，value: " + goldAccount.getValue());
        }
        if (GoldType.getType(goldAccount.getGoldType()) == null){
            throw new AssetsException("非法的增加金币渠道");
        }
        if (goldAccount.getUserId() < 0 || userDao.select(goldAccount.getUserId()) == null){
            throw new AssetsException("用户不存在");
        }
        if (StringUtils.isBlank(goldAccount.getTypeReferencePrimaryKey())){
            throw new AssetsException("关联类型主键异常");
        }
        int balance = goldAccountDao.selectUserGold(goldAccount.getUserId());
        if (balance < goldAccount.getValue()){
            throw new AssetsException("扣除失败，用户余额不足 value: " + goldAccount.getValue());
        }
        goldAccount.setValue(goldAccount.getValue() * -1);
        goldAccountDao.insert(goldAccount);
    }

    @Override
    public List<GoldAccount> getUserAccountList(int userId, int page, int pageSize){
        return goldAccountDao.selectByUserId(userId, PageUtil.getStart(page, pageSize),
                PageUtil.getLimit(page, pageSize));
    }

    @Override
    public int getSumRoomGold(int roomId, Timestamp startTime, Timestamp endTime) {
        return goldAccountDao.sumRoomGold(roomId,startTime,endTime);
    }

    @Override
    public int getSumRoomGoldToday(int roomId) {
        DateTime dateTime = new DateTime(DateTime.now().getYear(),DateTime.now().getMonthOfYear(),
                DateTime.now().getDayOfMonth(),0,0,0);
        Timestamp startTime = new Timestamp(dateTime.getMillis());
        return goldAccountDao.sumRoomGold(roomId,startTime,null);
    }
}
