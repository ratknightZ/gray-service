package com.arms.service.dao;

import com.arms.service.model.UserIp;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuchen
 * @since 2018/1/18
 */
public interface UserIpDao {

    void insert(UserIp userIp);

    UserIp select(int userId);
}
