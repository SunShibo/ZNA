package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;


public class ProjectListBO extends BaseModel {
    private Integer id;
    private String title;
    private String titleEnglish;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
