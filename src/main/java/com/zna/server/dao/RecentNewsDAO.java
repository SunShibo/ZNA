package com.zna.server.dao;

import com.zna.server.entity.bo.RecentNewsBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecentNewsDAO {

    void addRecentNews(RecentNewsBO recentNewsBO);

    void delRecentNews(Integer id);

    void updateRecentNews(RecentNewsBO recentNewsBO);

    List<RecentNewsBO> selectRecentNews(@Param("id") Integer id,@Param("pageOffset")Integer pageOffset,@Param("pageSize")Integer pageSize);

    RecentNewsBO selectRecentNewsDetails(Integer id);

    Integer getCount(@Param("id")Integer id);
}
