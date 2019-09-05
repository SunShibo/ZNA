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

    public PersonnelRecruitmentBO getPersonnelRecruitment(){
        return personnelRecruitmentDAO.getPersonnelRecruitment();
    }
    public void addPersonnelRecruitment(PersonnelRecruitmentBO personnelRecruitmentBO){
         personnelRecruitmentDAO.addPersonnelRecruitment(personnelRecruitmentBO);
    }
    public Integer delPersonnelRecruitment(Integer id){
        return personnelRecruitmentDAO.delPersonnelRecruitment(id);
    }


    public void updPersonnelRecruitment(PersonnelRecruitmentBO personnelRecruitmentBO){
        int t = personnelRecruitmentDAO.getCount();
        if (t<1){
            personnelRecruitmentDAO.addPersonnelRecruitment(personnelRecruitmentBO);
        }else {
            personnelRecruitmentDAO.updPersonnelRecruitment(personnelRecruitmentBO);
        }
    }
}
