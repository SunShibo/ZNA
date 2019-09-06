package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.List;

public class ProjectTypeNameBO extends BaseModel {
    private String label;
    private List<ProjectListBO> children;//展览

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ProjectListBO> getChildren() {
        return children;
    }

    public void setChildren(List<ProjectListBO> children) {
        this.children = children;
    }
}
