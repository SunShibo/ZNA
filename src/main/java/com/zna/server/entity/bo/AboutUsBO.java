package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.Date;

public class AboutUsBO extends BaseModel {
    private Integer id; //关于我们
    private String pictureUrl; //图片url
    private String pictureUrlPc;//
    private String context; //内容
    private String contextEnglish; //内容(英文)
    private String service; //服务
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrlPc() {
        return pictureUrlPc;
    }

    public void setPictureUrlPc(String pictureUrlPc) {
        this.pictureUrlPc = pictureUrlPc;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getContextEnglish() {
        return contextEnglish;
    }

    public void setContextEnglish(String contextEnglish) {
        this.contextEnglish = contextEnglish;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
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
        return "AboutUsBO{" +
                "id=" + id +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", pictureUrlPc='" + pictureUrlPc + '\'' +
                ", context='" + context + '\'' +
                ", contextEnglish='" + contextEnglish + '\'' +
                ", service='" + service + '\'' +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateUserId=" + updateUserId +
                ", updateTime=" + updateTime +
                '}';
    }
}
