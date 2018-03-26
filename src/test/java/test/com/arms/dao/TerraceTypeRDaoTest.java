package test.com.arms.dao;

import com.arms.common.util.PageUtil;
import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.TerraceTypeRDao;
import com.arms.service.model.TerraceTypeR;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/5
 */
public class TerraceTypeRDaoTest extends BaseTestCaseJunit{

    @Resource
    private TerraceTypeRDao terraceTypeRDao;

    private TerraceTypeR terraceTypeR;

    @Before
    public void setUp(){
        terraceTypeR = new TerraceTypeR();
        terraceTypeR.setTypeId(1);
        terraceTypeR.setTerraceId(2);
        terraceTypeRDao.insert(terraceTypeR);
    }

    @Test
    public void testSelectByTypeId(){
        List<TerraceTypeR> terraceTypeRList = terraceTypeRDao.selectByTypeId(terraceTypeR.getTypeId(), PageUtil.getStart(1,12),PageUtil.getLimit(1,12));
        Assert.assertTrue(terraceTypeRList.size() > 0);
    }

    @Test
    public void testSelectByTerraceId(){
        List<TerraceTypeR> terraceTypeRList = terraceTypeRDao.selectByTerraceId(terraceTypeR.getTerraceId());
        Assert.assertTrue(terraceTypeRList.size() > 0);
    }

    @Test
    public void testDelete(){
        terraceTypeRDao.delete(terraceTypeR);
    }
}
