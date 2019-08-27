package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.CooperativeClientBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.service.CooperativeClientService;
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
@RequestMapping("/cooperativeClient")
public class CooperativeClientController extends BaseCotroller{
    private static final Logger log = LoggerFactory.getLogger(CooperativeClientController.class);

    @Resource
    private CooperativeClientService cooperativeClientService;

    /**
     * 添加合作客户图片
     * @param pictureUrl
     * @param request
     * @param response
     */
    @RequestMapping("/addCooperativeClient")
    public void addCooperativeClient(String pictureUrl,HttpServletRequest request, HttpServletResponse response){
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
            if (StringUtils.isEmpty(pictureUrl)){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            cooperativeClientService.addCooperativeClient(pictureUrl,loginAdmin.getId());
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("添加成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("addMemberException",e);
        }
    }

    /**
     * 批量删除合作客户图片
     * @param request
     * @param response
     */
    @RequestMapping("/delCooperativeClient")
    public void delCooperativeClient(HttpServletRequest request, HttpServletResponse response,String idArr){
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
            if (StringUtils.isEmpty(idArr)){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            //转换为数组 批量删除
            Integer[] ids= JsonUtils.getIntegerArray4Json(idArr);
            cooperativeClientService.delCooperativeClient(ids);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("删除成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("addMemberException",e);
        }

    }

    /**
     * 修改合作客户图片
     * @param request
     * @param response
     * @param pictureUrl
     */
    @RequestMapping("/updateCooperativeClient")
    public void updateCooperativeClient(HttpServletRequest request, HttpServletResponse response,Integer id,String pictureUrl){
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
            if (StringUtils.isEmpty(pictureUrl)||id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            cooperativeClientService.updateCooperativeClient(id,pictureUrl,loginAdmin.getId());
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("addMemberException",e);
        }

    }

    /**
     * 查询合作客户图片
     * @param request
     * @param response
     */
    @RequestMapping("/getCooperativeClient")
    public void getCooperativeClient(HttpServletRequest request, HttpServletResponse response){
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

            List<CooperativeClientBO> cooperativeClientBOS = cooperativeClientService.getCooperativeClient();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(cooperativeClientBOS));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("addMemberException",e);
        }

    }
}
