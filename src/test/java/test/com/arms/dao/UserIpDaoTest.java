package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.UserDao;
import com.arms.service.dao.UserIpDao;
import com.arms.service.model.User;
import com.arms.service.model.UserIp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author liuchen
 * @since 2018/1/18
 */
public class UserIpDaoTest extends BaseTestCaseJunit {

    @Resource
    private UserIpDao userIpDao;

    private UserIp userIp;

    @Resource
    private UserDao userDao;

    private User user;

    @Before
    public void setUp(){
        user = new User();
        user.setEmail("email");
        user.setCellphone("cellphone");
        user.setPassword("password");
        user.setNick("nick");
        user.setAvatar("avatar");
        user.setWechatOpenId("wechatOpenId");
        userDao.insert(user);
        userIp = new UserIp();
        userIp.setUserId(user.getId());
        userIp.setIp("127.0.0.1");
        userIpDao.insert(userIp);
    }

    @Test
    public void testSelect(){
        UserIp newUserIp = userIpDao.select(user.getId());
        Assert.assertTrue(userIp.getUserId() == newUserIp.getUserId());
        Assert.assertTrue(userIp.getIp().equals(newUserIp.getIp()));
    }
}
