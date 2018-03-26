package com.arms.service.service.imp;

import com.arms.common.util.PageUtil;
import com.arms.service.bo.UserLendSourceIpBo;
import com.arms.service.dao.UserDao;
import com.arms.service.enums.RoleAuth;
import com.arms.service.exception.UserException;
import com.arms.service.model.User;
import com.arms.service.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service("userService")
public class UserServiceImp implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    //    @Cacheable(value = "userCache", key = "'userId:'+#id")
    public User get(int id) {
        if (id <= 0) {
            return null;
        }
        return userDao.select(id);
    }

    @Override
    public void add(User user) throws UserException {
        if (user == null) {
            throw new UserException("添加用户失败");
        }
        userDao.insert(user);
    }

    @Override
    //    @CacheEvict(value = "userCache", key = "'userId:'+#user.getId()")
    public void update(User user) throws UserException {
        if (user == null) {
            throw new UserException("更新用户失败");
        }
        userDao.update(user);
    }

    @Override
    public User getByWechat(String wechatOpenId) {
        if (StringUtils.isBlank(wechatOpenId)) {
            return null;
        }
        return userDao.selectByWechat(wechatOpenId);
    }

    @Override
    public User getByEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return null;
        }
        return userDao.selectByEmail(email);
    }

    @Override
    public User getByCellphone(String cellphone) {
        if (StringUtils.isBlank(cellphone)) {
            return null;
        }
        return userDao.selectByCellphone(cellphone);
    }

    @Override
    public List<User> getByRoleAuth(RoleAuth roleAuth, int page, int pageSize) {
        return userDao.selectByRoleAuth(roleAuth.getValue(), PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public int countByRoleAuth(Timestamp startTime, Timestamp endTime, RoleAuth roleAuth) {
        if (roleAuth == null){
            return userDao.countByRoleAuth(startTime,endTime,null);
        }else {
            return userDao.countByRoleAuth(startTime,endTime,roleAuth.getValue());
        }
    }

    @Override
    public List<UserLendSourceIpBo> getUserLendInfoBo(Timestamp startTime, Timestamp endTime, int page, int pageSize) {
        return userDao.selectUserLendSourceIpBo(startTime,endTime,PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

}
