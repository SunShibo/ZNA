package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.ContactWayBO;
import com.zna.server.entity.bo.ProjectTypeBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.service.ContactWayService;
import com.zna.server.service.ProjectTypeService;
import com.zna.server.util.JsonUtils;
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

@Controller
@RequestMapping("/projectType")
public class ProjectTypeController extends BaseCotroller {
    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Resource
    private ProjectTypeService projectTypeService;
    @Resource
    private ContactWayService contactWayService;

    @RequestMapping("/updateProjectType")
    public void updateProjectType(ProjectTypeBO projectTypeBO, HttpServletRequest request, HttpServletResponse response){

        try{
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);
            if (loginAdmin==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000002"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            //参数验证
            if (projectTypeBO==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            projectTypeService.updateProjectType(projectTypeBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateProjectTypeException",e);
        }
    }

    @RequestMapping("/selectProjectType")
    public void selectProjectType( HttpServletRequest request, HttpServletResponse response){

        try{
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);

            List<ProjectTypeBO> projectTypeBOS = projectTypeService.selectProjectType();
            ContactWayBO contactWayBO = contactWayService.getContactWay();
            Map<String,Object> map = new HashMap<>();
            map.put("projectTypeBOS",projectTypeBOS);
            map.put("contactWayBO",contactWayBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateProjectTypeException",e);
        }
    }

}
