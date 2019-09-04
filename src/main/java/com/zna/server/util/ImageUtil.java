package com.zna.server.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    public static String getPCpicture(MultipartFile file, double ratio)throws IOException {

        Image img = ImageIO.read(file.getInputStream());      // 取文件流构造Image对象
        int widthR = img.getWidth(null);    // 得到源图宽
        int heightR = img.getHeight(null);  // 得到源图宽
        int widthW =0;
        int heightW =0;
        String newFilePath = "C:/file/"; //生成的文件路径
//        String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() ;//存储路径
        boolean isRatio = true;
//        if(isRatio) {
//            // 按照宽度还是高度进行压缩
//            //注意几个变量都是int类型，需要加float强转，否则取整很容易都相等
//            if (((float)widthR / heightR) > ((float)width / height)) {
//                heightW = (int) (heightR * width / widthR);
//                widthW = width;
//            } else {
//                heightW = height;
//                widthW = (int) (widthR* height / heightR);
//            }
//        }
//        else {
//            heightW = height;
//            widthW = width;
//        }
        if(isRatio) {
            if (ratio>0){
                heightW = (int) (heightR / ratio);
                widthW = (int) (widthR  / ratio);
            }
//            else if (ratio<0){
//                heightW = (int) (heightR / -ratio);
//                widthW = (int) (widthR / -ratio);
//            }else {
//                heightW = heightR ;
//                widthW = widthR ;
//            }
        }
        BufferedImage image = new BufferedImage(widthW, heightW,BufferedImage.TYPE_INT_RGB );
        image.getGraphics().drawImage(img, 0, 0, widthW, heightW, null); // 绘制缩小后的图
        String result = "";
        String name = file.getOriginalFilename();
        name = name.replace(".", ",");
        String[] str = name.split(",");//获取文件后缀名
        String fileName =new Date().getTime()+"_"+new Random().nextInt(1000) +"PC"+"."+str[str.length-1];
        File file2 = new File(newFilePath);
        if (!file2.exists())
            file2.mkdirs();
        String filePath = newFilePath + fileName;
        ImageIO.write(image, str[str.length-1], new File(filePath));
        result = "/file/" + fileName;

        return result;
    }

    public static String getPhonepicture(MultipartFile file, double ratio)throws IOException{

        Image img = ImageIO.read(file.getInputStream());      // 取文件流构造Image对象
        int widthR = img.getWidth(null);    // 得到源图宽
        int heightR = img.getHeight(null);  // 得到源图宽
        int widthW =0;
        int heightW =0;
        String newFilePath = "C:/file/"; //生成的文件路径
        boolean isRatio = true;
//        if(isRatio)
//        {
//            // 按照宽度还是高度进行压缩
//            //注意几个变量都是int类型，需要加float强转，否则取整很容易都相等
//            if (((float)widthR / heightR) > ((float)width / height)) {
//                heightW = (int) (heightR * width / widthR);
//                widthW = width;
//            } else {
//                heightW = height;
//                widthW = (int) (widthR* height / heightR);
//            }
//        }
//        else {
//            heightW = height;
//            widthW = width;
//        }
        if(isRatio) {
            if (ratio>0){
                heightW = (int) (heightR / ratio);
                widthW = (int) (widthR / ratio);
            }
//            else if (ratio<0){
//                heightW = (int) (heightR / -ratio);
//                widthW = (int) (widthR / -ratio);
//            }else {
//                heightW = heightR ;
//                widthW = widthR ;
//            }
        }
        BufferedImage image = new BufferedImage(widthW, heightW,BufferedImage.TYPE_INT_RGB );
        image.getGraphics().drawImage(img, 0, 0, widthW, heightW, null); // 绘制缩小后的图
        String result = "";
        String name = file.getOriginalFilename();
        name = name.replace(".", ",");
        String[] str = name.split(",");//获取文件后缀名
        String fileName =new Date().getTime()+"_"+new Random().nextInt(1000) +"Phone"+"."+str[str.length-1];
        File file2 = new File(newFilePath);
        if (!file2.exists())
            file2.mkdirs();
        String filePath = newFilePath + fileName;
        ImageIO.write(image, str[str.length-1], new File(filePath));
        result = "/file/" + fileName;
        return result;
    }
}
