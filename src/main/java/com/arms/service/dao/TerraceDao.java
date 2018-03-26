package com.arms.service.dao;

import com.arms.service.model.Terrace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchen
 * @since 2017/12/5
 */
public interface TerraceDao {

    void insert(Terrace terrace);

    Terrace select(int id);

    void update(Terrace terrace);

    void delete(int id);

    List<Terrace> selectByCondition(@Param("typeId") int typeId,@Param("showChannel") int showChannel,@Param("maxAmount") int maxAmount,@Param("minAmount") int minAmount,
                             @Param("timeLimit") int timeLimit,@Param("haveCreditCard") int haveCreditCard,
                             @Param("repaymentWay") int repaymentWay,@Param("sortWay") int sortWay,@Param("profession") String profession,
                             @Param("credit") String credit,@Param("lendPurpose") String lendPurpose,
                             @Param("start") int start,@Param("limit") int limit);

    List<Terrace> selectByIsHot(@Param("isHot") int isHot,@Param("showChannel") int showChannel, @Param("start") int start, @Param("limit") int limit);

    List<Terrace> selectByStatus(@Param("status") int status,@Param("terraceName") String terraceName, @Param("start") int start, @Param("limit") int limit);

    int countByStatus(@Param("status") int status,@Param("terraceName") String terraceName);

    List<Integer> selectIdByStatus(@Param("status") int status);

    void addApplyForCount(int id);
}
