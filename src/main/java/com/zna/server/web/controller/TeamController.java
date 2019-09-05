package com.zna.server.web.controller;

import com.zna.server.entity.bo.*;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.query.QueryInfo;
import com.zna.server.service.ContactWayService;
import com.zna.server.service.PersonnelRecruitmentContactService;
import com.zna.server.service.TeamService;
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

//人才招聘
@Controller
@RequestMapping("/team")
public class TeamController extends BaseCotroller{
    private static final Logger log = LoggerFactory.getLogger(TeamController.class);
    @Resource
    private TeamService teamService;
    @Resource
    private ContactWayService contactWayService;

    @RequestMapping("/getTeamBO")
    public void getTeamBO(Integer pageNo,Integer pageSize,HttpServletRequest request, HttpServletResponse response){
        try {
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);

            QueryInfo queryInfo=getQueryInfo(pageNo,pageSize);

            //List<TeamBO> officeContactBO=teamService.getTeamBO(queryInfo.getPageOffset(),queryInfo.getPageSize());
            List<TeamBO> teamBOS=teamService.getTeamBOS(queryInfo.getPageOffset(),queryInfo.getPageSize());
            Integer count = teamService.getTeamBOCount();
            ContactWayBO contactWayBO = contactWayService.getContactWay();
            Map<String,Object> map = new HashMap<>();
            map.put("teamBOS",teamBOS);
            map.put("count",count);
            map.put("contactWayBO",contactWayBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("getTeamBO",e);
        }
    }

    /**
     * 人物详情
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("/getTeamBOById")
    public void getTeamBOById(Integer id,HttpServletRequest request, HttpServletResponse response){
        try {
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);

            //验证参数
            if (id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return;
            }

            TeamBO teamBO=teamService.getTeamBOById(id);
            ContactWayBO contactWayBO = contactWayService.getContactWay();
            Map<String,Object> map = new HashMap<>();
            map.put("teamBO",teamBO);
            map.put("contactWayBO",contactWayBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("getTeamBO",e);
        }
    }
    /**
     * 删除办公室
     */
    @RequestMapping("/delTeamBO")
    public void delTeamBO(Integer id,HttpServletRequest request, HttpServletResponse response){
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
            teamService.delTeamBO(id);
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

    /**
     * 修改办公室
     */
    @RequestMapping("/updTeamBO")
    public void updTeamBO(TeamBO teamBO,HttpServletRequest request, HttpServletResponse response){
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
            if (teamBO==null||teamBO.getId()==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            teamBO.setUpdateUserId(loginAdmin.getId());
            teamService.updTeamBO(teamBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updTeamBO",e);
        }
    }

    @RequestMapping("/addTeamBO")
    public void addTeamBO(TeamBO teamBO,String projectIds,HttpServletRequest request, HttpServletResponse response){
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
            if (teamBO==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            teamBO.setCreateUserId(loginAdmin.getId());
            teamService.addTeamBO(teamBO);
            TeamBO teamBO1 = teamService.getTeamNews();
            //todo id获取不到
            System.out.println(teamBO1.getId());
            //添加项目
            if (teamBO1!=null) {
                if (!StringUtils.isEmpty(projectIds)) {
                    Integer[] projectIdArr = JsonUtils.getIntegerArray4Json(projectIds);
                    teamService.addTeamProject(teamBO1.getId(), projectIdArr);
                }
            }
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("添加成功"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("teamBO",e);
        }
    }

    /**
     *为某个人物批量添加参与的项目
     * @param teamId
     * @param projectIds 项目id ：[1,2,3]
     * @param request
     * @param response
     */
    @RequestMapping("/addTeamProject")
    public void addTeamProject(Integer teamId,String projectIds,HttpServletRequest request, HttpServletResponse response){
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
            if (teamId==null||StringUtils.isEmpty(projectIds)){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }

            //添加项目

            Integer[] projectIdArr = JsonUtils.getIntegerArray4Json(projectIds);
            teamService.addTeamProject(teamId, projectIdArr);

            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("添加成功"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("addTeamProject",e);
        }
    }

    /**
     * 修改人物的某些项目
     * @param teamId
     * @param projectIds
     * @param request
     * @param response
     */
    @RequestMapping("/updateTeamProject")
    public void updateTeamProject(Integer teamId,String projectIds,HttpServletRequest request, HttpServletResponse response){
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
            if (teamId==null||StringUtils.isEmpty(projectIds)){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            Integer[] projectIdArr = JsonUtils.getIntegerArray4Json(projectIds);
            teamService.updateTeamProject(teamId,projectIdArr);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("delTeamProject",e);
        }
    }

    /**
     * 查询某个人参与的项目
     * @param teamId
     * @param request
     * @param response
     * return 项目id 项目标题
     */
    @RequestMapping("/getProjectByTeamId")
    public void getProjectByTeamId(Integer teamId,HttpServletRequest request, HttpServletResponse response){
        try {
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);

            if (teamId==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }

            List<TeamProjectResultBO> teamProjectResultBOS = teamService.getProjectByTeamId(teamId);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(teamProjectResultBOS));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("delTeamProject",e);
        }
    }


}
