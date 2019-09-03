package com.zna.server.web.controller;

import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.util.JsonUtils;
import com.zna.server.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/test")
public class TestController extends BaseCotroller {

    private static final Logger log = LoggerFactory.getLogger(AboutUsController.class);

    /***
     *
     *  newFilePath 生成的文件路径
     * @param file SpringMvc接收到的文件
     *  width 存储的图片的宽
     *  height 存储的图片的高
     * @ isRatio 是否等比例缩放，true为按比例缩放，false为按固定尺寸缩放
     * @return 带路径的文件名称
     * @throws IllegalStateException
     * @throws IOException
     * @author Pcject
     */
    @RequestMapping("/test")
    public  void imgUploadZip( MultipartFile file, HttpServletRequest request, HttpServletResponse response)throws IllegalStateException, IOException {

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

        File targetFile=null;
        String url="";//返回存储路径
        System.out.println(file);
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        System.out.println(fileName);
        if(fileName!=null&&fileName!=""){
            //String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/static/imgs/";//存储路径
            String returnUrl = "/image/";//存储路径
            String path ="C:\\image";// request.getSession().getServletContext().getRealPath("static/imgs"); //文件存储位置


            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名




            //获取文件夹路径
            File file1 =new File(path);
            //如果文件夹不存在则创建
            if(!file1 .exists()  && !file1 .isDirectory()){
                file1 .mkdir();
            }
            //将图片存入文件夹
            targetFile = new File(file1, fileName);
            try {
                //将上传的文件写到服务器上指定的文件。
                file.transferTo(targetFile);
                url=returnUrl+fileName;
                String result = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(url));
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

    @Resource
    private RequestMappingHandlerMapping handlerMapping;

    /**
     * 获取项目中的url
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("/index")
    public void index(Long id, HttpServletRequest request, HttpServletResponse response) {

        Map map =  this.handlerMapping.getHandlerMethods();
        Iterator<?> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() );
        }
    }
}


