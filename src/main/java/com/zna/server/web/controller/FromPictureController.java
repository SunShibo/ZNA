package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.FromPictureBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.service.FromPictureService;
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
@RequestMapping("/fromPicture")
public class FromPictureController extends BaseCotroller {

    private static final Logger log = LoggerFactory.getLogger(AboutUsController.class);

    @Resource
    private FromPictureService fromPictureService;

    @RequestMapping("/updateFromPicture")
    public  void updateFromPicture( String pictureUrl,String pictureUrlPc, HttpServletRequest request, HttpServletResponse response) {
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
            if (StringUtils.isEmpty(pictureUrl)&&StringUtils.isEmpty(pictureUrlPc)){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            fromPictureService.updateFromPicture(pictureUrl,pictureUrlPc);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("更新成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateFromPictureException",e);
        }
    }

    @RequestMapping("/getFromPicture")
    public  void getFromPicture( HttpServletRequest request, HttpServletResponse response) {
        try{
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);

            FromPictureBO fromPictureBO = fromPictureService.getFromPicture();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(fromPictureBO));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateFromPictureException",e);
        }
    }



}
