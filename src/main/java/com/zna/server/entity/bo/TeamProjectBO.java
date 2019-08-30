package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

public class TeamProjectBO extends BaseModel {
    private Integer id;//团队项目关联
    private Integer teamId;//团队id
    private Integer projectId;//项目id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
