package com.zna.server.service;

import com.zna.server.dao.HistoryDAO;
import com.zna.server.entity.bo.HistoryBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("historyService")
@Transactional
public class HistoryService {
    @Resource
    private HistoryDAO historyDAO;


    /**
     * 添加发展历史
     * @param pictureUrl
     * @param time
     * @param context
     * @param contextEnglish
     * @param sort
     * @param createUserId
     */
    public void addHistory(String pictureUrl,String time,String context,
                           String contextEnglish,Integer sort,Integer createUserId){
        HistoryBO historyBO = new HistoryBO();
        historyBO.setPictureUrl(pictureUrl);
        historyBO.setTime(time);
        historyBO.setContext(context);
        historyBO.setContextEnglish(contextEnglish);
        historyBO.setSort(sort);
        historyBO.setCreateUserId(createUserId);
        historyDAO.addHistory(historyBO);
    }

    /**
     * 删除发展历史
     * @param id
     */
    public void delHistory(int id){
        historyDAO.delHistory(id);
    }

    /**
     * 修改发展历史
     * @param pictureUrl
     * @param time
     * @param context
     * @param contextEnglish
     * @param sort
     * @param updateUserId
     * @param id
     */
    public void updateHistory(String pictureUrl,String time,String context, String contextEnglish,
                              Integer sort,Integer updateUserId,Integer id){
        HistoryBO historyBO = new HistoryBO();
        historyBO.setPictureUrl(pictureUrl);
        historyBO.setTime(time);
        historyBO.setContext(context);
        historyBO.setContextEnglish(contextEnglish);
        historyBO.setSort(sort);
        historyBO.setUpdateUserId(updateUserId);
        historyBO.setId(id);
        historyDAO.updateHistory(historyBO);
    }
    /**
     * 查询发展历史
     * @return
     */
    public List<HistoryBO> getHistory(){
        return historyDAO.getHistory();
    }

}
