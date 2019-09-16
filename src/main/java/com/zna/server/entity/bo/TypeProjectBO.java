package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.List;

public class TypeProjectBO extends BaseModel {
    private Integer id;
    private String lable;
    private List<ProjectNameBO> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public List<ProjectNameBO> getChildren() {
        return children;
    }

    public void setChildren(List<ProjectNameBO> children) {
        this.children = children;
    }
}
