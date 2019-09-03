package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.Date;

public class PersonnelRecruitmentBO extends BaseModel {
    private Integer id; //人才招聘表
    private String context; //内容
    private String contextEnglish; //内容（英文）
    private String announcements; //注意事项
    private String announcementsEnglish; //注意事项（英文）
    private String pictureUrl; //图片
    private String pictureUrlPc; //图片
    private Integer createUserId; //创建人
    private Date createTime; //创建时间
    private Integer updateUserId; //修改人
    private Date updateTime; //修改时间

    public String getPictureUrlPc() {
        return pictureUrlPc;
    }

    public void setPictureUrlPc(String pictureUrlPc) {
        this.pictureUrlPc = pictureUrlPc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(String announcements) {
        this.announcements = announcements;
    }

    public String getAnnouncementsEnglish() {
        return announcementsEnglish;
    }

    public void setAnnouncementsEnglish(String announcementsEnglish) {
        this.announcementsEnglish = announcementsEnglish;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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
        return "PersonnelRecruitmentBO{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", contextEnglish='" + contextEnglish + '\'' +
                ", announcements='" + announcements + '\'' +
                ", announcementsEnglish='" + announcementsEnglish + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", pictureUrlPc='" + pictureUrlPc + '\'' +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateUserId=" + updateUserId +
                ", updateTime=" + updateTime +
                '}';
    }
}
