package com.zna.server.dao;

import com.zna.server.entity.bo.PersonnelRecruitmentBO;

import java.util.List;
//人才招聘
public interface PersonnelRecruitmentDAO {
    List<PersonnelRecruitmentBO> getPersonnelRecruitment();
    Integer addPersonnelRecruitment(PersonnelRecruitmentBO officeContactBO);
    Integer delPersonnelRecruitment(Integer id);
    Integer updPersonnelRecruitment(PersonnelRecruitmentBO officeContactBO);
}
