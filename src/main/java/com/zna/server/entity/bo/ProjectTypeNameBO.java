package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.List;

public class ProjectTypeNameBO extends BaseModel {
    private String name;
    private List<ProjectListBO> projectListBOS;//展览

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProjectListBO> getProjectListBOS() {
        return projectListBOS;
    }

    public void setProjectListBOS(List<ProjectListBO> projectListBOS) {
        this.projectListBOS = projectListBOS;
    }
}
