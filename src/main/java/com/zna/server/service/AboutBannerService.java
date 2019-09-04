package com.zna.server.service;

import com.zna.server.dao.AboutBannerDAO;
import com.zna.server.entity.bo.AboutBannerBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("aboutBannerService")
@Transactional
public class AboutBannerService {
    @Resource
    private AboutBannerDAO aboutBannerDAO;

    /**
     * 查询banner
     * @param state
     * @return
     */
    public List<AboutBannerBO> selectAboutBanner(String state){
        return aboutBannerDAO.selectAboutBanner(state);
    }

    /**
     *  新增banner
     *  pictureUrl
     *  skipUrl
     *  skipType
     *  skipId
     *  sort
     *  state
     *  createUserId
     */
    public void addAboutBanner(AboutBannerBO aboutBannerBO){
        aboutBannerDAO.addAboutBanner(aboutBannerBO);
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
    public void updateAboutBanner(Integer id,String pictureUrl,String pictureUrlPc,String skipUrl,String skipType,Integer skipId,Integer sort,String state,Integer updateUserId){
        AboutBannerBO bannerBO = new AboutBannerBO();
        bannerBO.setId(id);
        bannerBO.setPictureUrl(pictureUrl);
        bannerBO.setPictureUrlPc(pictureUrlPc);
        bannerBO.setSkipUrl(skipUrl);
        bannerBO.setSkipType(skipType);
        bannerBO.setSkipId(skipId);
        bannerBO.setSort(sort);
        bannerBO.setState(state);
        bannerBO.setUpdateUserId(updateUserId);
        aboutBannerDAO.updateAboutBanner(bannerBO);
    }

    /**
     * banner上下架
     * @param state
     * @param updateUserId
     * @param id
     */
    public void showOrNotAboutBanner(String state,Integer updateUserId,Integer id){
        aboutBannerDAO.showOrNotAboutBanner(state,updateUserId,id);
    }

    /**
     * 物理删除
     * @param id
     */
    public void removeAboutBanner(Integer id){
        aboutBannerDAO.removeAboutBanner(id);
    }
}
