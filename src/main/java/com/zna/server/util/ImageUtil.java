package com.zna.server.util;

import com.zna.server.pop.SystemConfig;
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
        String newFilePath =  SystemConfig.getString("pictureurl"); //生成的文件路径
        boolean isRatio = true;
        if(isRatio) {
            if (ratio>0){
                heightW = (int) (heightR / ratio);
                widthW = (int) (widthR  / ratio);
            }
        }
        BufferedImage image = new BufferedImage(widthW, heightW,BufferedImage.TYPE_INT_RGB );
        image.getGraphics().drawImage(img, 0, 0, widthW, heightW, null); // 绘制缩小后的图
//        Graphics2D g2d = image.createGraphics();
//        image = g2d.getDeviceConfiguration().createCompatibleImage(widthW,heightW,Transparency.TRANSLUCENT);
//        g2d.dispose();
//
//        g2d = image.createGraphics();
//
//        Image from = img.getScaledInstance(widthW, heightW, img.SCALE_AREA_AVERAGING);
//        g2d.drawImage(from, 0, 0, null);
//        g2d.dispose();

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
        String newFilePath = SystemConfig.getString("pictureurl"); //生成的文件路径
        boolean isRatio = true;
        if(isRatio) {
            if (ratio>0){
                heightW = (int) (heightR / ratio);
                widthW = (int) (widthR / ratio);
            }
        }
        BufferedImage image = new BufferedImage(widthW, heightW,BufferedImage.TYPE_INT_RGB );
        image.getGraphics().drawImage(img, 0, 0, widthW, heightW, null); // 绘制缩小后的图
//        Graphics2D g2d = image.createGraphics();
//        image = g2d.getDeviceConfiguration().createCompatibleImage(widthW,heightW,Transparency.TRANSLUCENT);
//        g2d.dispose();
//
//        g2d = image.createGraphics();
//
//        Image from = img.getScaledInstance(widthW, heightW, img.SCALE_AREA_AVERAGING);
//        g2d.drawImage(from, 0, 0, null);
//        g2d.dispose();


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

    public static String getPCpicturePng(MultipartFile file, double ratio)throws IOException {

        Image img = ImageIO.read(file.getInputStream());      // 取文件流构造Image对象
        int widthR = img.getWidth(null);    // 得到源图宽
        int heightR = img.getHeight(null);  // 得到源图宽
        int widthW =0;
        int heightW =0;
        String newFilePath =  SystemConfig.getString("pictureurl"); //生成的文件路径
        boolean isRatio = true;
        if(isRatio) {
            if (ratio>0){
                heightW = (int) (heightR / ratio);
                widthW = (int) (widthR  / ratio);
            }
        }
        BufferedImage image = new BufferedImage(widthW, heightW,BufferedImage.TYPE_INT_RGB );
        //image.getGraphics().drawImage(img, 0, 0, widthW, heightW, null); // 绘制缩小后的图
        Graphics2D g2d = image.createGraphics();
        image = g2d.getDeviceConfiguration().createCompatibleImage(widthW,heightW,Transparency.TRANSLUCENT);
        g2d.dispose();

        g2d = image.createGraphics();

        Image from = img.getScaledInstance(widthW, heightW, img.SCALE_AREA_AVERAGING);
        g2d.drawImage(from, 0, 0, null);
        g2d.dispose();

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

    public static String getPhonepicturePng(MultipartFile file, double ratio)throws IOException{

        Image img = ImageIO.read(file.getInputStream());      // 取文件流构造Image对象
        int widthR = img.getWidth(null);    // 得到源图宽
        int heightR = img.getHeight(null);  // 得到源图宽
        int widthW =0;
        int heightW =0;
        String newFilePath = SystemConfig.getString("pictureurl"); //生成的文件路径
        boolean isRatio = true;
        if(isRatio) {
            if (ratio>0){
                heightW = (int) (heightR / ratio);
                widthW = (int) (widthR / ratio);
            }
        }
        BufferedImage image = new BufferedImage(widthW, heightW,BufferedImage.TYPE_INT_RGB );
        //image.getGraphics().drawImage(img, 0, 0, widthW, heightW, null); // 绘制缩小后的图
        Graphics2D g2d = image.createGraphics();
        image = g2d.getDeviceConfiguration().createCompatibleImage(widthW,heightW,Transparency.TRANSLUCENT);
        g2d.dispose();

        g2d = image.createGraphics();

        Image from = img.getScaledInstance(widthW, heightW, img.SCALE_AREA_AVERAGING);
        g2d.drawImage(from, 0, 0, null);
        g2d.dispose();


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
