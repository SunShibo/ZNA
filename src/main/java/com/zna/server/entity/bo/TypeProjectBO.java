package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.List;

public class TypeProjectBO extends BaseModel {
    private String value;
    private String label;
    private List<ProjectNameBO> children;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ProjectNameBO> getChildren() {
        return children;
    }

    public void setChildren(List<ProjectNameBO> children) {
        this.children = children;
    }
}
