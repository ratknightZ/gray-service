package com.arms.service.dao;

import com.arms.service.bo.UserLendSourceIpBo;
import com.arms.service.model.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface UserDao {

    int insert(User user);

    User select(int id);

    int update(User user);

    User selectByEmail(String email);

    User selectByWechat(String wechatOpenId);

    User selectByCellphone(String cellphone);

    List<User> selectByRoleAuth(@Param("roleAuth") String roleAurh, @Param("start") int start, @Param("limit") int limit);

    int countByRoleAuth(@Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime, @Param("roleAuth") String roleAurh);

    List<UserLendSourceIpBo> selectUserLendSourceIpBo(@Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime,
                                                      @Param("start") int start, @Param("limit") int limit);
}
