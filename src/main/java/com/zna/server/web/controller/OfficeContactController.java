package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.ContactWayBO;
import com.zna.server.entity.bo.CooperativeClientBO;
import com.zna.server.entity.bo.OfficeContactBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.service.ContactWayService;
import com.zna.server.service.CooperativeClientService;
import com.zna.server.service.OfficeContactService;
import com.zna.server.util.JsonUtils;
import com.zna.server.util.StringUtils;
import com.zna.server.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//联系我们.. 办公室
@Controller
@RequestMapping("/officeContact")
public class OfficeContactController extends BaseCotroller{
    private static final Logger log = LoggerFactory.getLogger(OfficeContactController.class);
    @Resource
    private OfficeContactService officeContactService;
    @Resource
    private ContactWayService contactWayService;

    /**
     * 查询办公室
     */
    @RequestMapping("/getOfficeContact")
    public void getOfficeContact(HttpServletRequest request, HttpServletResponse response){
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

            List<OfficeContactBO> officeContactBO=officeContactService.getOfficeContactBO();
            ContactWayBO contactWayBO = contactWayService.getContactWay();
            Map<String,Object> map = new HashMap<>();
            map.put("officeContactBO",officeContactBO);
            map.put("contactWayBO",contactWayBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("getOfficeContact",e);
        }
    }

    /**
     * 删除办公室
     */
    @RequestMapping("/delOfficeContact")
    public void delOfficeContact(Integer id,HttpServletRequest request, HttpServletResponse response){
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
             officeContactService.delOfficeContactBO(id);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("删除成功"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("delOfficeContact",e);
        }
    }

    /**
     * 修改办公室
     */
    @RequestMapping("/updOfficeContact")
    public void updOfficeContact(OfficeContactBO officeContactBO,HttpServletRequest request, HttpServletResponse response){
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
            officeContactService.updOfficeContactBO(officeContactBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updOfficeContact",e);
        }
    }

    /**
     * 添加办公室
     */
    @RequestMapping("/addOfficeContact")
    public void addOfficeContact(OfficeContactBO officeContactBO,HttpServletRequest request, HttpServletResponse response){
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
            officeContactService.addOfficeContactBO(officeContactBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("添加成功"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("addOfficeContact",e);
        }
    }

}
