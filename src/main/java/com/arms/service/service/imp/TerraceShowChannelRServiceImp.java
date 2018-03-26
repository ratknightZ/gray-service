package com.arms.service.service.imp;

import com.arms.service.dao.TerraceShowChannelRDao;
import com.arms.service.enums.ShowChannel;
import com.arms.service.exception.TerraceException;
import com.arms.service.model.TerraceShowChannelR;
import com.arms.service.service.TerraceShowChannelRService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuchen
 * @since 2018/2/28
 */
@Service("terraceShowChannelRService")
public class TerraceShowChannelRServiceImp implements TerraceShowChannelRService {

    @Resource
    private TerraceShowChannelRDao terraceShowChannelRDao;

    @Override
    public void add(int terraceId, String showChannelIds) throws TerraceException {
        terraceShowChannelRDao.deleteByTerraceId(terraceId);
        String[] showChannelArrayStr = showChannelIds.split(",");
        int[] showChannelArrayInt = new int[showChannelArrayStr.length];
        try {
            for (int i = 0;i < showChannelArrayStr.length;i++){
                showChannelArrayInt[i] = Integer.parseInt(showChannelArrayStr[i]);
                if (ShowChannel.getShowChannel(showChannelArrayInt[i]) == null){
                    throw new TerraceException("参数错误,showChannelIds: " + showChannelIds);
                }
            }
        } catch (NumberFormatException e) {
            throw new TerraceException("参数错误,showChannelIds: " + showChannelIds);
        }
        TerraceShowChannelR terraceShowChannelR = new TerraceShowChannelR();
        terraceShowChannelR.setTerraceId(terraceId);
        for (int showChannel : showChannelArrayInt){
            terraceShowChannelR.setShowChannelId(showChannel);
            terraceShowChannelRDao.insert(terraceShowChannelR);
        }
    }

    @Override
    public List<TerraceShowChannelR> getByTerraceId(int terraceId) {
        return terraceShowChannelRDao.selectByTerraceId(terraceId);
    }
}
