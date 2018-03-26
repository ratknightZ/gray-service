package com.arms.service.service.imp;

import com.arms.service.dao.UserIpDao;
import com.arms.service.model.UserIp;
import com.arms.service.service.UserIpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuchen
 * @since 2018/1/18
 */
@Service("userIpService")
public class UserIpServiceImp implements UserIpService {

    @Resource
    private UserIpDao userIpDao;

    @Override
    public void add(UserIp userIp) {
        userIpDao.insert(userIp);
    }

    @Override
    public UserIp get(int userId) {
        return userIpDao.select(userId);
    }
}
