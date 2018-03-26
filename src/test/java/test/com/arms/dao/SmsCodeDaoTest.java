package test.com.arms.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.SmsCodeDao;
import com.arms.service.model.SmsCode;

public class SmsCodeDaoTest extends BaseTestCaseJunit {

    @Resource
    private SmsCodeDao smsCodeDao;

    private SmsCode    smsCode;

    @Before
    public void setUp() {
        smsCode = new SmsCode();
        smsCode.setCellphone("18258477020");
        smsCode.setSmsCode("123456");
        smsCode.setSystemTimeMillis(Timestamp.valueOf("2017-04-01 09:33:24").getTime() + "");
        smsCodeDao.insert(smsCode);
    }

    @Test
    public void testSelectById() {
        SmsCode newSmsCode = smsCodeDao.select(smsCode.getId());
        Assert.assertTrue(smsCode.getId() == newSmsCode.getId());
        Assert.assertTrue(smsCode.getCellphone().equals(newSmsCode.getCellphone()));
        Assert.assertTrue(smsCode.getSmsCode().equals(newSmsCode.getSmsCode()));
        Assert.assertTrue(smsCode.getSystemTimeMillis().equals(newSmsCode.getSystemTimeMillis()));
    }

    @Test
    public void testSelectByCellphone() {
        List<SmsCode> smsCodeList = smsCodeDao.selectByCellphone(smsCode.getCellphone());
        Assert.assertTrue(smsCodeList.size() > 0);
    }

    @Test
    public void testSelectLast() {
        SmsCode newSmsCode = smsCodeDao.selectLast(smsCode.getCellphone());
        Assert.assertTrue(smsCode.getId() == newSmsCode.getId());
        Assert.assertTrue(smsCode.getCellphone().equals(newSmsCode.getCellphone()));
        Assert.assertTrue(smsCode.getSmsCode().equals(newSmsCode.getSmsCode()));
        Assert.assertTrue(smsCode.getSystemTimeMillis().equals(newSmsCode.getSystemTimeMillis()));
    }

}
