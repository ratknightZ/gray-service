package com.arms.service.service.imp;

import com.arms.common.util.PageUtil;
import com.arms.service.dao.TerraceTypeRDao;
import com.arms.service.enums.TerraceType;
import com.arms.service.exception.TerraceException;
import com.arms.service.model.TerraceTypeR;
import com.arms.service.service.TerraceTypeRService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/5
 */
@Service("terraceTypeRService")
public class TerraceTypeRServiceImp implements TerraceTypeRService{

    @Resource
    private TerraceTypeRDao terraceTypeRDao;

    @Override
    public List<TerraceTypeR> getListByTypeId(int typeId, int page, int pageSize) {
        return terraceTypeRDao.selectByTypeId(typeId, PageUtil.getStart(page,pageSize),PageUtil.getLimit(page,pageSize));
    }

    @Override
    public List<TerraceTypeR> getListByTerraceId(int terraceId) {
        return terraceTypeRDao.selectByTerraceId(terraceId);
    }

    @Override
    public void addTerraceTypeRelation(int terraceId, String terraceTypeIds) throws TerraceException {
        terraceTypeRDao.deleteByTerraceId(terraceId);
        String[] terraceTypeArrayS = terraceTypeIds.split(",");
        int[] terraceTypeArrayI = new int[terraceTypeArrayS.length];
        try {
            for (int i = 0;i < terraceTypeArrayS.length;i++){
                terraceTypeArrayI[i] = Integer.parseInt(terraceTypeArrayS[i]);
                if (TerraceType.getTerraceType(terraceTypeArrayI[i]) == null){
                    throw new TerraceException("参数错误,terraceTypes: " + terraceTypeIds);
                }
            }
        } catch (NumberFormatException e) {
            throw new TerraceException("参数错误,terraceTypes: " + terraceTypeIds);
        }
        TerraceTypeR terraceTypeR = new TerraceTypeR();
        terraceTypeR.setTerraceId(terraceId);
        for (int terraceType : terraceTypeArrayI){
            terraceTypeR.setTypeId(terraceType);
            terraceTypeRDao.insert(terraceTypeR);
        }
    }
}
