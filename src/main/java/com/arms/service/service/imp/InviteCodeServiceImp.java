package com.arms.service.service.imp;

import com.arms.common.util.InviteCodeUtil;
import com.arms.service.dao.InviteCodeDao;
import com.arms.service.dao.UserDao;
import com.arms.service.model.User;
import com.arms.service.service.InviteCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/26.
 */
@Service("inviteCodeService")
public class InviteCodeServiceImp implements InviteCodeService {

    @Resource
    private UserDao userDao;

    @Resource
    private InviteCodeDao inviteCodeDao;

    @Override
    public String getInviteCode(int userId){
        User user = userDao.select(userId);
        if (user == null) {
            return null;
        }

        String inviteCode = inviteCodeDao.selectInviteCode(userId);
        if (inviteCode == null){
            inviteCode = InviteCodeUtil.toSerialCode(userId);
            inviteCodeDao.insert(userId,inviteCode);
        }
        return inviteCode;
    }

    @Override
    public int getUserId(String inviteCode){
        Integer userId = inviteCodeDao.selectUserId(inviteCode);
        if (userId == null){
            return 0;
        }
        return userId;
    }
}
