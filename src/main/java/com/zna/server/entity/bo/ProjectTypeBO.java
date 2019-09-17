package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

public class ProjectTypeBO extends BaseModel {
    private Integer id;
    private String projectTypeName;
    private String projectTypeNameEnglish;
    private String type;
    private String pictureUrl;
    private String pictureUrlPc;
    private Integer sort;//序号

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
