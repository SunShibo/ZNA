package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.ContactWayBO;
import com.zna.server.entity.bo.RecentNewsBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.query.QueryInfo;
import com.zna.server.service.ContactWayService;
import com.zna.server.service.RecentNewsService;
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

@Controller
@RequestMapping("/recentNews")
public class RecentNewsController extends BaseCotroller {
    private static final Logger log = LoggerFactory.getLogger(RecentNewsController.class);

    @Resource
    private RecentNewsService recentNewsService;
    @Resource
    private ContactWayService contactWayService;

    /**
     * 添加最新动态
     *  pictureUrl 图片地址
     *  title 标题
     *  titleEnglish 标题英文
     *  time 时间
     *  context 内容
     * contextEnglish 内容英文
     * sort 序号
     * @param request
     * @param response
     */
    @RequestMapping("/addRecentNews")
    public void addRecentNews(RecentNewsBO recentNewsBO,HttpServletRequest request, HttpServletResponse response){
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
                return ;
            }
            //参数验证
            if (recentNewsBO==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            recentNewsBO.setCreateUserId(loginAdmin.getId());
            recentNewsService.addRecentNews(recentNewsBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("添加成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateAboutUsException",e);
        }
    }

    /**
     * 删除最新动态
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("/delRecentNews")
    public void delRecentNews(Integer id,HttpServletRequest request, HttpServletResponse response){
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
                return ;
            }
            //参数验证
            if (id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            recentNewsService.delRecentNews(id);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("删除成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateAboutUsException",e);
        }
    }

    /**
     * 修改最新动态
     * @param id
     * @param pictureUrl
     * @param title
     * @param titleEnglish
     * @param time
     * @param context
     * @param contextEnglish
     * @param sort
     * @param request
     * @param response
     */
    @RequestMapping("/updateRecentNews")
    public void updateRecentNews(Integer id,String pictureUrl,String title,String titleEnglish,String time,String context,String contextEnglish,Integer sort,HttpServletRequest request, HttpServletResponse response){
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
                return ;
            }
            //参数验证
            if (id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            recentNewsService.updateRecentNews(id,pictureUrl,title,titleEnglish,time,context,contextEnglish,sort,loginAdmin.getId());
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateAboutUsException",e);
        }
    }

    /**
     * 查询最新动态
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("/selectRecentNews")
    public void selectRecentNews(Integer id,Integer pageNo,Integer pageSize,HttpServletRequest request, HttpServletResponse response){
        try {
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);

            QueryInfo queryInfo=getQueryInfo(pageNo,pageSize);
            List<RecentNewsBO> recentNewsBOS = recentNewsService.selectRecentNews(id,queryInfo.getPageOffset(),queryInfo.getPageSize());
            Integer count = recentNewsService.getCount(id);
            ContactWayBO contactWayBO = contactWayService.getContactWay();
            Map<String,Object> map = new HashMap<>();
            map.put("recentNewsBOS",recentNewsBOS);
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
            log.error("updateAboutUsException",e);
        }
    }

    @RequestMapping("/selectRecentNewsDetails")
    public void selectRecentNewsDetails(Integer id,HttpServletRequest request, HttpServletResponse response){
        try {
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);

            if (id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            RecentNewsBO recentNewsBO = recentNewsService.selectRecentNewsDetails(id);
            ContactWayBO contactWayBO = contactWayService.getContactWay();
            Map<String,Object> map = new HashMap<>();
            map.put("recentNewsBO",recentNewsBO);
            map.put("contactWayBO",contactWayBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateAboutUsException",e);
        }
    }

}
