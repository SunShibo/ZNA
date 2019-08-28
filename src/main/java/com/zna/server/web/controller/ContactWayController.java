package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.ContactWayBO;
import com.zna.server.entity.bo.CooperativeClientBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.service.ContactWayService;
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

@Controller
@RequestMapping("/contactWay")
public class ContactWayController extends BaseCotroller {
    private static final Logger log = LoggerFactory.getLogger(ContactWayController.class);

    @Resource
    private ContactWayService contactWayService;

    /**
     * 更新联系方式
     * 【有数据则修改，没数据则添加】
     * @param mobile 手机
     * @param faxNO 传真
     * @param email 邮箱
     * @param pictureOne 图片1
     * @param pictureTwo 图片2
     * @param pictureThree 图片3
     * @param request
     * @param response
     */
    @RequestMapping("/updateContactWay")
    public void   updateContactWay(String mobile, String faxNO, String email, String pictureOne, String pictureTwo, String pictureThree, HttpServletRequest request, HttpServletResponse response) {
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
            if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(faxNO)||StringUtils.isEmpty(email)){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            contactWayService.updateContactWay(mobile,faxNO,email,pictureOne,pictureTwo,pictureThree,loginAdmin.getId(),loginAdmin.getId());
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("更新成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateContactWayException",e);
        }
    }

    /**
     * 查询
     * @param request
     * @param response
     */
    @RequestMapping("/getContactWay")
    public void getContactWay(HttpServletRequest request, HttpServletResponse response){
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
            ContactWayBO contactWayBO = contactWayService.getContactWay();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(contactWayBO));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("getContactWayException",e);
        }

    }

}
