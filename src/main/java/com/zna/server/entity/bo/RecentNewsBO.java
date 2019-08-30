package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.Date;

public class RecentNewsBO extends BaseModel {
    private Integer id; //最新动态
    private String pictureUrl; //图片url
    private String title; //标题
    private String titleEnglish; //标题（英文）
    private String time; //时间
    private String context; //内容
    private String contextEnglish; //内容（英文）
    private Integer sort; //序号
    private Integer createUserId; //创建人
    private Date createTime; //创建时间
    private Integer updateUserId; //修改人
    private Date updateTime; //修改时间

    private Integer beforeRecentNewsId;//前一个id
    private Integer afterRecentNewsId;//后一个id

    public Integer getBeforeRecentNewsId() {
        return beforeRecentNewsId;
    }

    public void setBeforeRecentNewsId(Integer beforeRecentNewsId) {
        this.beforeRecentNewsId = beforeRecentNewsId;
    }

    public Integer getAfterRecentNewsId() {
        return afterRecentNewsId;
    }

    public void setAfterRecentNewsId(Integer afterRecentNewsId) {
        this.afterRecentNewsId = afterRecentNewsId;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
        return "RecentNewsBO{" +
                "id=" + id +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", title='" + title + '\'' +
                ", titleEnglish='" + titleEnglish + '\'' +
                ", time='" + time + '\'' +
                ", context='" + context + '\'' +
                ", contextEnglish='" + contextEnglish + '\'' +
                ", sort=" + sort +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateUserId=" + updateUserId +
                ", updateTime=" + updateTime +
                ", beforeRecentNewsId=" + beforeRecentNewsId +
                ", afterRecentNewsId=" + afterRecentNewsId +
                '}';
    }
}
