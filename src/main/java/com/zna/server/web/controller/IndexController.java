package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.IndexBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
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
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController extends BaseCotroller {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private IndexService indexService;

    /**
     * 新增首页内容
     * @param title 标题
     * @param titleEnglish 标题英文
     * @param context 内容
     * @param contextEnglish 内容英文
     * @param pictureUrl 图片地址
     * @param sort 序号
     * @param skipId 跳转id
     * @param skipUrl 跳转url
     * @param request
     * @param response
     */
    @RequestMapping("/addIndex")
    public void addIndex(String title,String titleEnglish,String context,String contextEnglish,
                         String pictureUrl,Integer sort,Integer skipId,String skipUrl,
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
            if (StringUtils.isEmpty(title)||StringUtils.isEmpty(titleEnglish)||StringUtils.isEmpty(context)||StringUtils.isEmpty(contextEnglish)||StringUtils.isEmpty(pictureUrl)||sort==null||StringUtils.isEmpty(skipUrl)){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            indexService.addIndex(title,titleEnglish,context,contextEnglish,pictureUrl,sort,skipId,skipUrl,adminBO.getId());
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
     * @param sort 序号
     * @param skipId 跳转id
     * @param skipUrl 跳转url
     * @param request
     * @param response
     */
    @RequestMapping("/updateIndex")
    public void updateIndex(Integer id,String title,String titleEnglish,String context,String contextEnglish,
                         String pictureUrl,Integer sort,Integer skipId,String skipUrl,
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
            indexService.updateIndex(id,title,titleEnglish,context,contextEnglish,pictureUrl,sort,skipId,skipUrl,adminBO.getId());
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
     * 获取首页内容
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
            if (adminBO==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000002"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }

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
}
