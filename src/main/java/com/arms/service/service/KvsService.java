package com.arms.service.service;

import com.arms.service.exception.KvsException;
import com.arms.service.model.Kvs;

import java.util.List;

/**
 * Created by zhangchaojie on 2016/11/10.
 */
public interface KvsService {

    Kvs get(int id);

    Kvs get(String kvsName);

    List<Kvs> getByKvsGroup(String kvsGroup);

    List<Kvs> get(int page, int pageSize);

    void update(Kvs kvs) throws KvsException;

    void add(Kvs kvs) throws KvsException;

    void delete(int id);

}
