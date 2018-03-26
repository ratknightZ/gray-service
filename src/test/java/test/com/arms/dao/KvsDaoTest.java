package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.KvsDao;
import com.arms.service.model.Kvs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class KvsDaoTest extends BaseTestCaseJunit {

    @Resource
    private KvsDao kvsDao;

    private Kvs    kvs;

    @Before
    public void setUp() {
        kvs = new Kvs();
        kvs.setKvsName("kvsName");
        kvs.setKvsValue("kvsValue");
        kvs.setKvsGroup("kvsGroup");
        kvsDao.insert(kvs);
    }

    @Test
    public void testSelect() {
        Kvs newKvs = kvsDao.select(kvs.getId());
        Assert.assertTrue(kvs.getKvsName().equals(newKvs.getKvsName()));
        Assert.assertTrue(kvs.getKvsValue().equals(newKvs.getKvsValue()));
        Assert.assertTrue(kvs.getKvsGroup().equals(newKvs.getKvsGroup()));
    }

    @Test
    public void testSelectByKvsName() {
        Kvs newKvs = kvsDao.selectByKvsName(kvs.getKvsName());
        Assert.assertTrue(kvs.getId() == newKvs.getId());
        Assert.assertTrue(kvs.getKvsValue().equals(newKvs.getKvsValue()));
        Assert.assertTrue(kvs.getKvsGroup().equals(newKvs.getKvsGroup()));
    }

    @Test
    public void testSelectByKvsGroup() {
        List<Kvs> kvsList = kvsDao.selectByKvsGroup(kvs.getKvsGroup());
        Assert.assertTrue(kvsList.size() > 0);
    }

    @Test
    public void testUpdate() {
        kvs.setKvsName("newKvsName");
        kvs.setKvsValue("newKvsValue");
        kvs.setKvsGroup("newKvsGroup");
        kvsDao.update(kvs);
        Kvs newKvs = kvsDao.select(kvs.getId());
        Assert.assertTrue(kvs.getKvsName().equals(newKvs.getKvsName()));
        Assert.assertTrue(kvs.getKvsValue().equals(newKvs.getKvsValue()));
        Assert.assertTrue(kvs.getKvsGroup().equals(newKvs.getKvsGroup()));
    }

}
