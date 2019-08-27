package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.Date;

public class TeamBO extends BaseModel {
    private Integer id; //核心团队
    private String name; //名字
    private String nameEnglish; //名字（英文）
    private String headPortrait; //头像
    private String position; //简介
    private String positionEnglish; //职位（英文）
    private String intro; //简介
    private String introEnglish; //简介（英文）
    private String educational; //教育背景
    private String educationalEnglish; //教育背景（英文）
    private String aptitude; //专业资质
    private String aptitudeEnglish; //专业资质（英文）
    private Integer sort; //序号
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionEnglish() {
        return positionEnglish;
    }

    public void setPositionEnglish(String positionEnglish) {
        this.positionEnglish = positionEnglish;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIntroEnglish() {
        return introEnglish;
    }

    public void setIntroEnglish(String introEnglish) {
        this.introEnglish = introEnglish;
    }

    public String getEducational() {
        return educational;
    }

    public void setEducational(String educational) {
        this.educational = educational;
    }

    public String getEducationalEnglish() {
        return educationalEnglish;
    }

    public void setEducationalEnglish(String educationalEnglish) {
        this.educationalEnglish = educationalEnglish;
    }

    public String getAptitude() {
        return aptitude;
    }

    public void setAptitude(String aptitude) {
        this.aptitude = aptitude;
    }

    public String getAptitudeEnglish() {
        return aptitudeEnglish;
    }

    public void setAptitudeEnglish(String aptitudeEnglish) {
        this.aptitudeEnglish = aptitudeEnglish;
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
        return "TeamBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameEnglish='" + nameEnglish + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", position='" + position + '\'' +
                ", positionEnglish='" + positionEnglish + '\'' +
                ", intro='" + intro + '\'' +
                ", introEnglish='" + introEnglish + '\'' +
                ", educational='" + educational + '\'' +
                ", educationalEnglish='" + educationalEnglish + '\'' +
                ", aptitude='" + aptitude + '\'' +
                ", aptitudeEnglish='" + aptitudeEnglish + '\'' +
                ", sort=" + sort +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateUserId=" + updateUserId +
                ", updateTime=" + updateTime +
                '}';
    }
}