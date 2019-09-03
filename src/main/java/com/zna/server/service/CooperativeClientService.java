package com.zna.server.service;

import com.zna.server.dao.CooperativeClientDAO;
import com.zna.server.entity.bo.CooperativeClientBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("cooperativeClientService")
@Transactional
public class CooperativeClientService {
    @Resource
    private CooperativeClientDAO cooperativeClientDAO;


    /**
     * 新增合作客户图片
     * @param pictureUrl
     * @param createUserId
     */
    public void addCooperativeClient(String pictureUrl,String pictureUrlPc,Integer createUserId){
        CooperativeClientBO cooperativeClientBO = new CooperativeClientBO();
        cooperativeClientBO.setPictureUrl(pictureUrl);
        cooperativeClientBO.setPictureUrlPc(pictureUrlPc);
        cooperativeClientBO.setCreateUserId(createUserId);
        cooperativeClientDAO.addCooperativeClient(cooperativeClientBO);
   }

    /**
     * 批量删除合作客户图片
     * @param ids
     * @return
     */
    public boolean delCooperativeClient( Integer[] ids){
        return cooperativeClientDAO.delCooperativeClient(ids);
    }

    /**
     * 修改合作客户图片
     * @param pictureUrl
     * @param updateUserId
     */
    public void updateCooperativeClient(Integer id,String pictureUrl,String pictureUrlPc,Integer updateUserId){
        CooperativeClientBO cooperativeClientBO = new CooperativeClientBO();
        cooperativeClientBO.setId(id);
        cooperativeClientBO.setPictureUrl(pictureUrl);
        cooperativeClientBO.setPictureUrlPc(pictureUrlPc);
        cooperativeClientBO.setUpdateUserId(updateUserId);
        cooperativeClientDAO.updateCooperativeClient(cooperativeClientBO);
    }

    /**
     * 查询合作客户图片
     * @return
     */
    public List<CooperativeClientBO> getCooperativeClient(){
        return cooperativeClientDAO.getCooperativeClient();
    }
}
