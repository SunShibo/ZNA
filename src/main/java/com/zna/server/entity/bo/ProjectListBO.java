package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;


public class ProjectListBO extends BaseModel {
    private Integer id;
    private String label;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
