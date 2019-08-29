package com.zna.server.service;

import com.zna.server.dao.RecentNewsDAO;
import com.zna.server.entity.bo.RecentNewsBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("recentNewsService")
@Transactional
public class RecentNewsService {
    @Resource
    private RecentNewsDAO recentNewsDAO;

    public void addRecentNews(String pictureUrl,String title,String titleEnglish,String time,String context,String contextEnglish,Integer sort,Integer createUserId){
        RecentNewsBO recentNewsBO = new RecentNewsBO();
        recentNewsBO.setPictureUrl(pictureUrl);
        recentNewsBO.setTitle(title);
        recentNewsBO.setTitleEnglish(titleEnglish);
        recentNewsBO.setTime(time);
        recentNewsBO.setContext(context);
        recentNewsBO.setContextEnglish(contextEnglish);
        recentNewsBO.setSort(sort);
        recentNewsBO.setCreateUserId(createUserId);
        recentNewsDAO.addRecentNews(recentNewsBO);
    }

    public void delRecentNews(Integer id){
        recentNewsDAO.delRecentNews(id);
    }

    public void updateRecentNews(Integer id,String pictureUrl,String title,String titleEnglish,String time,String context,String contextEnglish,Integer sort,Integer updateUserId){
        RecentNewsBO recentNewsBO = new RecentNewsBO();
        recentNewsBO.setId(id);
        recentNewsBO.setPictureUrl(pictureUrl);
        recentNewsBO.setTitle(title);
        recentNewsBO.setTitleEnglish(titleEnglish);
        recentNewsBO.setTime(time);
        recentNewsBO.setContext(context);
        recentNewsBO.setContextEnglish(contextEnglish);
        recentNewsBO.setSort(sort);
        recentNewsBO.setUpdateUserId(updateUserId);
        recentNewsDAO.updateRecentNews(recentNewsBO);
    }

    public List<RecentNewsBO> selectRecentNews(Integer id,Integer pageOffset,Integer pageSize){
        return recentNewsDAO.selectRecentNews(id,pageOffset,pageSize);
    }

    public Integer getCount(Integer id){
        return recentNewsDAO.getCount(id);
    }

}
