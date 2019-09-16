package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

public class ProjectNameBO extends BaseModel {
    private Integer value;
    private String lable;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
