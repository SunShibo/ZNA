package com.zna.server.web.controller;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.zna.server.entity.bo.AdminBO;
import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.util.JsonUtils;
import com.zna.server.util.StringUtils;
import com.zna.server.web.controller.base.BaseCotroller;
import jdk.internal.util.xml.impl.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

@Controller
@RequestMapping("/image")
public class ImageController extends BaseCotroller {

    private static final Logger log = LoggerFactory.getLogger(AboutUsController.class);


    @ResponseBody
    @RequestMapping("/uploadImg")
    public void uploadPicture(MultipartFile file, HttpServletRequest request, HttpServletResponse response){
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

    /**
     * 获取图片宽度和高度
     *
     * @param
     * @return 返回图片的宽度
     */
    public static int[] getImgWidthHeight(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int result[] = { 0, 0 };
        try {
            // 获得文件输入流
            is = new FileInputStream(file);
            // 从流里将图片写入缓冲图片区
            src = ImageIO.read(is);
            result[0] =src.getWidth(null); // 得到源图片宽
            result[1] =src.getHeight(null);// 得到源图片高
            is.close();  //关闭输入流
        } catch (Exception ef) {
            ef.printStackTrace();
        }

        return result;
    }
}
