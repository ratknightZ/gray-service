package com.arms.service.service;

import com.arms.service.model.UserIp;

/**
 * @author liuchen
 * @since 2018/1/18
 */
public interface UserIpService {

    void add(UserIp userIp);

    UserIp get(int userId);
}
