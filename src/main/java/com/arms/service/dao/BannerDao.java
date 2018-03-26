package com.arms.service.dao;

import com.arms.service.model.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author jinxuan
 * @since 2017/11/22
 */
public interface BannerDao {

    int insert(Banner banner);

    int update(Banner banner);

    Banner select(int id);

    Banner selectByName(String bannerName);

    List<Banner> selectByGroup(String groupName);

    List<Banner> selectList(@Param("start") int start, @Param("limit") int limit);

    int countAll();

    int delete(int id);

}
