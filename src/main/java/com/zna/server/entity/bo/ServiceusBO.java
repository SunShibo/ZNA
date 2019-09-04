package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

public class ServiceusBO extends BaseModel {
    private Integer id;
    private String title;
    private String titleEnglish;
    private String context;
    private String contextEnglish;
    private String pictureUrl;
    private String pictureUrlPc;

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public String getContextEnglish() {
        return contextEnglish;
    }

    public void setContextEnglish(String contextEnglish) {
        this.contextEnglish = contextEnglish;
    }

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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
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
}
