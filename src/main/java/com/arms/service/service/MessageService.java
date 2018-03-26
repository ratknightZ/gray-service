package com.arms.service.service;

import com.arms.service.exception.MessageException;
import com.arms.service.model.Message;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/14
 */
public interface MessageService {

    void add(Message message) throws MessageException;

    List<Message> getMessageList(int userId, int page, int pageSize);

    void deleteByContent(String content);
}
