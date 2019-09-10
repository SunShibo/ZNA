package com.zna.server.service;

import com.zna.server.dao.ContactWayDAO;
import com.zna.server.entity.bo.ContactWayBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("contactWayService")
@Transactional
public class ContactWayService {
    @Resource
    private ContactWayDAO contactWayDAO;


    /**
     * 更新联系方式
     * 有数据就修改，没有数据就添加
     * @param mobile 手机
     * @param faxNO 传真
     * @param email 邮箱
     * @param pictureOne 图片1
     * @param pictureTwo 图片2
     * @param pictureThree 图片3
     * @param createUserId 创建人id
     * @param updateUserId 修改人id
     */
   public void   updateContactWay(String mobile,String faxNO,String email,String pictureOne,String pictureOnePc,String pictureOneUrl,
                                  String pictureTwo,String pictureTwoPc,String pictureTwoUrl,String pictureThree,String pictureThreePc,String pictureThreeUrl,Integer createUserId,Integer updateUserId) {
       ContactWayBO contactWayBO = new ContactWayBO();
       contactWayBO.setMobile(mobile);
       contactWayBO.setFaxNO(faxNO);
       contactWayBO.setEmail(email);
       contactWayBO.setPictureOne(pictureOne);
       contactWayBO.setPictureOnePc(pictureOnePc);
       contactWayBO.setPictureOneUrl(pictureOneUrl);
       contactWayBO.setPictureTwo(pictureTwo);
       contactWayBO.setPictureTwoPc(pictureTwoPc);
       contactWayBO.setPictureTwoUrl(pictureTwoUrl);
       contactWayBO.setPictureThree(pictureThree);
       contactWayBO.setPictureThreePc(pictureThreePc);
       contactWayBO.setPictureThreeUrl(pictureThreeUrl);
       int i = contactWayDAO.getCount();
       if (i<1){
           contactWayBO.setCreateUserId(createUserId);
           contactWayDAO.addContactWay(contactWayBO);
       }else {
           contactWayBO.setUpdateUserId(updateUserId);
           contactWayDAO.updateContactWay(contactWayBO);
       }

    }

    /**
     * 查询
     * @return
     */
    public ContactWayBO getContactWay(){
        return contactWayDAO.getContactWay();
    }

}
