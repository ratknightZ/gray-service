package com.arms.service.service.imp;

import com.arms.service.dao.MessageDao;
import com.arms.service.dao.UserReadMessageDao;
import com.arms.service.exception.MessageException;
import com.arms.service.model.Message;
import com.arms.service.model.UserReadMessage;
import com.arms.service.service.UserReadMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuchen
 * @since 2017/12/14
 */
@Service("userReadMessageService")
public class UserReadMessageServiceImp implements UserReadMessageService {

    @Resource
    private UserReadMessageDao userReadMessageDao;

    @Resource
    private MessageDao messageDao;

    @Override
    public void add(int userId, long messageId) throws MessageException {
        Message message = messageDao.select(messageId);
        if (message == null){
            throw new MessageException("消息不存在");
        }
        if (message.getToUserId() != 0 && message.getToUserId() != userId){
            throw new MessageException("该消息不属于该用户");
        }
        userReadMessageDao.insert(userId,messageId);
    }

    @Override
    public UserReadMessage get(int userId, long messageId) {
        return userReadMessageDao.select(userId,messageId);
    }
}
