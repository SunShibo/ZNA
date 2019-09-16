package com.zna.server.service;

import com.zna.server.dao.ProjectTypeDAO;
import com.zna.server.entity.bo.ProjectTypeBO;
import com.zna.server.entity.bo.TypeProjectBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("projectTypeService")
@Transactional
public class ProjectTypeService {

    @Resource
    private ProjectTypeDAO projectTypeDAO;

    public void updateProjectType(ProjectTypeBO projectTypeBO){
        projectTypeDAO.updateProjectType(projectTypeBO);
    }
    public List<ProjectTypeBO> selectProjectType(){
        return projectTypeDAO.selectProjectType();
    }
    public List<TypeProjectBO> getTypeProject(){
        return projectTypeDAO.getTypeProject();
    }

}
