package com.zna.server.service;

import com.zna.server.dao.FromPictureDAO;
import com.zna.server.entity.bo.FromPictureBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("fromPictureService")
@Transactional
public class FromPictureService {

    @Resource
    private FromPictureDAO fromPictureDAO;

    /**
     * 更新关于我们
     * 有数据就修改，没有数据就添加
     * @param pictureUrl
     */
    public void updateFromPicture(String pictureUrl,String pictureUrlPc){
        FromPictureBO fromPictureBO = new FromPictureBO();
        fromPictureBO.setPictureUrl(pictureUrl);
        fromPictureBO.setPictureUrlPc(pictureUrlPc);
        //查询表中数据
        int t = fromPictureDAO.getCount();
        //没有数据就新增
        if (t<1){
            fromPictureDAO.addFromPicture(fromPictureBO);
        }else {
            //有数据就修改更新
           fromPictureDAO.updateFromPicture(fromPictureBO);
        }
    }

    public FromPictureBO getFromPicture(){
        return fromPictureDAO.getFromPicture();
    }
}
