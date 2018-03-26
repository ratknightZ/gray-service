package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.TerraceDao;
import com.arms.service.enums.HaveCreditCard;
import com.arms.service.enums.RepaymentWay;
import com.arms.service.enums.Status;
import com.arms.service.model.Terrace;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author liuchen
 * @since 2017/12/5
 */
public class TerraceDaoTest extends BaseTestCaseJunit {

    @Resource
    private TerraceDao terraceDao;

    private Terrace terrace;

    @Before
    public void setUp(){
        terrace = new Terrace();
        terrace.setLogo("");
        terrace.setName("及贷");
        terrace.setRate(0.7);
        terrace.setLendType(1);
        terrace.setQuickestTime(180);
        terrace.setApplyForCondition("除学生外");
        terrace.setNeedInformation("信用卡或淘宝");
        terrace.setRepaymentWay(RepaymentWay.BY_STAGE.getValue());
        terrace.setHaveCreditCard(HaveCreditCard.HAVE.getValue());
        terrace.setMinRepaymentTimeLimit(30);
        terrace.setMaxRepaymentTimeLimit(180);
        terrace.setChoosableRepaymentTimeLimit("30,90,180");
        terrace.setMaxAmount(10000);
        terrace.setMinAmount(1000);
        terrace.setStatus(Status.UP.getValue());
        terrace.setProfession("上班族,个体户,企业主,学生,自由职业");
        terrace.setCredit("无逾期,1年内逾期少于3次,1年内逾期超过3次");
        terrace.setLendPurpose("旅游消费,助学进修,购车消费,婚庆服务,医疗服务,装修建材,百货消费");
        terrace.setUrl("http://www.baidu.com/");
        terrace.setStatus(2);
        terrace.setSuccessCount(0);
        terrace.setApplyForCount(0);
        terrace.setSuccessRate(5);
        terraceDao.insert(terrace);
    }

    @Test
    public void testSelect(){
        Terrace newTerrace = terraceDao.select(terrace.getId());
        Assert.assertTrue(terrace.getLogo().equals(newTerrace.getLogo()));
        Assert.assertTrue(terrace.getName().equals(newTerrace.getName()));
        Assert.assertTrue(terrace.getRate()==newTerrace.getRate());
        Assert.assertTrue(terrace.getLendType()==newTerrace.getLendType());
        Assert.assertTrue(terrace.getQuickestTime()==newTerrace.getQuickestTime());
        Assert.assertTrue(terrace.getApplyForCondition().equals(newTerrace.getApplyForCondition()));
        Assert.assertTrue(terrace.getNeedInformation().equals(newTerrace.getNeedInformation()));
        Assert.assertTrue(terrace.getRepaymentWay()==newTerrace.getRepaymentWay());
        Assert.assertTrue(terrace.getHaveCreditCard()==newTerrace.getHaveCreditCard());
        Assert.assertTrue(terrace.getMinRepaymentTimeLimit()==newTerrace.getMinRepaymentTimeLimit());
        Assert.assertTrue(terrace.getMaxRepaymentTimeLimit()==newTerrace.getMaxRepaymentTimeLimit());
        Assert.assertTrue(terrace.getChoosableRepaymentTimeLimit().equals(newTerrace.getChoosableRepaymentTimeLimit()));
        Assert.assertTrue(terrace.getMaxAmount()==newTerrace.getMaxAmount());
        Assert.assertTrue(terrace.getMinAmount()==newTerrace.getMinAmount());
        Assert.assertTrue(terrace.getStatus()==newTerrace.getStatus());
        Assert.assertTrue(terrace.getProfession().equals(newTerrace.getProfession()));
        Assert.assertTrue(terrace.getCredit().equals(newTerrace.getCredit()));
        Assert.assertTrue(terrace.getLendPurpose().equals(newTerrace.getLendPurpose()));
        Assert.assertTrue(terrace.getUrl().equals(newTerrace.getUrl()));
        Assert.assertTrue(terrace.getStatus()==newTerrace.getStatus());
        Assert.assertTrue(terrace.getApplyForCount() == newTerrace.getApplyForCount());
        Assert.assertTrue(terrace.getSuccessCount() == newTerrace.getSuccessCount());
        Assert.assertTrue(terrace.getSuccessRate() == newTerrace.getSuccessRate());
    }

    @Test
    public void testUpdate(){
        terraceDao.update(terrace);
    }

    @Test
    public void testCountByStatus(){
        int count = terraceDao.countByStatus(2,null);
        Assert.assertTrue(count > 0);
    }

    @Test
    public void testDelete(){
        terraceDao.delete(terrace.getId());
    }

    @Test
    public void testAddApplyForCount(){
        terraceDao.addApplyForCount(terrace.getId());
    }
}
