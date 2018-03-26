package com.arms.service.service.imp;

import com.arms.service.dao.GetuiUserDao;
import com.arms.service.dao.UserDao;
import com.arms.service.exception.GetuiException;
import com.arms.service.model.GetuiUser;
import com.arms.service.model.User;
import com.arms.service.service.GetuiService;
import com.gexin.rp.sdk.base.impl.Target;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author jinxuan
 * @since 2017/12/5
 */
@Service("getuiService")
public class GetuiServiceImp implements GetuiService {

    @Resource
    private GetuiUserDao getuiUserDao;

    @Resource
    private UserDao userDao;

    @Override
    public void addGetuiUser(GetuiUser getuiUser) throws GetuiException {
        if (getuiUser == null) {
            throw new GetuiException("Add getuiUser failed, getuiUser is null !!");
        }
        getuiUserDao.insert(getuiUser);
    }

    @Override
    public void updateGetuiUser(GetuiUser getuiUser) throws GetuiException {
        if (getuiUser == null) {
            throw new GetuiException("Update getuiUser failed, getuiUser is null !!");
        }
        getuiUserDao.update(getuiUser);
    }

    @Override
    public GetuiUser getByUserId(int userId) {
        if (userId <= 0) {
            return null;
        }
        return getuiUserDao.selectByUserId(userId);
    }

    @Override
    public void delete(int userId) throws GetuiException {
        if (userId <= 0) {
            throw new GetuiException("userId不合法!!");
        }
        User user = userDao.select(userId);
        if (user == null) {
            throw new GetuiException("用户不存在!!");
        }
        getuiUserDao.delete(userId);
    }

    @Override
    public List<Target> getTargetList(int device, int isApplyFor, Timestamp startTime, Timestamp endTime) {
        return getuiUserDao.selectTargetList(device,isApplyFor,startTime,endTime);
    }

}
