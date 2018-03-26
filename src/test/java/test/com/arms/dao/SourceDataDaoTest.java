package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.SourceDataDao;
import com.arms.service.model.SourceData;
import org.joda.time.DateTime;
import org.junit.Test;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author liuchen
 * @since 2018/1/3
 */
public class SourceDataDaoTest extends BaseTestCaseJunit {

    @Resource
    private SourceDataDao sourceDataDao;

    @Test
    public void testSelectHistoryData(){
        Timestamp startTime = new Timestamp(DateTime.now().plusDays(-2).getMillis());
        Timestamp endTime = new Timestamp(DateTime.now().getMillis());
        List<SourceData> sourceDataList = sourceDataDao.selectHistoryData(startTime,endTime,null);
    }
}
