package com.arms.service.service;

import com.arms.service.exception.UserException;

/**
 * Created by Administrator on 2017/11/26.
 */
public interface SuperiorRelationService {

    void addSuperiorRelation(int userId, int superiorUserId) throws UserException;

    Integer getSuperiorId(int userId);

    int countJunior(int userId);
}
