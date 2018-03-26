package com.arms.service.service;

import com.arms.service.exception.MessageException;
import com.arms.service.model.UserReadMessage;

/**
 * @author liuchen
 * @since 2017/12/14
 */
public interface UserReadMessageService {

    void add(int userId, long messageId) throws MessageException;

    UserReadMessage get(int userId, long messageId);
}
