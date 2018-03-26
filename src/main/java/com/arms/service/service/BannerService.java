package com.arms.service.service;

import com.arms.service.exception.BannerException;
import com.arms.service.model.Banner;

import java.util.List;

/**
 * @author jinxuan
 * @since 2017/11/22
 */
public interface BannerService {

    void add(Banner banner) throws BannerException;

    void update(Banner banner) throws BannerException;

    Banner getByName(String bannerName);

    List<Banner> getByGroup(String groupName);

    List<Banner> getList(int page, int pageSize);

    int countAll();

    Banner get(int id);

    void delete(int id) throws BannerException;

}
