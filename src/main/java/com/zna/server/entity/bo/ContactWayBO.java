package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.Date;

public class ContactWayBO extends BaseModel {
    private Integer id; //联系方式表
    private String mobile; //手机
    private String faxNO; //传真
    private String email; //邮箱
    private String pictureOne; //图片1（备用）
    private String pictureTwo; //图片2（备用）
    private String pictureThree; //图片3（备用）
    private Integer createUserId; //创建人
    private Date createTime; //创建时间
    private Integer updateUserId; //修改人
    private Date updateTime; //修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFaxNO() {
        return faxNO;
    }

    public void setFaxNO(String faxNO) {
        this.faxNO = faxNO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPictureOne() {
        return pictureOne;
    }

    public void setPictureOne(String pictureOne) {
        this.pictureOne = pictureOne;
    }

    public String getPictureTwo() {
        return pictureTwo;
    }

    public void setPictureTwo(String pictureTwo) {
        this.pictureTwo = pictureTwo;
    }

    public String getPictureThree() {
        return pictureThree;
    }

    public void setPictureThree(String pictureThree) {
        this.pictureThree = pictureThree;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ContactWayBO{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", faxNO='" + faxNO + '\'' +
                ", email='" + email + '\'' +
                ", pictureOne='" + pictureOne + '\'' +
                ", pictureTwo='" + pictureTwo + '\'' +
                ", pictureThree='" + pictureThree + '\'' +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateUserId=" + updateUserId +
                ", updateTime=" + updateTime +
                '}';
    }
}