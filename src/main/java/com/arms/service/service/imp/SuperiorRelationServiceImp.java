package com.arms.service.service.imp;

import com.arms.service.dao.SuperiorRelationDao;
import com.arms.service.dao.UserDao;
import com.arms.service.exception.UserException;
import com.arms.service.service.SuperiorRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/26.
 */
@Service("superiorRelationService")
public class SuperiorRelationServiceImp implements SuperiorRelationService {

    @Resource
    private UserDao userDao;

    @Resource
    private SuperiorRelationDao superiorRelationDao;

    @Override
    public void addSuperiorRelation(int userId,int superiorUserId) throws UserException {
        if (userDao.select(userId) == null){
            throw new UserException("用户不存在 userId: " + userId);
        }

        if (userDao.select(superiorUserId) == null){
            throw new UserException("用户不存在 superiorUserId: " + superiorUserId);
        }

        if (userId == superiorUserId){
            throw new UserException("上级用户ID与当前用户ID相同");
        }

        Integer existingSuperiorUserId = superiorRelationDao.selectSuperiorId(userId);
        if (existingSuperiorUserId != null){
            throw new UserException("当前用户已存在上级，existingSuperiorUserId: " + existingSuperiorUserId);
        }

        superiorRelationDao.insert(userId,superiorUserId);
    }

    @Override
    public Integer getSuperiorId(int userId) {
        if (userDao.select(userId) == null){
            return null;
        }
        return superiorRelationDao.selectSuperiorId(userId);
    }

    @Override
    public int countJunior(int userId) {
        return superiorRelationDao.countJunior(userId);
    }
}
