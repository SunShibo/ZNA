package com.zna.server.dao;

import com.zna.server.entity.bo.ProjectBO;
import com.zna.server.entity.bo.ProjectTypeNameBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectDAO {
    /**
     * 新增项目
     * @param projectBO
     */
    void addProject(ProjectBO projectBO);

    /**
     * 删除项目
     * @param id
     */
    void delProject(int id);

    /**
     * 修改项目
     * @param projectBO
     */
    void updateProject(ProjectBO projectBO);

    /**
     * 查询
     * @param title
     * @return
     */
    List<ProjectBO> getProject(@Param("title") String title,@Param("type") String type,@Param("projectTypeName") String projectTypeName,@Param("projectTypeNameEnglish") String projectTypeNameEnglish,@Param("pageOffset")Integer pageOffset, @Param("pageSize")Integer pageSize);

    Integer getCount(@Param("title") String title,@Param("type") String type,@Param("projectTypeName") String projectTypeName,@Param("projectTypeNameEnglish") String projectTypeNameEnglish);
    /*项目详情 */
    ProjectBO getProjectDetails(Integer id);


    List<ProjectTypeNameBO> getProjectIdList();
}
