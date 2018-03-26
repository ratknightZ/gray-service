package com.arms.service.service;

import com.arms.service.exception.GetuiException;
import com.arms.service.model.GetuiUser;
import com.gexin.rp.sdk.base.impl.Target;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author jinxuan
 * @since 2017/12/5
 */
public interface GetuiService {

    void addGetuiUser(GetuiUser getuiUser) throws GetuiException;

    void updateGetuiUser(GetuiUser getuiUser) throws GetuiException;

    GetuiUser getByUserId(int userId);

    void delete(int userId) throws GetuiException;

    List<Target> getTargetList(int device, int isApplyFor, Timestamp startTime, Timestamp endTime);
}
