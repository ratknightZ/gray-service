package com.arms.service.service.imp;

import com.arms.common.util.PageUtil;
import com.arms.service.dao.MessageDao;
import com.arms.service.dao.TerraceDao;
import com.arms.service.dao.UserDao;
import com.arms.service.exception.MessageException;
import com.arms.service.model.Message;
import com.arms.service.model.Terrace;
import com.arms.service.model.User;
import com.arms.service.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/14
 */
@Service("messageService")
public class MessageServiceImp implements MessageService {

    @Resource
    private MessageDao messageDao;

    @Resource
    private UserDao userDao;

    @Resource
    private TerraceDao terraceDao;

    @Override
    public void add(Message message) throws MessageException {
        User fromUser = userDao.select(message.getFromUserId());
        if (message.getFromUserId() != 0 && fromUser == null){
            throw new MessageException("发送用户不存在");
        }
        User toUser = userDao.select(message.getToUserId());
        if (message.getToUserId() != 0 && toUser == null){
            throw new MessageException("接收用户不存在");
        }
        Terrace terrace = terraceDao.select(Integer.parseInt(message.getContent()));
        if (terrace == null){
            throw new MessageException("平台不存在");
        }
        messageDao.insert(message);
    }

    @Override
    public List<Message> getMessageList(int userId, int page, int pageSize) {
        return messageDao.selectByUserId(userId, PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public void deleteByContent(String content) {
        messageDao.deleteByContent(content);
    }
}
