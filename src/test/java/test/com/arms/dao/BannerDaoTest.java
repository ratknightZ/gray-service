package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.BannerDao;
import com.arms.service.enums.BannerRedirectType;
import com.arms.service.model.Banner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jinxuan
 * @since 2017/11/22
 */
public class BannerDaoTest extends BaseTestCaseJunit {

    @Resource
    private BannerDao bannerDao;

    private Banner banner;

    @Before
    public void setUp() {
        banner = new Banner();
        banner.setBannerName("bannerName");
        banner.setRedirectType(BannerRedirectType.H5.getValue());
        banner.setHoverTip("hoverTip");
        banner.setPicUrl("picUrl");
        banner.setLinkUrl("linkUrl");
        banner.setGroupName("groupName");
        banner.setDescription("description");
        bannerDao.insert(banner);
    }

    @Test
    public void testSelect() {
        Banner newBanner = bannerDao.select(banner.getId());
        Assert.assertTrue(banner.getBannerName().equals(newBanner.getBannerName()));
        Assert.assertTrue(banner.getRedirectType() == newBanner.getRedirectType());
        Assert.assertTrue(banner.getHoverTip().equals(newBanner.getHoverTip()));
        Assert.assertTrue(banner.getPicUrl().equals(newBanner.getPicUrl()));
        Assert.assertTrue(banner.getLinkUrl().equals(newBanner.getLinkUrl()));
        Assert.assertTrue(banner.getGroupName().equals(newBanner.getGroupName()));
        Assert.assertTrue(banner.getDescription().equals(newBanner.getDescription()));
    }

    @Test
    public void testSelectByName() {
        Banner newBanner = bannerDao.selectByName(banner.getBannerName());
        Assert.assertTrue(banner.getId() == newBanner.getId());
        Assert.assertTrue(banner.getRedirectType() == newBanner.getRedirectType());
        Assert.assertTrue(banner.getHoverTip().equals(newBanner.getHoverTip()));
        Assert.assertTrue(banner.getPicUrl().equals(newBanner.getPicUrl()));
        Assert.assertTrue(banner.getLinkUrl().equals(newBanner.getLinkUrl()));
        Assert.assertTrue(banner.getGroupName().equals(newBanner.getGroupName()));
        Assert.assertTrue(banner.getDescription().equals(newBanner.getDescription()));
    }

    @Test
    public void testSelectByGroup() {
        List<Banner> bannerList = bannerDao.selectByGroup(banner.getGroupName());
        Assert.assertTrue(bannerList.size() > 0);
    }

    @Test
    public void testUpdate() {
        banner.setBannerName("newBannerName");
        banner.setRedirectType(BannerRedirectType.NATIVE.getValue());
        banner.setHoverTip("newHoverTip");
        banner.setPicUrl("newPicUrl");
        banner.setLinkUrl("newLinkUrl");
        banner.setGroupName("newGroupName");
        banner.setDescription("newDescription");
        bannerDao.update(banner);
        Banner newBanner = bannerDao.select(banner.getId());
        Assert.assertTrue(banner.getBannerName().equals(newBanner.getBannerName()));
        Assert.assertTrue(banner.getRedirectType() == newBanner.getRedirectType());
        Assert.assertTrue(banner.getHoverTip().equals(newBanner.getHoverTip()));
        Assert.assertTrue(banner.getPicUrl().equals(newBanner.getPicUrl()));
        Assert.assertTrue(banner.getLinkUrl().equals(newBanner.getLinkUrl()));
        Assert.assertTrue(banner.getGroupName().equals(newBanner.getGroupName()));
        Assert.assertTrue(banner.getDescription().equals(newBanner.getDescription()));
    }

}
