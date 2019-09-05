package com.zna.server.dao;

import com.zna.server.entity.bo.PersonnelRecruitmentBO;

import java.util.List;
//人才招聘
public interface PersonnelRecruitmentDAO {
    PersonnelRecruitmentBO getPersonnelRecruitment();
    void addPersonnelRecruitment(PersonnelRecruitmentBO officeContactBO);
    Integer delPersonnelRecruitment(Integer id);
    void updPersonnelRecruitment(PersonnelRecruitmentBO officeContactBO);

    int getCount();
}
