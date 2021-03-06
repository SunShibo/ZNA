package com.zna.server.service;

import com.zna.server.dao.TeamDAO;
import com.zna.server.entity.bo.ProjectInvolvedBO;
import com.zna.server.entity.bo.TeamBO;
import com.zna.server.entity.bo.TeamProjectResultBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Resource
    TeamDAO teamDAO;
    public List<TeamBO> getTeamBO(Integer pageOffset,Integer pageSize){
        List<TeamBO> teamBOS=teamDAO.getTeamBO(pageOffset,pageSize);
        return teamBOS;
    }
    public List<TeamBO> getTeamBOS(Integer pageOffset,Integer pageSize){
        return teamDAO.getTeamBOS(pageOffset, pageSize);
    }
    public Integer getTeamBOCount(){
        return teamDAO.getTeamBOCount();
    }
    public TeamBO getTeamBOById(Integer id){
        List<TeamBO> teamBOS=teamDAO.getTeamBO(null,null);
        TeamBO teamBO=teamDAO.getTeamBOById(id);
        List<ProjectInvolvedBO> projectPictureS = teamDAO.getProjectById(id);
        for (int i=0;i<teamBOS.size();i++) {
            if(teamBOS.get(i).getId().equals(id)){
               if(i!=0&&teamBOS.get(i-1)!=null){
                   teamBO.setBeforeUserId(teamBOS.get(i-1).getId());
                   teamBO.setBeforeUserName(teamBOS.get(i-1).getName());
                   teamBO.setBeforeUserNameEnglish(teamBOS.get(i-1).getNameEnglish());
               }
                if(i<teamBOS.size()-1){
                    if(teamBOS.get(i+1)!=null){
                        teamBO.setAfterUserId(teamBOS.get(i+1).getId());
                        teamBO.setAfterUserName(teamBOS.get(i+1).getName());
                        teamBO.setAfterUserNameEnglish(teamBOS.get(i+1).getNameEnglish());
                    }
                }
            }
        }
            if (teamBO!=null&& projectPictureS!=null) {
                    teamBO.setProjectPicture(projectPictureS);
            }
                return teamBO;

    }

    public List<TeamProjectResultBO> getProjectByTeamId(Integer id){
        return teamDAO.getProjectByTeamId(id);
    }

    public Integer addTeamBO(TeamBO teamBO){
        return teamDAO.addTeamBO(teamBO);
    }
    public Integer delTeamBO(Integer id){
        return teamDAO.delTeamBO(id);
    }
    public Integer updTeamBO(TeamBO teamBO){
        return teamDAO.updTeamBO(teamBO);
    }

    public int addTeamProject( Integer teamId, Integer[] projectIdArr){
        return teamDAO.addTeamProject(teamId, projectIdArr);
    }

    public TeamBO getTeamNews(){
        return teamDAO.getTeamNews();
    }

    public void updateTeamProject( Integer teamId, Integer[] projectIdArr){
        if (projectIdArr.length<=0){
            teamDAO.delTeamProject(teamId);
        }else {
            teamDAO.delTeamProject(teamId);
            teamDAO.addTeamProject(teamId, projectIdArr);
        }
    }

}
