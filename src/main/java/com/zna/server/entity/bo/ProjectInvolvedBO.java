package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

public class ProjectInvolvedBO extends BaseModel{

    private Integer id;
    private String projectPicture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectPicture() {
        return projectPicture;
    }

    public void setProjectPicture(String projectPicture) {
        this.projectPicture = projectPicture;
    }
}
