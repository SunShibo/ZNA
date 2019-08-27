package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.bo.HistoryBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.service.HistoryService;
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
@RequestMapping("/history")
public class HistoryController extends BaseCotroller {
    private static final Logger log = LoggerFactory.getLogger(AboutUsController.class);

    @Resource
    private HistoryService historyService;

    /**
     * 添加发展历史
     * @param pictureUrl 图片地址
     * @param time 时间
     * @param context 内容
     * @param contextEnglish 内容（英文）
     * @param sort 序号
     * @param request
     * @param response
     */
    @RequestMapping("/addHistory")
    public void addHistory(String pictureUrl,String time,String context,
                           String contextEnglish,Integer sort,HttpServletRequest request, HttpServletResponse response){
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
            if (StringUtils.isEmpty(pictureUrl)||StringUtils.isEmpty(context)||StringUtils.isEmpty(contextEnglish)||StringUtils.isEmpty(time)||sort==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            historyService.addHistory(pictureUrl,time,context,contextEnglish,sort,loginAdmin.getId());
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
     * 删除发展历史
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("/delHistory")
    public void delHistory(Integer id,HttpServletRequest request, HttpServletResponse response){
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
            if (id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            historyService.delHistory(id);
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
     * 修改发展历史
     * @param pictureUrl
     * @param time
     * @param context
     * @param contextEnglish
     * @param sort
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("/updateHistory")
    public void updateHistory(String pictureUrl,String time,String context, String contextEnglish,
                              Integer sort,Integer id,HttpServletRequest request, HttpServletResponse response){
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
            if (id==null){
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
                super.safeJsonPrint(response, result);
                log.info("result{}",result);
                return ;
            }
            historyService.updateHistory(pictureUrl,time,context,contextEnglish,sort,loginAdmin.getId(),id);
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
     * 查询发展历史
     * @param request
     * @param response
     */
    @RequestMapping("/getHistory")
    public void getHistory(HttpServletRequest request, HttpServletResponse response){
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

            List<HistoryBO> historyBOS = historyService.getHistory();
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(historyBOS));
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
