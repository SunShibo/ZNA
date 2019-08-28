package com.zna.server.dao;

import com.zna.server.entity.bo.BannerBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDAO {
    /**
     * 查询banner
     * @param state
     * @return
     */
    List<BannerBO> selectBanner(@Param("state") String state);

    /**
     * 新增banner
     * @param bannerBO
     */
    void addBanner(BannerBO bannerBO);

    /**
     * 修改banner
     * @param bannerBO
     */
    void updateBanner(BannerBO bannerBO);

    /**
     * banner上下架
     * @param state
     * @param updateUserId
     * @param id
     */
    void showOrNotBanner(@Param("state")String state,@Param("updateUserId")Integer updateUserId,@Param("id")Integer id);

    /**
     * 物理删除
     * @param id
     */
    void removeBanner(Integer id);
}
