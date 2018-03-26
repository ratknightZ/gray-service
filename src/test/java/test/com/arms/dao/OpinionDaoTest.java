package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.OpinionDao;
import com.arms.service.model.Opinion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author liuchen
 * @since 2017/12/12
 */
public class OpinionDaoTest extends BaseTestCaseJunit {

    @Resource
    private OpinionDao opinionDao;

    private Opinion opinion;

    @Before
    public void setUp(){
        opinion = new Opinion();
        opinion.setTheme("theme");
        opinion.setDetail("detail");
        opinion.setEmail("email");
        opinion.setUserId(1);
        opinion.setStatus(1);
        opinionDao.insert(opinion);
    }

    @Test
    public void testSelect(){
        Opinion newOpinion = opinionDao.select(opinion.getId());
        Assert.assertTrue(opinion.getTheme().equals(newOpinion.getTheme()));
        Assert.assertTrue(opinion.getDetail().equals(newOpinion.getDetail()));
        Assert.assertTrue(opinion.getEmail().equals(newOpinion.getEmail()));
        Assert.assertTrue(opinion.getUserId() == newOpinion.getUserId());
        Assert.assertTrue(opinion.getStatus() == newOpinion.getStatus());
    }

    @Test
    public void testUpdate(){
        opinion.setEmail("newEmail");
        opinion.setTheme("newTheme");
        opinion.setDetail("newDetail");
        opinion.setUserId(2);
        opinion.setStatus(2);
        opinionDao.update(opinion);
        Opinion newOpinion = opinionDao.select(opinion.getId());
        Assert.assertTrue(opinion.getTheme().equals(newOpinion.getTheme()));
        Assert.assertTrue(opinion.getDetail().equals(newOpinion.getDetail()));
        Assert.assertTrue(opinion.getEmail().equals(newOpinion.getEmail()));
        Assert.assertTrue(opinion.getUserId() == newOpinion.getUserId());
        Assert.assertTrue(opinion.getStatus() == newOpinion.getStatus());
    }

    @Test
    public void testDelete(){
        opinionDao.delete(opinion.getId());
    }
}
