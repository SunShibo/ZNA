package com.zna.server.service;

import com.zna.server.dao.IndexDAO;
import com.zna.server.entity.bo.IndexBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("indexService")
@Transactional
public class IndexService {
    @Resource
    private IndexDAO indexDAO;

    /**
     * 添加首页内容
     * @param title 标题
     * @param titleEnglish 英文标题
     * @param context 内容
     * @param contextEnglish 英文内容
     * @param pictureUrl 图片地址
     * @param sort 序号
     * @param skipId 跳转id
     * @param skipUrl 跳转url
     * @param createUserId 创建人
     */
    public void addIndex(IndexBO indexBO){
        indexDAO.addIndex(indexBO);
    }

    /**
     * 删除首页内容
     * @param id
     */
    public void delIndex(int id){
        indexDAO.delIndex(id);
    }
    /**
     * 修改首页内容
     * @param
     */
    public void updateIndex(Integer id,String title,String titleEnglish,String context,
                            String contextEnglish,String pictureUrl,String pictureUrlPc,Integer skipId,
                            String skipUrl,Integer updateUserId){
        IndexBO indexBO = new IndexBO();
        indexBO.setId(id);
        indexBO.setTitle(title);
        indexBO.setTitleEnglish(titleEnglish);
        indexBO.setContext(context);
        indexBO.setContextEnglish(contextEnglish);
        indexBO.setPictureUrl(pictureUrl);
        indexBO.setPictureUrlPc(pictureUrlPc);
        indexBO.setSkipId(skipId);
        indexBO.setSkipUrl(skipUrl);
        indexBO.setUpdateUserId(updateUserId);
        indexDAO.updateIndex(indexBO);
    }

    /**
     * 获取首页内容
     * @return
     */
    public List<IndexBO> selectIndex(){
        return indexDAO.selectIndex();
    }

}
