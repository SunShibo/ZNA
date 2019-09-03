package com.zna.server.service;

import com.zna.server.dao.AboutUsDAO;
import com.zna.server.entity.bo.AboutUsBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("aboutUsService")
@Transactional
public class AboutUsService {
    @Resource
    private AboutUsDAO aboutUsDAO;


    /**
     * 更新关于我们
     * 有数据就修改，没有数据就添加
     * @param pictureUrl
     * @param context
     * @param contextEnglish
     * @param service
     * @param updateUserId
     */
    public void updateAboutUs(String pictureUrl,String pictureUrlPc,String context,String contextEnglish,
                              Integer createUserId,Integer updateUserId){
        AboutUsBO aboutUsBO = new AboutUsBO();
        aboutUsBO.setPictureUrl(pictureUrl);
        aboutUsBO.setPictureUrlPc(pictureUrlPc);
        aboutUsBO.setContext(context);
        aboutUsBO.setContextEnglish(contextEnglish);
        //查询表中数据
        int t = aboutUsDAO.getCount();
        //没有数据就新增
        if (t<1){
            aboutUsBO.setCreateUserId(createUserId);
            aboutUsDAO.addAboutUs(aboutUsBO);
        }else {
            //有数据就修改更新
            aboutUsBO.setUpdateUserId(updateUserId);
            aboutUsDAO.updateAboutUs(aboutUsBO);
        }

    }

    /**
     * 查询
     * @return
     */
    public AboutUsBO getAboutUs(){
        return aboutUsDAO.getAboutUs();
    }

}
