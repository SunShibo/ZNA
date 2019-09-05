package com.zna.server.dao;

import com.zna.server.entity.bo.OfficeContactBO;
import com.zna.server.entity.bo.ProjectInvolvedBO;
import com.zna.server.entity.bo.TeamBO;
import com.zna.server.entity.bo.TeamProjectResultBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamDAO {
    List<TeamBO> getTeamBO(@Param("pageOffset")Integer pageOffset,@Param("pageSize")Integer pageSize);
    List<TeamBO> getTeamBOS(@Param("pageOffset")Integer pageOffset,@Param("pageSize")Integer pageSize);
    Integer getTeamBOCount();
    TeamBO getTeamBOById(Integer id);
    Integer addTeamBO(TeamBO teamBO);
    Integer delTeamBO(Integer id);
    Integer updTeamBO(TeamBO teamBO);

    int addTeamProject(@Param("teamId") Integer teamId, @Param("projectIdArr") Integer[] projectIdArr);

    TeamBO getTeamNews();

    void delTeamProject(@Param("teamId") Integer teamId);

    List<ProjectInvolvedBO> getProjectById(Integer id);

    List<TeamProjectResultBO> getProjectByTeamId(Integer id);
}
