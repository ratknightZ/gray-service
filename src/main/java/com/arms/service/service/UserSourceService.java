package com.arms.service.service;

import com.arms.service.exception.UserException;

/**
 * @author liuchen
 * @since 2017/12/29
 */
public interface UserSourceService {

    void add(int userId, String source) throws UserException;

    String get(int userId);
}
