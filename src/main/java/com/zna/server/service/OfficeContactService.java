package com.zna.server.service;

import com.zna.server.dao.OfficeContactDAO;
import com.zna.server.entity.bo.OfficeContactBO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OfficeContactService {

    @Resource
    OfficeContactDAO officeContactDAO;

    //查询办公室信息
    public List<OfficeContactBO> getOfficeContactBO(){
        return officeContactDAO.getOfficeContactBO();
    }
    //增加办公室信息
    public Integer addOfficeContactBO(OfficeContactBO officeContactBO){
        return officeContactDAO.addOfficeContactBO(officeContactBO);
    }
    //删除办公室信息
    public Integer delOfficeContactBO(Integer id){
        return officeContactDAO.delOfficeContactBO(id);
    }
    //修改办公室信息
    public Integer updOfficeContactBO(OfficeContactBO officeContactBO){
        return officeContactDAO.updOfficeContactBO(officeContactBO);
    }
}
