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

    public void addRecentNews(RecentNewsBO recentNewsBO){
        recentNewsDAO.addRecentNews(recentNewsBO);
    }

    public void delRecentNews(Integer id){
        recentNewsDAO.delRecentNews(id);
    }

    public void updateRecentNews(Integer id,String pictureUrl,String pictureUrlPc,String title,String titleEnglish,String time,String context,String contextEnglish,Integer sort,Integer updateUserId){
        RecentNewsBO recentNewsBO = new RecentNewsBO();
        recentNewsBO.setId(id);
        recentNewsBO.setPictureUrl(pictureUrl);
        recentNewsBO.setPictureUrlPc(pictureUrlPc);
        recentNewsBO.setTitle(title);
        recentNewsBO.setTitleEnglish(titleEnglish);
        recentNewsBO.setTime(time);
        recentNewsBO.setContext(context);
        recentNewsBO.setContextEnglish(contextEnglish);
        recentNewsBO.setSort(sort);
        recentNewsBO.setUpdateUserId(updateUserId);
        recentNewsDAO.updateRecentNews(recentNewsBO);
    }

    public List<RecentNewsBO> selectRecentNews(String title,Integer id,Integer pageOffset,Integer pageSize){
        return recentNewsDAO.selectRecentNews(title,id,pageOffset,pageSize);
    }

    public RecentNewsBO selectRecentNewsDetails(Integer id){
        List<RecentNewsBO> recentNewsBOS = recentNewsDAO.selectRecentNews(null,null,null,null);
        RecentNewsBO recentNewsBO = recentNewsDAO.selectRecentNewsDetails(id);
        for (int i=0;i<recentNewsBOS.size();i++) {
            if(recentNewsBOS.get(i).getId().equals(id)){
                if(i!=0&&recentNewsBOS.get(i-1)!=null){
                    recentNewsBO.setBeforeRecentNewsId(recentNewsBOS.get(i-1).getId());
                }
                if(i<recentNewsBOS.size()-1){
                    if(recentNewsBOS.get(i+1)!=null){
                        recentNewsBO.setAfterRecentNewsId(recentNewsBOS.get(i+1).getId());
                    }
                }
            }
        }
        return recentNewsBO;
    }

    public Integer getCount(Integer id,String title){
        return recentNewsDAO.getCount(id,title);
    }

}
