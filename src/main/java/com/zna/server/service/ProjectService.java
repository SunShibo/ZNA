package com.zna.server.service;

import com.zna.server.dao.ProjectDAO;
import com.zna.server.entity.bo.ProjectBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("projectService")
@Transactional
public class ProjectService {
    @Resource
    private ProjectDAO projectDAO;



    /**
     * 新增项目
     * @param
     */
    public void addProject(ProjectBO projectBO){
        projectDAO.addProject(projectBO);
    }

    /**
     * 删除项目
     * @param id
     */
    public void delProject(int id){
        projectDAO.delProject(id);
    }

    /**
     * 修改项目
     * @param
     */
    public void updateProject(Integer id,String projectTypeName,String projectTypeNameEnglish,String title,String titleEnglish,Integer sort,String pictureUrl,String pictureUrlPc,String site,String siteEnglish,String floorSpace,String floorSpaceEnglish,String coveredArea,String coveredAreaEnglish,String client,String clientEnglish,String context,String contextEnglish,Integer updateUserId){
        ProjectBO projectBO = new ProjectBO();
        projectBO.setId(id);
        projectBO.setProjectTypeName(projectTypeName);
        projectBO.setProjectTypeNameEnglish(projectTypeNameEnglish);
        projectBO.setTitle(title);
        projectBO.setTitleEnglish(titleEnglish);
        projectBO.setSort(sort);
        projectBO.setPictureUrl(pictureUrl);
        projectBO.setPictureUrlPc(pictureUrlPc);
        projectBO.setSite(site);
        projectBO.setSiteEnglish(siteEnglish);
        projectBO.setFloorSpace(floorSpace);
        projectBO.setFloorSpaceEnglish(floorSpaceEnglish);
        projectBO.setCoveredArea(coveredArea);
        projectBO.setCoveredAreaEnglish(coveredAreaEnglish);
        projectBO.setClient(client);
        projectBO.setClientEnglish(clientEnglish);
        projectBO.setContext(context);
        projectBO.setContextEnglish(contextEnglish);
        projectBO.setUpdateUserId(updateUserId);
        projectDAO.updateProject(projectBO);
    }

    /**
     * 查询
     * @param title
     * @return
     */
    public List<ProjectBO> getProject(String title,String type,String projectTypeName,String projectTypeNameEnglish,Integer pageOffset,Integer pageSize){
        return projectDAO.getProject(title,type,projectTypeName,projectTypeNameEnglish,pageOffset,pageSize);
    }

    public Integer getCount(String title,String type,String projectTypeName,String projectTypeNameEnglish){
        return projectDAO.getCount(title, type,projectTypeName, projectTypeNameEnglish);
    }

    /*项目详情 */
    public ProjectBO getProjectDetails(Integer id,String type){//查看详情的时候得传哪个分类
        List<ProjectBO> projectBOS = projectDAO.getProject(null,type,null,null,null,null);
        ProjectBO projectBO = projectDAO.getProjectDetails(id);
        for (int i=0;i<projectBOS.size();i++) {
            if(projectBOS.get(i).getId().equals(id)){
                if(i!=0&&projectBOS.get(i-1)!=null){
                    projectBO.setBeforeProjectId(projectBOS.get(i-1).getId());
                }
                if(i<projectBOS.size()-1){
                    if(projectBOS.get(i+1)!=null){
                        projectBO.setAfterProjectId(projectBOS.get(i+1).getId());
                    }
                }
            }
        }
        return projectBO;
    }

}
