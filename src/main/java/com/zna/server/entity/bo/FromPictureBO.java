package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

public class FromPictureBO extends BaseModel {
    private Integer id;
    private String pictureUrl;

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
}
