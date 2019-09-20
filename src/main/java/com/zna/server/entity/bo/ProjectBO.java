package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.Date;

public class ProjectBO extends BaseModel {
    private Integer id; //经典项目
    private String projectTypeName; //项目分类名称
    private String projectTypeNameEnglish; //项目分类名称（英文）
    private String title; //标题
    private String titleEnglish; //标题（英文）
    private String type;//分类
    private Integer sort; //序号
    private String pictureUrl; //图片url
    private String pictureUrlPc; //图片url
    private String thumbnail; //缩略图
    private String thumbnailPc; //缩略图
    private String site; //地点
    private String siteEnglish; //地点（英文）
    private String floorSpace;//场地面积
    private String floorSpaceEnglish;//
    private String coveredArea;//建筑面积
    private String coveredAreaEnglish;//
    private String client;//业主
    private String clientEnglish;//
    private String context; //内容
    private String contextEnglish; //内容（英文）
    private String property;//属性
    private String propertyEnglish;//属性
    private Integer createUserId; //创建人
    private Date createTime; //创建时间
    private Integer updateUserId; //修改人
    private Date updateTime; //修改时间

    private Integer beforeProjectId;//前一个核心团队id
    private Integer afterProjectId;//后一个核心团队id

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailPc() {
        return thumbnailPc;
    }

    public void setThumbnailPc(String thumbnailPc) {
        this.thumbnailPc = thumbnailPc;
    }

    public String getFloorSpace() {
        return floorSpace;
    }

    public void setFloorSpace(String floorSpace) {
        this.floorSpace = floorSpace;
    }

    public String getFloorSpaceEnglish() {
        return floorSpaceEnglish;
    }

    public void setFloorSpaceEnglish(String floorSpaceEnglish) {
        this.floorSpaceEnglish = floorSpaceEnglish;
    }

    public String getCoveredArea() {
        return coveredArea;
    }

    public void setCoveredArea(String coveredArea) {
        this.coveredArea = coveredArea;
    }

    public String getCoveredAreaEnglish() {
        return coveredAreaEnglish;
    }

    public void setCoveredAreaEnglish(String coveredAreaEnglish) {
        this.coveredAreaEnglish = coveredAreaEnglish;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientEnglish() {
        return clientEnglish;
    }

    public void setClientEnglish(String clientEnglish) {
        this.clientEnglish = clientEnglish;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPictureUrlPc() {
        return pictureUrlPc;
    }

    public void setPictureUrlPc(String pictureUrlPc) {
        this.pictureUrlPc = pictureUrlPc;
    }

    public Integer getBeforeProjectId() {
        return beforeProjectId;
    }

    public void setBeforeProjectId(Integer beforeProjectId) {
        this.beforeProjectId = beforeProjectId;
    }

    public Integer getAfterProjectId() {
        return afterProjectId;
    }

    public void setAfterProjectId(Integer afterProjectId) {
        this.afterProjectId = afterProjectId;
    }

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

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPropertyEnglish() {
        return propertyEnglish;
    }

    public void setPropertyEnglish(String propertyEnglish) {
        this.propertyEnglish = propertyEnglish;
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
                ", type='" + type + '\'' +
                ", sort=" + sort +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", pictureUrlPc='" + pictureUrlPc + '\'' +
                ", site='" + site + '\'' +
                ", siteEnglish='" + siteEnglish + '\'' +
                ", floorSpace='" + floorSpace + '\'' +
                ", floorSpaceEnglish='" + floorSpaceEnglish + '\'' +
                ", coveredArea='" + coveredArea + '\'' +
                ", coveredAreaEnglish='" + coveredAreaEnglish + '\'' +
                ", client='" + client + '\'' +
                ", clientEnglish='" + clientEnglish + '\'' +
                ", context='" + context + '\'' +
                ", contextEnglish='" + contextEnglish + '\'' +
                ", property='" + property + '\'' +
                ", propertyEnglish='" + propertyEnglish + '\'' +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateUserId=" + updateUserId +
                ", updateTime=" + updateTime +
                ", beforeProjectId=" + beforeProjectId +
                ", afterProjectId=" + afterProjectId +
                '}';
    }
}
