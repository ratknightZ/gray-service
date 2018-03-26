package com.arms.service.service;

import com.arms.service.bo.UserLendSourceIpBo;
import com.arms.service.enums.RoleAuth;
import com.arms.service.exception.UserException;
import com.arms.service.model.User;

import java.sql.Timestamp;
import java.util.List;

public interface UserService {

    User get(int id);

    void add(User user) throws UserException;

    void update(User user) throws UserException;

    User getByWechat(String wechatOpenId);

    User getByEmail(String email);

    User getByCellphone(String cellphone);

    List<User> getByRoleAuth(RoleAuth roleAuth, int page, int pageSize);

    int countByRoleAuth(Timestamp startTime, Timestamp endTime, RoleAuth roleAuth);

    List<UserLendSourceIpBo> getUserLendInfoBo(Timestamp startTime, Timestamp endTime, int page, int pageSize);
}
