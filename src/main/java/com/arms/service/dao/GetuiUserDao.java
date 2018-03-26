package com.arms.service.dao;


import com.arms.service.model.GetuiUser;
import com.gexin.rp.sdk.base.impl.Target;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author jinxuan
 * @since 2017/12/5
 */
public interface GetuiUserDao {

    int insert(GetuiUser getuiUser);

    int update(GetuiUser getuiUser);

    GetuiUser select(int id);

    GetuiUser selectByUserId(int userId);

    GetuiUser selectByCid(String cid);

    void delete(int userId);

    List<Target> selectTargetList(@Param("device") int device, @Param("isApplyFor") int isApplyFor,
                                  @Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime);

}
