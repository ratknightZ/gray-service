package com.arms.service.service.imp;

import com.arms.common.util.PageUtil;
import com.arms.service.dao.MessageDao;
import com.arms.service.dao.TerraceDao;
import com.arms.service.dao.TerraceTypeRDao;
import com.arms.service.enums.Status;
import com.arms.service.enums.UnitOfQuickestTime;
import com.arms.service.enums.UnitOfRate;
import com.arms.service.enums.UnitOfRepaymentTime;
import com.arms.service.exception.TerraceException;
import com.arms.service.model.Terrace;
import com.arms.service.service.TerraceService;
import com.arms.service.service.TerraceShowChannelRService;
import com.arms.service.service.TerraceTypeRService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/5
 */
@Service("terraceService")
public class TerraceServiceImp implements TerraceService {

    @Resource
    private TerraceDao terraceDao;

    @Resource
    private TerraceTypeRService terraceTypeRService;

    @Resource
    private TerraceTypeRDao terraceTypeRDao;

    @Resource
    private MessageDao messageDao;

    @Resource
    private TerraceShowChannelRService terraceShowChannelRService;

    @Override
    public Terrace get(int id) {
        return terraceDao.select(id);
    }

    @Override
    @Transactional
    public void add(Terrace terrace, String terraceTypes, String showChannels) throws TerraceException {
        dealTerraceData(terrace);
        terraceDao.insert(terrace);
        terraceTypeRService.addTerraceTypeRelation(terrace.getId(),terraceTypes);
        terraceShowChannelRService.add(terrace.getId(),showChannels);
    }

    @Override
    @Transactional
    public void update(Terrace terrace, String terraceTypes, String showChannels) throws TerraceException {
        dealTerraceData(terrace);
        terraceDao.update(terrace);
        if (StringUtils.isNotBlank(terraceTypes)){
            terraceTypeRService.addTerraceTypeRelation(terrace.getId(),terraceTypes);
        }
        if (StringUtils.isNotBlank(showChannels)){
            terraceShowChannelRService.add(terrace.getId(),showChannels);
        }
    }

    @Override
    public List<Terrace> getList(int typeId, int showChannel, int maxAmount, int minAmount, int timeLimit, int haveCreditCard, int repaymentWay, int sortWay, String profession, String credit, String lendPurpose, int page, int pageSize) {
        return terraceDao.selectByCondition(typeId,showChannel,maxAmount,minAmount,timeLimit,haveCreditCard,repaymentWay,sortWay,profession,credit,lendPurpose,
                PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public List<Terrace> getList(int isHot, int showChannel, int page, int pageSize) {
        return terraceDao.selectByIsHot(isHot,showChannel,PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public List<Terrace> getListByStatus(int status, String terraceName, int page, int pageSize) {
        return terraceDao.selectByStatus(status,terraceName,PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public int countByStatus(int status, String terraceName) {
        return terraceDao.countByStatus(status,terraceName);
    }

    @Override
    @Transactional
    public void delete(int id) {
        terraceDao.delete(id);
        terraceTypeRDao.deleteByTerraceId(id);
        messageDao.deleteByContent(id + "");
    }

    @Override
    public List<Integer> getIdList(int status) {
        return terraceDao.selectIdByStatus(status);
    }

    @Override
    public void addApplyForCount(int id) {
        terraceDao.addApplyForCount(id);
    }

    private void dealTerraceData(Terrace terrace){
        terrace.setName(terrace.getName().replace(" ",""));
        terrace.setUrl(terrace.getUrl().replace(" ",""));
        if (terrace.getUnitOfQuickestTime() == UnitOfQuickestTime.MINUTE.getValue()){
            terrace.setQuickestTimeSecond((int)(terrace.getQuickestTime() * 60));
        }else if (terrace.getUnitOfQuickestTime() == UnitOfQuickestTime.SECOND.getValue()){
            terrace.setQuickestTimeSecond((int)terrace.getQuickestTime());
            terrace.setQuickestTime(terrace.getQuickestTime() / 60);
        }
        if (terrace.getUnitOfRate() == UnitOfRate.RATE_MONTH.getValue()){
            terrace.setRateDay(terrace.getRate() / 30);
        }else if (terrace.getUnitOfRate() == UnitOfRate.RATE_DAY.getValue()){
            terrace.setRateDay(terrace.getRate());
            terrace.setRate(terrace.getRate() * 30);
        }
    }
}
