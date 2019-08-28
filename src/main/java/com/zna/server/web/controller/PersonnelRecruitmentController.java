package com.zna.server.web.controller;

import com.zna.server.dao.PersonnelRecruitmentDAO;
import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.OfficeContactBO;
import com.zna.server.entity.bo.PersonnelRecruitmentBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.service.OfficeContactService;
import com.zna.server.service.PersonnelRecruitmentContactService;
import com.zna.server.util.JsonUtils;
import com.zna.server.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//人才招聘
@Controller
@RequestMapping("/personnelRecruitment")
public class PersonnelRecruitmentController extends BaseCotroller{
    private static final Logger log = LoggerFactory.getLogger(PersonnelRecruitmentController.class);
    @Resource
    private PersonnelRecruitmentContactService personnelRecruitmentContactService;

    @RequestMapping("/getPersonnelRecruitment")
    public void getPersonnelRecruitment(HttpServletRequest request, HttpServletResponse response){
        try {
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);
            if (loginAdmin==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000002"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return;
            }
            //验证参数
            List<PersonnelRecruitmentBO> officeContactBO=personnelRecruitmentContactService.getPersonnelRecruitment();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(officeContactBO));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("getPersonnelRecruitment",e);
        }
    }


    @RequestMapping("/delPersonnelRecruitment")
    public void delPersonnelRecruitment(Integer id,HttpServletRequest request, HttpServletResponse response){
        try {
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);
            if (loginAdmin==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000002"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return;
            }
            //参数验证
            if (id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            personnelRecruitmentContactService.delPersonnelRecruitment(id);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("删除成功"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("delPersonnelRecruitment",e);
        }
    }

    @RequestMapping("/updPersonnelRecruitment")
    public void updPersonnelRecruitment(PersonnelRecruitmentBO officeContactBO,HttpServletRequest request, HttpServletResponse response){
        try {
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);
            if (loginAdmin==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000002"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return;
            }
            if (officeContactBO==null||officeContactBO.getId()==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            officeContactBO.setUpdateUserId(loginAdmin.getId());
            personnelRecruitmentContactService.updPersonnelRecruitment(officeContactBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updPersonnelRecruitment",e);
        }
    }

    @RequestMapping("/addPersonnelRecruitment")
    public void addPersonnelRecruitment(PersonnelRecruitmentBO officeContactBO,HttpServletRequest request, HttpServletResponse response){
        try {
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);
            if (loginAdmin==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000002"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return;
            }
            if (officeContactBO==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            officeContactBO.setCreateUserId(loginAdmin.getId());
            personnelRecruitmentContactService.addPersonnelRecruitment(officeContactBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("添加成功"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("addPersonnelRecruitment",e);
        }
    }

}
