package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.Date;

public class ProjectBO extends BaseModel {
    private Integer id; //经典项目
    private String projectTypeName; //项目分类名称
    private String projectTypeNameEnglish; //项目分类名称（英文）
    private String title; //标题
    private String titleEnglish; //标题（英文）
    private Integer sort; //序号
    private String pictureUrl; //图片url
    private String site; //地点
    private String siteEnglish; //地点（英文）
    private String context; //内容
    private String contextEnglish; //内容（英文）
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

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getProjectTypeNameEnglish() {
        return projectTypeNameEnglish;
    }

    public void setProjectTypeNameEnglish(String projectTypeNameEnglish) {
        this.projectTypeNameEnglish = projectTypeNameEnglish;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSiteEnglish() {
        return siteEnglish;
    }

    public void setSiteEnglish(String siteEnglish) {
        this.siteEnglish = siteEnglish;
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
        return "ProjectBO{" +
                "id=" + id +
                ", projectTypeName='" + projectTypeName + '\'' +
                ", projectTypeNameEnglish='" + projectTypeNameEnglish + '\'' +
                ", title='" + title + '\'' +
                ", titleEnglish='" + titleEnglish + '\'' +
                ", sort=" + sort +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", site='" + site + '\'' +
                ", siteEnglish='" + siteEnglish + '\'' +
                ", context='" + context + '\'' +
                ", contextEnglish='" + contextEnglish + '\'' +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateUserId=" + updateUserId +
                ", updateTime=" + updateTime +
                '}';
    }
}
