package test.com.arms.dao;

import com.arms.core.BaseTestCaseJunit;
import com.arms.service.dao.MessageDao;
import com.arms.service.model.Message;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/14
 */
public class MessageDaoTest extends BaseTestCaseJunit {

    @Resource
    private MessageDao messageDao;

    private Message message;

    @Before
    public void setUp(){
        message = new Message();
        message.setFromUserId(0);
        message.setToUserId(0);
        message.setTitle("title");
        message.setContent("content");
        messageDao.insert(message);
    }

    @Test
    public void testSelect(){
        Message newMessage = messageDao.select(message.getId());
        Assert.assertTrue(message.getFromUserId() == newMessage.getFromUserId());
        Assert.assertTrue(message.getToUserId() == newMessage.getToUserId());
        Assert.assertTrue(message.getTitle().equals(newMessage.getTitle()));
        Assert.assertTrue(message.getContent().equals(newMessage.getContent()));
    }

    @Test
    public void testUpdate(){
        message.setFromUserId(1);
        message.setToUserId(1);
        message.setTitle("newTitle");
        message.setContent("newContent");
        messageDao.update(message);
        testSelect();
    }

    @Test
    public void testSelectByUserId(){
        List<Message> messageList = messageDao.selectByUserId(message.getToUserId(),0,12);
        Assert.assertTrue(messageList.size() > 0);
    }

    @Test
    public void testDeleteByContent(){
        messageDao.deleteByContent("newContent");
    }
}
