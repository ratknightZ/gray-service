package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.VisitRecordDao;
import com.arms.service.enums.UnitOfTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author liuchen
 * @since 2017/12/29
 */
public class VisitRecordDaoTest extends BaseTestCaseJunit {

    @Resource
    private VisitRecordDao visitRecordDao;

    private String ip;

    @Before
    public void setUp(){
        ip = "127.0.0.1";
        visitRecordDao.insert("IOS",ip);
    }

    @Test
    public void testCountByIP(){
        int count = visitRecordDao.countByIP(ip, UnitOfTime.DAY.getValue());
        Assert.assertTrue(count > 0);
    }
}
