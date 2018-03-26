package com.arms.service.service.imp;

import com.arms.common.util.PageUtil;
import com.arms.service.dao.BannerDao;
import com.arms.service.exception.BannerException;
import com.arms.service.model.Banner;
import com.arms.service.service.BannerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jinxuan
 * @since 2017/11/22
 */
@Service("bannerService")
public class BannerServiceImp implements BannerService {

    @Resource
    private BannerDao bannerDao;

    @Override
    public void add(Banner banner) throws BannerException {
        if (banner == null) {
            throw new BannerException("Add banner failed, banner is null !!");
        }
        bannerDao.insert(banner);
    }

    @Override
    public void update(Banner banner) throws BannerException {
        if (banner == null) {
            throw new BannerException("Update banner failed, banner is null !!");
        }
        bannerDao.update(banner);
    }

    @Override
    public Banner getByName(String bannerName) {
        if (StringUtils.isBlank(bannerName)) {
            return null;
        }
        return bannerDao.selectByName(bannerName);
    }

    @Override
    public List<Banner> getByGroup(String groupName) {
        if (StringUtils.isBlank(groupName)) {
            return null;
        }
        return bannerDao.selectByGroup(groupName);
    }

    @Override
    public List<Banner> getList(int page, int pageSize) {
        return bannerDao.selectList(PageUtil.getStart(page,pageSize), PageUtil.getLimit(page,pageSize));
    }

    @Override
    public int countAll() {
        return bannerDao.countAll();
    }

    @Override
    public Banner get(int id) {
        return bannerDao.select(id);
    }

    @Override
    public void delete(int id) throws BannerException {
        if (bannerDao.delete(id) != 1){
            throw new BannerException("banner不存在");
        }
    }

}
