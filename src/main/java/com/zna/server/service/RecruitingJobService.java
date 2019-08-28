package com.zna.server.service;

import com.zna.server.dao.RecruitingJobDAO;
import com.zna.server.entity.bo.RecruitingJobBO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecruitingJobService {
    @Resource
    RecruitingJobDAO recruitingJobDao;
    public List<RecruitingJobBO> getRecruitingJob(){
        return recruitingJobDao.getRecruitingJob();
    }
    public Integer addRecruitingJob(RecruitingJobBO officeContactBO){
        return recruitingJobDao.addRecruitingJob(officeContactBO);
    }
    public Integer delRecruitingJob(Integer id){
        return recruitingJobDao.delRecruitingJob(id);
    }
    public Integer updRecruitingJob(RecruitingJobBO officeContactBO){
        return recruitingJobDao.updRecruitingJob(officeContactBO);
    }
}
