package com.arms.service.service.imp;

import com.arms.common.util.PageUtil;
import com.arms.service.dao.OpinionDao;
import com.arms.service.dao.UserDao;
import com.arms.service.exception.UserException;
import com.arms.service.model.Opinion;
import com.arms.service.model.User;
import com.arms.service.service.OpinionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/12
 */
@Service("opinionService")
public class OpinionServiceImp implements OpinionService {

    @Resource
    private OpinionDao opinionDao;

    @Resource
    private UserDao userDao;

    @Override
    public void add(Opinion opinion) throws UserException {
        User user = userDao.select(opinion.getUserId());
        if (user == null){
            throw new UserException("用户不存在");
        }
        opinionDao.insert(opinion);
    }

    @Override
    public List<Opinion> getByLimit(int page, int pageSize) {
        return opinionDao.selectByLimit(PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public int count() {
        return opinionDao.count();
    }
}
