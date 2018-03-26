package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.UserDao;
import com.arms.service.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

public class UserDaoTest extends BaseTestCaseJunit {

    @Resource
    private UserDao userDao;

    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setEmail("email");
        user.setCellphone("cellphone");
        user.setPassword("password");
        user.setNick("nick");
        user.setAvatar("avatar");
        user.setWechatOpenId("wechatOpenId");
        userDao.insert(user);
    }

    @Test
    public void testSelect() {
        User newUser = userDao.select(user.getId());
        Assert.assertTrue(user.getEmail().equals(newUser.getEmail()));
        Assert.assertTrue(user.getCellphone().equals(newUser.getCellphone()));
        Assert.assertTrue(user.getPassword().equals(newUser.getPassword()));
        Assert.assertTrue(user.getNick().equals(newUser.getNick()));
        Assert.assertTrue(user.getAvatar().equals(newUser.getAvatar()));
        Assert.assertTrue(user.getWechatOpenId().equals(newUser.getWechatOpenId()));
    }

    @Test
    public void testSelectByEmail() {
        User newUser = userDao.selectByEmail(user.getEmail());
        Assert.assertTrue(user.getId() == newUser.getId());
        Assert.assertTrue(user.getCellphone().equals(newUser.getCellphone()));
        Assert.assertTrue(user.getPassword().equals(newUser.getPassword()));
        Assert.assertTrue(user.getNick().equals(newUser.getNick()));
        Assert.assertTrue(user.getAvatar().equals(newUser.getAvatar()));
        Assert.assertTrue(user.getWechatOpenId().equals(newUser.getWechatOpenId()));
    }

    @Test
    public void testSelectByWechat() {
        User newUser = userDao.selectByWechat(user.getWechatOpenId());
        Assert.assertTrue(user.getId() == newUser.getId());
        Assert.assertTrue(user.getEmail().equals(newUser.getEmail()));
        Assert.assertTrue(user.getCellphone().equals(newUser.getCellphone()));
        Assert.assertTrue(user.getPassword().equals(newUser.getPassword()));
        Assert.assertTrue(user.getNick().equals(newUser.getNick()));
        Assert.assertTrue(user.getAvatar().equals(newUser.getAvatar()));
    }

    @Test
    public void testSelectByCellphone(){
        User newUser = userDao.selectByCellphone(user.getCellphone());
        Assert.assertTrue(user.getId() == newUser.getId());
        Assert.assertTrue(user.getEmail().equals(newUser.getEmail()));
        Assert.assertTrue(user.getWechatOpenId().equals(newUser.getWechatOpenId()));
        Assert.assertTrue(user.getPassword().equals(newUser.getPassword()));
        Assert.assertTrue(user.getNick().equals(newUser.getNick()));
        Assert.assertTrue(user.getAvatar().equals(newUser.getAvatar()));
    }

    @Test
    public void testUpdate() {
        user.setEmail("newEmail");
        user.setPassword("newPassword");
        user.setNick("newNick");
        user.setAvatar("newAvatar");
        user.setWechatOpenId("newWechatOpenId");
        user.setCellphone("newCellphone");
        userDao.update(user);
        User newUser = userDao.select(user.getId());
        Assert.assertTrue(user.getEmail().equals(newUser.getEmail()));
        Assert.assertTrue(user.getCellphone().equals(newUser.getCellphone()));
        Assert.assertTrue(user.getPassword().equals(newUser.getPassword()));
        Assert.assertTrue(user.getNick().equals(newUser.getNick()));
        Assert.assertTrue(user.getAvatar().equals(newUser.getAvatar()));
        Assert.assertTrue(user.getWechatOpenId().equals(newUser.getWechatOpenId()));
    }

}
