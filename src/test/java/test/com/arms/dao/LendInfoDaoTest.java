package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.LendInfoDao;
import com.arms.service.model.LendInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/7
 */
public class LendInfoDaoTest extends BaseTestCaseJunit {

    @Resource
    private LendInfoDao lendInfoDao;

    private LendInfo lendInfo;

    @Before
    public void setUp(){
        lendInfo = new LendInfo();
        lendInfo.setUserId(1);
        lendInfo.setTerraceId(1);
        lendInfo.setName("liuchen");
        lendInfo.setIdCard("123456");
        lendInfo.setLendPurpose("旅游消费");
        lendInfo.setApplyForAmount(1000);
        lendInfo.setTimeLimit(30);
        lendInfo.setProfession("上班族");
        lendInfoDao.insert(lendInfo);
    }

    @Test
    public void testSelect(){
        LendInfo newLendInfo = lendInfoDao.select(lendInfo.getUserId());
        Assert.assertTrue(lendInfo.getUserId()==newLendInfo.getUserId());
        Assert.assertTrue(lendInfo.getName().equals(newLendInfo.getName()));
        Assert.assertTrue(lendInfo.getIdCard().equals(newLendInfo.getIdCard()));
        Assert.assertTrue(lendInfo.getLendPurpose().equals(newLendInfo.getLendPurpose()));
        Assert.assertTrue(lendInfo.getApplyForAmount()==newLendInfo.getApplyForAmount());
        Assert.assertTrue(lendInfo.getTimeLimit()==newLendInfo.getTimeLimit());
        Assert.assertTrue(lendInfo.getProfession().equals(newLendInfo.getProfession()));
    }

    @Test
    public void testUpdate(){
        lendInfoDao.update(lendInfo);
    }

    @Test
    public void testSelectList(){
        List<LendInfo> lendInfoList = lendInfoDao.selectList(null,null,1,12);
        //Assert.assertTrue(lendInfoList.size() > 0);
    }
}
