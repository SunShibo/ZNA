package com.zna.server.service;

import com.zna.server.dao.PersonnelRecruitmentDAO;
import com.zna.server.entity.bo.PersonnelRecruitmentBO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonnelRecruitmentContactService {

    @Resource
    PersonnelRecruitmentDAO personnelRecruitmentDAO;

    public List<PersonnelRecruitmentBO> getPersonnelRecruitment(){
        return personnelRecruitmentDAO.getPersonnelRecruitment();
    }
    public Integer addPersonnelRecruitment(PersonnelRecruitmentBO personnelRecruitmentBO){
        return personnelRecruitmentDAO.addPersonnelRecruitment(personnelRecruitmentBO);
    }
    public Integer delPersonnelRecruitment(Integer id){
        return personnelRecruitmentDAO.delPersonnelRecruitment(id);
    }
    public Integer updPersonnelRecruitment(PersonnelRecruitmentBO personnelRecruitmentBO){
        return personnelRecruitmentDAO.updPersonnelRecruitment(personnelRecruitmentBO);
    }
}
