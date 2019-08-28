package com.zna.server.service;

import com.zna.server.dao.TeamDAO;
import com.zna.server.entity.bo.TeamBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamService {
    @Resource
    TeamDAO teamDAO;
    public List<TeamBO> getTeamBO(Integer pageOffset,Integer pageSize){
        return teamDAO.getTeamBO(pageOffset,pageSize);
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
}
