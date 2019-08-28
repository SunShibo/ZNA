package com.zna.server.dao;

import com.zna.server.entity.bo.OfficeContactBO;

import java.util.List;

public interface OfficeContactDAO {
    //查询办公室信息
    List<OfficeContactBO> getOfficeContactBO();
    //增加办公室信息
    Integer addOfficeContactBO(OfficeContactBO officeContactBO);
    //删除办公室信息
    Integer delOfficeContactBO(Integer id);
    //修改办公室信息
    Integer updOfficeContactBO(OfficeContactBO officeContactBO);
}
