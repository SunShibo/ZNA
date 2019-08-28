package com.zna.server.dao;

import com.zna.server.entity.bo.RecruitingJobBO;

import java.util.List;

public interface RecruitingJobDAO {
    List<RecruitingJobBO> getRecruitingJob();
    Integer addRecruitingJob(RecruitingJobBO officeContactBO);
    Integer delRecruitingJob(Integer id);
    Integer updRecruitingJob(RecruitingJobBO officeContactBO);
}
