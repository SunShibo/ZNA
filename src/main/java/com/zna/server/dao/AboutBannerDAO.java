package com.zna.server.dao;

import com.zna.server.entity.bo.AboutBannerBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AboutBannerDAO {
    /**
     * 查询banner
     * @param state
     * @return
     */
    List<AboutBannerBO> selectAboutBanner(@Param("state") String state);

    /**
     * 新增banner
     * @param aboutBannerBO
     */
    void addAboutBanner(AboutBannerBO aboutBannerBO);

    /**
     * 修改banner
     * @param aboutBannerBO
     */
    void updateAboutBanner(AboutBannerBO aboutBannerBO);

    /**
     * banner上下架
     * @param state
     * @param updateUserId
     * @param id
     */
    void showOrNotAboutBanner(@Param("state")String state,@Param("updateUserId")Integer updateUserId,@Param("id")Integer id);

    /**
     * 物理删除
     * @param id
     */
    void removeAboutBanner(Integer id);
}
