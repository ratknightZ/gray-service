package com.arms.service.dao;

import com.arms.service.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/14
 */
public interface MessageDao {

    void insert(Message message);

    Message select(long id);

    void update(Message message);

    List<Message> selectByUserId(@Param("userId") int userId, @Param("start") int start, @Param("limit") int limit);

    void deleteByContent(String content);
}
