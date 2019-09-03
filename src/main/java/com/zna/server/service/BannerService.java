package com.zna.server.service;

import com.zna.server.dao.BannerDAO;
import com.zna.server.entity.bo.BannerBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("bannerService")
@Transactional
public class BannerService {
    @Resource
    private BannerDAO bannerDAO;


    /**
     * 查询banner
     * @param state
     * @return
     */
    public List<BannerBO> selectBanner(String state){
        return bannerDAO.selectBanner(state);
    }

    /**
     *  新增banner
     * @param pictureUrl
     * @param skipUrl
     * @param skipType
     * @param skipId
     * @param sort
     * @param state
     * @param createUserId
     */
    public void addBanner(BannerBO bannerBO){
        bannerDAO.addBanner(bannerBO);
    }

    /**
     * 修改banner
     * @param pictureUrl
     * @param skipUrl
     * @param skipType
     * @param skipId
     * @param sort
     * @param state
     * @param updateUserId
     */
    public void updateBanner(Integer id,String pictureUrl,String pictureUrlPc,String skipUrl,String skipType,Integer skipId,Integer sort,String state,Integer updateUserId){
        BannerBO bannerBO = new BannerBO();
        bannerBO.setId(id);
        bannerBO.setPictureUrl(pictureUrl);
        bannerBO.setPictureUrlPc(pictureUrlPc);
        bannerBO.setSkipUrl(skipUrl);
        bannerBO.setSkipType(skipType);
        bannerBO.setSkipId(skipId);
        bannerBO.setSort(sort);
        bannerBO.setState(state);
        bannerBO.setUpdateUserId(updateUserId);
        bannerDAO.updateBanner(bannerBO);
    }

    /**
     * banner上下架
     * @param state
     * @param updateUserId
     * @param id
     */
    public void showOrNotBanner(String state,Integer updateUserId,Integer id){
        bannerDAO.showOrNotBanner(state,updateUserId,id);
    }

    /**
     * 物理删除
     * @param id
     */
    public void removeBanner(Integer id){
        bannerDAO.removeBanner(id);
    }
}
