package com.arms.service.service.imp;

import com.arms.common.util.PageUtil;
import com.arms.service.dao.KvsDao;
import com.arms.service.exception.KvsException;
import com.arms.service.model.Kvs;
import com.arms.service.service.KvsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangchaojie on 2016/11/10.
 */
@Service("kvsService")
public class KvsServiceImp implements KvsService {

    @Resource
    private KvsDao kvsDao;

    @Override
    public Kvs get(int id) {
        return kvsDao.select(id);
    }

    @Override
    public Kvs get(String kvsName) {
        return kvsDao.selectByKvsName(kvsName);
    }

    @Override
    public List<Kvs> getByKvsGroup(String kvsGroup) {
        if (StringUtils.isBlank(kvsGroup)) {
            return null;
        }
        return kvsDao.selectByKvsGroup(kvsGroup);
    }

    @Override
    public List<Kvs> get(int page, int pageSize) {
        if (page <= 0 || pageSize <= 0) {
            return null;
        }
        return kvsDao.selectByLimit(PageUtil.getStart(page, pageSize),
            PageUtil.getLimit(page, pageSize));
    }

    @Override
    public void update(Kvs kvs) throws KvsException {
        if (kvs == null) {
            throw new KvsException("Update kvs failed, kvs is null !!");
        }
        kvsDao.update(kvs);
    }

    @Override
    public void add(Kvs kvs) throws KvsException {
        if (kvs == null) {
            throw new KvsException("Add kvs failed, kvs is null !!");
        }
        kvsDao.insert(kvs);
    }

    @Override
    public void delete(int id) {
        kvsDao.delete(id);
    }

}
