package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.ServiceusBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.service.ServiceusService;
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
@RequestMapping("/service")
public class ServiceusController extends BaseCotroller {
    private static final Logger log = LoggerFactory.getLogger(TeamController.class);
    @Resource
    private ServiceusService serviceusService;

    /**
     * 更新关于我们中的服务
     * 有数据就修改，没有就添加
     * @param pictureUrl
     * @param context
     * @param request
     * @param response
     */
    @RequestMapping("/updateservice")
    public void updateservice(String pictureUrl,String pictureUrlPc,String context,String contextEnglish,String title,String titleEnglish, HttpServletRequest request, HttpServletResponse response){
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
//            if (StringUtils.isEmpty(pictureUrl)||StringUtils.isEmpty(pictureUrlPc)||StringUtils.isEmpty(context)||StringUtils.isEmpty(title)){
//                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
//                super.safeJsonPrint(response, result);
//                log.info("result{}",result);
//                return ;
//            }
            serviceusService.updateservice(pictureUrl,pictureUrlPc,context,contextEnglish,title,titleEnglish);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("更新成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateserviceException",e);
        }

    }

    /**
     * 查询关于我们中的服务
     * @param request
     * @param response
     */
    @RequestMapping("/getservice")
    public void getservice(HttpServletRequest request, HttpServletResponse response){
        try{
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);

            ServiceusBO serviceusBO = serviceusService.getservice();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(serviceusBO));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;

        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("getAboutUsException",e);
        }

    }

}
