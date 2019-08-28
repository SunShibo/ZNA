package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.Date;

public class BannerBO extends BaseModel {
    private Integer id; //banner
    private String pictureUrl; //图片url
    private String skipUrl; //跳转url
    private String skipType; //跳转类型
    private Integer skipId; //跳转id
    private Integer sort; //序号
    private String state; //状态 展示show 不展示 notshow
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

    public String getSkipUrl() {
        return skipUrl;
    }

    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl;
    }

    public String getSkipType() {
        return skipType;
    }

    public void setSkipType(String skipType) {
        this.skipType = skipType;
    }

    public Integer getSkipId() {
        return skipId;
    }

    public void setSkipId(Integer skipId) {
        this.skipId = skipId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        return "BannerBO{" +
                "id=" + id +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", skipUrl='" + skipUrl + '\'' +
                ", skipType='" + skipType + '\'' +
                ", skipId=" + skipId +
                ", sort=" + sort +
                ", state='" + state + '\'' +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateUserId=" + updateUserId +
                ", updateTime=" + updateTime +
                '}';
    }
}
