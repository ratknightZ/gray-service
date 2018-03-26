package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.TerraceNotifyDao;
import com.arms.service.model.TerraceNotify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/12
 */
public class TerraceNotifyDaoTest extends BaseTestCaseJunit {

    @Resource
    private TerraceNotifyDao terraceNotifyDao;

    private TerraceNotify terraceNotify;

    @Before
    public void setUp(){
        terraceNotify = new TerraceNotify();
        terraceNotify.setCellphone("cellphone");
        terraceNotify.setTimeLimit(30);
        terraceNotify.setAmount(500);
        terraceNotify.setTerraceId(1);
        terraceNotifyDao.insert(terraceNotify);
    }

    @Test
    public void testSelect(){
        TerraceNotify newTerraceNotify = terraceNotifyDao.select(terraceNotify.getId());
        Assert.assertTrue(terraceNotify.getCellphone().equals(newTerraceNotify.getCellphone()));
        Assert.assertTrue(terraceNotify.getAmount() == newTerraceNotify.getAmount());
        Assert.assertTrue(terraceNotify.getTerraceId() == newTerraceNotify.getTerraceId());
        Assert.assertTrue(terraceNotify.getTimeLimit() == newTerraceNotify.getTimeLimit());
    }

    @Test
    public void testSelectByCellphone(){
        List<TerraceNotify> terraceNotifyList = terraceNotifyDao.selectByCellphone("cellphone",0,11);
        Assert.assertTrue(terraceNotifyList.size() > 0);
    }
}
