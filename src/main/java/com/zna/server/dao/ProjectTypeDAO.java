package com.zna.server.dao;

import com.zna.server.entity.bo.ProjectTypeBO;

import java.util.List;

public interface ProjectTypeDAO {

    void updateProjectType(ProjectTypeBO projectTypeBO);

    List<ProjectTypeBO> selectProjectType();
}
