package com.zna.server.web.controller;

import com.zna.server.entity.dto.ResultDTOBuilder;
import com.zna.server.util.ImageUtil;
import com.zna.server.util.JsonUtils;
import com.zna.server.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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


        String picturePC = ImageUtil.getPCpicture(file,1.5);
        String picturePhone = ImageUtil.getPhonepicture(file,2);
        Map<String,Object> map = new HashMap<>();
        map.put("picturePC",picturePC);
        map.put("picturePhone",picturePhone);


        String result1 = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
        super.safeJsonPrint(response, result1);
        return;
    }

}
