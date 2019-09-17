package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

public class ProjectNameBO extends BaseModel {
    private Integer value;
    private String label;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
