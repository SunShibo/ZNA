package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.BannerBO;
import com.zna.server.entity.bo.ContactWayBO;
import com.zna.server.entity.bo.IndexBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.service.BannerService;
import com.zna.server.service.ContactWayService;
import com.zna.server.service.IndexService;
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
@RequestMapping("/index")
public class IndexController extends BaseCotroller {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private IndexService indexService;
    @Resource
    private BannerService bannerService;
    @Resource
    private ContactWayService contactWayService;

    /**
     * 新增首页内容
     * title 标题
     *titleEnglish 标题英文
     *  context 内容
     *  contextEnglish 内容英文
     *  pictureUrl 图片地址
     * sort 序号
     * skipId 跳转id
     *  skipUrl 跳转url
     * @param request
     * @param response
     */
    @RequestMapping("/addIndex")
    public void addIndex(IndexBO indexBO,HttpServletRequest request,HttpServletResponse response){
        try{
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO adminBO = super.getLoginAdmin(request);
            log.info("user{}",adminBO);
            if (adminBO==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000002"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            //参数验证
            if (indexBO==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            indexBO.setCreateUserId(adminBO.getId());
            indexService.addIndex(indexBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("添加成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("addIndexException",e);
        }
    }

    /**
     * 删除首页内容
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("/delIndex")
    public void delIndex(Integer id,HttpServletRequest request,HttpServletResponse response){
        try{
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO adminBO = super.getLoginAdmin(request);
            log.info("user{}",adminBO);
            if (adminBO==null){
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
            indexService.delIndex(id);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("删除成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("delIndexException",e);
        }
    }
    /**
     * 修改首页内容
     * @param id
     * @param title 标题
     * @param titleEnglish 标题英文
     * @param context 内容
     * @param contextEnglish 内容英文
     * @param pictureUrl 图片地址
     *  sort 序号
     * @param skipId 跳转id
     * @param skipUrl 跳转url
     * @param request
     * @param response
     */
    @RequestMapping("/updateIndex")
    public void updateIndex(Integer id,String title,String titleEnglish,String context,String contextEnglish,
                            String pictureUrl,String pictureUrlPc,Integer skipId,String skipUrl,
                         HttpServletRequest request,HttpServletResponse response){
        try{
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO adminBO = super.getLoginAdmin(request);
            log.info("user{}",adminBO);
            if (adminBO==null){
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
            indexService.updateIndex(id,title,titleEnglish,context,contextEnglish,pictureUrl,pictureUrlPc,skipId,skipUrl,adminBO.getId());
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateIndexException",e);
        }
    }

    /**
     * 获取首页内容【后端】
     * @param request
     * @param response
     */
    @RequestMapping("/selectIndex")
    public void selectIndex(HttpServletRequest request,HttpServletResponse response){
        try{
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO adminBO = super.getLoginAdmin(request);
            log.info("user{}",adminBO);


            List<IndexBO> indexBOS = indexService.selectIndex();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(indexBOS));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("selectIndexException",e);
        }
    }

    /**
     * 获取首页内容【前端】
     * @param request
     * @param response
     */
    @RequestMapping("/getIndex")
    public void getIndex(String state,HttpServletRequest request,HttpServletResponse response){
        try{
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO adminBO = super.getLoginAdmin(request);
            log.info("user{}",adminBO);

            //首页banner
            List<BannerBO> bannerBOS = bannerService.selectBanner(state);
            //首页模块
            List<IndexBO> indexBOS = indexService.selectIndex();
            //首页联系方式
            ContactWayBO contactWayBO = contactWayService.getContactWay();
            Map<String,Object> map = new HashMap<>();
            map.put("bannerBOS",bannerBOS);
            map.put("indexBOS",indexBOS);
            map.put("contactWayBO",contactWayBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("getIndexException",e);
        }
    }
}
