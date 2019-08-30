package com.zna.server.web.controller;

import com.zna.server.entity.bo.AboutUsBO;
import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.ContactWayBO;
import com.zna.server.entity.bo.CooperativeClientBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.service.AboutUsService;
import com.zna.server.service.ContactWayService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关于我们
 */
@Controller
@RequestMapping("/aboutUs")
public class AboutUsController extends BaseCotroller {
    private static final Logger log = LoggerFactory.getLogger(AboutUsController.class);

    @Resource
    private AboutUsService aboutUsService;
    @Resource
    private CooperativeClientService cooperativeClientService;
    @Resource
    private ContactWayService contactWayService;

    /**
     * 更新关于我们
     * 有数据就修改，没有就添加
     * @param pictureUrl
     * @param context
     * @param contextEnglish
     * @param service
     * @param request
     * @param response
     */
    @RequestMapping("/updateAboutUs")
    public void updateAboutUs(String pictureUrl,String context,String contextEnglish,
                           String service,HttpServletRequest request, HttpServletResponse response){
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
            if (StringUtils.isEmpty(pictureUrl)||StringUtils.isEmpty(context)||StringUtils.isEmpty(contextEnglish)||StringUtils.isEmpty(service)){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            aboutUsService.updateAboutUs(pictureUrl,context,contextEnglish,service,loginAdmin.getId(),loginAdmin.getId());
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("更新成功！"));
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
     * 查询关于我们
     * @param request
     * @param response
     */
    @RequestMapping("/getAboutUs")
    public void getAboutUs(HttpServletRequest request, HttpServletResponse response){
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
            //关于我们展示
           AboutUsBO aboutUsBO = aboutUsService.getAboutUs();
            //合作客户展示
            List<CooperativeClientBO> cooperativeClientBOS = cooperativeClientService.getCooperativeClient();
            //最下面联系方式
            ContactWayBO contactWayBO = contactWayService.getContactWay();
            Map<String,Object> map = new HashMap<>();
            map.put("aboutUs",aboutUsBO);
            map.put("cooperativeClientBOS",cooperativeClientBOS);
            map.put("contactWayBO",contactWayBO);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
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
