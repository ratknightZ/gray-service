package com.arms.service.service;

import com.arms.service.enums.Status;
import com.arms.service.exception.TerraceException;
import com.arms.service.model.Terrace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/5
 */
public interface TerraceService {

    Terrace get(int id);

    void add(Terrace terrace, String terraceTypes, String showChannels) throws TerraceException;

    void update(Terrace terrace, String terraceTypes, String showChannels) throws TerraceException;

    List<Terrace> getList(int typeId, int showChannel, int maxAmount, int minAmount, int timeLimit, int haveCreditCard,
                          int repaymentWay, int sortWay, String profession, String credit,
                          String lendPurpose, int page, int pageSize);

    List<Terrace> getList(int isHot, int showChannel, int page, int pageSize);

    List<Terrace> getListByStatus(int status, String terraceName, int page, int pageSize);

    int countByStatus(int status, String terraceName);

    void delete(int id);

    List<Integer> getIdList(int status);

    void addApplyForCount(@Param("id") int id);
}
