package com.arms.service.service.imp;

import com.arms.service.dao.UserDao;
import com.arms.service.dao.UserSourceDao;
import com.arms.service.exception.UserException;
import com.arms.service.model.User;
import com.arms.service.service.UserSourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuchen
 * @since 2017/12/29
 */
@Service("userSourceService")
public class UserSourceServiceImp implements UserSourceService {

    @Resource
    private UserSourceDao userSourceDao;

    @Resource
    private UserDao userDao;

    @Override
    public void add(int userId, String source) throws UserException {
        User user = userDao.select(userId);
        if (user == null){
            throw new UserException("用户不存在");
        }
        try {
            userSourceDao.insert(userId,source);
        } catch (Exception e) {
            throw new UserException("用户已确定来源,不可更改");
        }
    }

    @Override
    public String get(int userId) {
        return userSourceDao.select(userId);
    }
}
