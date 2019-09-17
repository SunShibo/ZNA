package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.util.ImageUtil;
import com.zna.server.util.JsonUtils;
import com.zna.server.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/image")
public class ImageController extends BaseCotroller {

    private static final Logger log = LoggerFactory.getLogger(AboutUsController.class);


    @ResponseBody
    @RequestMapping("/uploadImg")
    public void uploadPicture(MultipartFile file, HttpServletRequest request, HttpServletResponse response){
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
        if (file==null){
            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            super.safeJsonPrint(response, result);
            log.info("result{}",result);
            return ;
        }

        String picturePC = ImageUtil.getPCpicture(file,1);
        String picturePhone = ImageUtil.getPhonepicture(file,2);
        Map<String,Object> map = new HashMap<>();
        map.put("picturePC",picturePC);
        map.put("picturePhone",picturePhone);

            String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
            super.safeJsonPrint(response, result);
            return;

            } catch (Exception e) {
                e.printStackTrace();
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("系统异常，图片上传失败"));
                super.safeJsonPrint(response, result);
                return;
            }
        }

    }



