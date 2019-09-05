package com.zna.server.web.controller;

import com.zna.server.entity.bo.AboutBannerBO;
import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.service.AboutBannerService;
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
@RequestMapping("/aboutBanner")
public class AboutBannerController extends BaseCotroller {
    private static final Logger log = LoggerFactory.getLogger(AboutBannerController.class);

    @Resource
    private AboutBannerService aboutBannerService;

    /**
     * 查询banner
     * @param state
     * @return
     */
    @RequestMapping("/selectAboutBanner")
    public void selectAboutBanner(String state, HttpServletRequest request, HttpServletResponse response){
        try{
            log.info(request.getRequestURI());
            log.info("param:{}", JsonUtils.getJsonString4JavaPOJO(request.getParameterMap()));
            //获取管理员对象
            AdminBO loginAdmin = super.getLoginAdmin(request);
            log.info("user{}",loginAdmin);

            List<AboutBannerBO> bannerBOS = aboutBannerService.selectAboutBanner(state);
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(bannerBOS));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("selectBannerException",e);
        }
    }


    /**
     * 新增banner
     * @param state
     * @return
     */
    @RequestMapping("/addAboutBanner")
    public void addAboutBanner(AboutBannerBO aboutBannerBO, HttpServletRequest request, HttpServletResponse response){
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
            //验证参数
            if (aboutBannerBO==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            aboutBannerBO.setCreateUserId(loginAdmin.getId());
            aboutBannerService.addAboutBanner(aboutBannerBO);

            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("添加成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("addAboutBannerException",e);
        }
    }

    /**
     * 修改banner
     * @param state
     * @return
     */
    @RequestMapping("/updateAboutBanner")
    public void updateAboutBanner(Integer id,String title,String titleEnglish,String context,String contextEnglish,String pictureUrl,String pictureUrlPc,String skipUrl,String skipType,Integer skipId,Integer sort,String state, HttpServletRequest request, HttpServletResponse response){
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
            //验证参数
            if (id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            aboutBannerService.updateAboutBanner(id,title,titleEnglish,context,contextEnglish,pictureUrl,pictureUrlPc,skipUrl,skipType,skipId,sort,state,loginAdmin.getId());

            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("updateAboutBannerException",e);
        }
    }

    /**
     * banner上下架
     * @param state
     * @return
     */
    @RequestMapping("/showOrNotAboutBanner")
    public void showOrNotAboutBanner(Integer id,String state, HttpServletRequest request, HttpServletResponse response){
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
            //验证参数
            if (id==null|| StringUtils.isEmpty(state)){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            aboutBannerService.showOrNotAboutBanner(state,loginAdmin.getId(),id);

            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("修改成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("showOrNotAboutBannerException",e);
        }
    }

    /**
     * 删除banner
     * @param id
     * @return
     */
    @RequestMapping("/removeAboutBanner")
    public void removeAboutBanner(Integer id, HttpServletRequest request, HttpServletResponse response){
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
            //验证参数
            if (id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            aboutBannerService.removeAboutBanner(id);

            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success("删除成功！"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }catch (Exception e){
            e.getStackTrace();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000005"));
            super.safeJsonPrint(response, result);
            log.error("removeAboutBannerException",e);
        }
    }
}
