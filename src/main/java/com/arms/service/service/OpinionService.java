package com.arms.service.service;

import com.arms.service.exception.UserException;
import com.arms.service.model.Opinion;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/12
 */
public interface OpinionService {

    void add(Opinion opinion) throws UserException;

    List<Opinion> getByLimit(int page, int pageSize);

    int count();
}
