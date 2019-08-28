package com.zna.server.dao;

import com.zna.server.entity.bo.OfficeContactBO;
import com.zna.server.entity.bo.TeamBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamDAO {
    List<TeamBO> getTeamBO(@Param("pageOffset")Integer pageOffset,@Param("pageSize")Integer pageSize);
    Integer addTeamBO(TeamBO teamBO);
    Integer delTeamBO(Integer id);
    Integer updTeamBO(TeamBO teamBO);
}
