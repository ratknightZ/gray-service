package com.arms.service.dao;

import com.arms.service.model.Kvs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangchaojie on 2016/11/10.
 */
public interface KvsDao {

    Kvs select(int id);

    Kvs selectByKvsName(String kvsName);

    List<Kvs> selectByKvsGroup(String kvsGroup);

    List<Kvs> selectByLimit(@Param(value = "start") int start, @Param(value = "limit") int limit);

    int update(Kvs kvs);

    int insert(Kvs kvs);

    void delete(int id);

}
