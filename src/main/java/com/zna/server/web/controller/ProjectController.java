package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.ProjectBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.query.QueryInfo;
import com.zna.server.service.ProjectService;
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
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController extends BaseCotroller {

    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Resource
    private ProjectService projectService;

    /**
     * 新增项目
     * @param projectTypeName
     * @param projectTypeNameEnglish
     * @param title
     * @param titleEnglish
     * @param sort
     * @param pictureUrl
     * @param site
     * @param siteEnglish
     * @param context
     * @param contextEnglish
     * @param request
     * @param response
     */
    @RequestMapping("/addProject")
    public void addProject(String projectTypeName, String projectTypeNameEnglish, String title, String titleEnglish, Integer sort, String pictureUrl, String site, String siteEnglish, String context, String contextEnglish, HttpServletRequest request, HttpServletResponse response){
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
            if (StringUtils.isEmpty(projectTypeName)||StringUtils.isEmpty(projectTypeNameEnglish)||StringUtils.isEmpty(title)||StringUtils.isEmpty(titleEnglish)||sort==null||StringUtils.isEmpty(pictureUrl)||StringUtils.isEmpty(site)||StringUtils.isEmpty(siteEnglish)||StringUtils.isEmpty(context)||StringUtils.isEmpty(contextEnglish)){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            projectService.addProject(projectTypeName,projectTypeNameEnglish,title,titleEnglish,sort,pictureUrl,site,siteEnglish,context,contextEnglish,loginAdmin.getId());
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("添加成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("addProjectException",e);
        }
    }

    /**
     * 删除项目
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("/delProject")
    public void delProject(Integer id,HttpServletRequest request, HttpServletResponse response){
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
            if (id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            projectService.delProject(id);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("删除成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("delProjectException",e);
        }
    }


    /**
     * 修改项目
     * @param id
     * @param projectTypeName
     * @param projectTypeNameEnglish
     * @param title
     * @param titleEnglish
     * @param sort
     * @param pictureUrl
     * @param site
     * @param siteEnglish
     * @param context
     * @param contextEnglish
     * @param request
     * @param response
     */
    @RequestMapping("/updateProject")
    public void updateProject(Integer id,String projectTypeName, String projectTypeNameEnglish, String title, String titleEnglish, Integer sort, String pictureUrl, String site, String siteEnglish, String context, String contextEnglish, HttpServletRequest request, HttpServletResponse response){
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
            if (id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            projectService.updateProject(id,projectTypeName,projectTypeNameEnglish,title,titleEnglish,sort,pictureUrl,site,siteEnglish,context,contextEnglish,loginAdmin.getId());
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("addProjectException",e);
        }
    }

    /**
     * 查询项目
     * @param title
     * @param request
     * @param response
     */
    @RequestMapping("/getProject")
    public void getProject(String title,Integer pageNo,Integer pageSize, HttpServletRequest request, HttpServletResponse response){
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
            QueryInfo queryInfo=getQueryInfo(pageNo,pageSize);
            List<ProjectBO> projectBOS = projectService.getProject(title,queryInfo.getPageOffset(),queryInfo.getPageSize());
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(projectBOS));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("getProjectException",e);
        }
    }

}
