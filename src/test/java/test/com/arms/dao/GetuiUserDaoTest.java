package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.GetuiUserDao;
import com.arms.service.dao.UserDao;
import com.arms.service.enums.Device;
import com.arms.service.model.GetuiUser;
import com.arms.service.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author jinxuan
 * @since 2017/12/5
 */
public class GetuiUserDaoTest extends BaseTestCaseJunit {

    @Resource
    private UserDao userDao;

    private User user;

    @Resource
    private GetuiUserDao getuiUserDao;

    private GetuiUser getuiUser;

    @Before
    public void setUp() {
        user = new User();
        user.setEmail("email");
        user.setPassword("password");
        user.setNick("nick");
        user.setAvatar("avatar");
        user.setWechatOpenId("wechatOpenId");
        userDao.insert(user);
        getuiUser = new GetuiUser();
        getuiUser.setUserId(user.getId());
        getuiUser.setCid("cid");
        getuiUser.setDevice(Device.ANDROID.getValue());
        getuiUserDao.insert(getuiUser);
    }

    @Test
    public void testSelect() {
        GetuiUser newGetuiUser = getuiUserDao.select(getuiUser.getId());
        Assert.assertTrue(getuiUser.getUserId() == newGetuiUser.getUserId());
        Assert.assertTrue(getuiUser.getCid().equals(newGetuiUser.getCid()));
        Assert.assertTrue(getuiUser.getDevice() == newGetuiUser.getDevice());
    }

    @Test
    public void testSelectByUserId() {
        GetuiUser newGetuiUser = getuiUserDao.selectByUserId(getuiUser.getUserId());
        Assert.assertTrue(getuiUser.getId() == newGetuiUser.getId());
        Assert.assertTrue(getuiUser.getCid().equals(newGetuiUser.getCid()));
        Assert.assertTrue(getuiUser.getDevice() == newGetuiUser.getDevice());
    }

    @Test
    public void testSelectByCid() {
        GetuiUser newGetuiUser = getuiUserDao.selectByCid(getuiUser.getCid());
        Assert.assertTrue(getuiUser.getUserId() == newGetuiUser.getUserId());
        Assert.assertTrue(getuiUser.getId() == newGetuiUser.getId());
        Assert.assertTrue(getuiUser.getDevice() == newGetuiUser.getDevice());
    }

    @Test
    public void testUpdate() {
        getuiUser.setCid("newCid");
        getuiUserDao.update(getuiUser);
        GetuiUser newGetuiUser = getuiUserDao.select(getuiUser.getId());
        Assert.assertTrue(getuiUser.getUserId() == newGetuiUser.getUserId());
        Assert.assertTrue(getuiUser.getCid().equals(newGetuiUser.getCid()));
        Assert.assertTrue(getuiUser.getDevice() == newGetuiUser.getDevice());
    }

}
