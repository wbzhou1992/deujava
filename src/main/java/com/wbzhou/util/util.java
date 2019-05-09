package com.wbzhou.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.List;
import java.util.logging.*;

public class util {
    public static String[] fuhao = {"+", "-", "*", "/"};
    public static int num = 0;

    //生成随机算式
    public static void TestLogger(String message){
        Logger log = Logger.getLogger("lavasoft");
        log.setLevel(Level.INFO);
        ConsoleHandler consoleHandler =new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        log.addHandler(consoleHandler);
        log.info(message);
    }

    public static String random() {

        List list = new ArrayList();
        Random ran = new Random();
        int n1 = ran.nextInt(10);
        int n2 = ran.nextInt(10);
        String f = fuhao[ran.nextInt(fuhao.length)];
        StringBuilder sb = new StringBuilder(4);

        switch (f) {
            case "+":
                num = n1 + n2;
                break;
            case "-":
                num = n1 - n2;
                break;
            case "*":
                num = n1 * n2;
                break;
            case "/":
                if (n2 == 0) {
                    n2 = ran.nextInt(10) + 1;
                    num = n1 / n2;
                } else {
                    num = n1 / n2;
                }
                break;
        }
        sb.append(n1);
        sb.append(f);
        sb.append(n2);
        sb.append("=");

        return sb.toString();
    }

    public static void outputImage(String str, OutputStream os) {
        Random ran = new Random();
        //创建图片对象
        BufferedImage img = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
        //获取画布
        Graphics g = img.getGraphics();
        //设置背景
        g.setColor(Color.white);
        g.fillRect(0, 0, 100, 40);
        //写字
        g.setColor(Color.black);
        g.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        g.drawString(str, 10, 40);
        //随机三条线
        g.drawLine(ran.nextInt(100), ran.nextInt(40),
                ran.nextInt(100), ran.nextInt(40));
        g.drawLine(ran.nextInt(100), ran.nextInt(40),
                ran.nextInt(100), ran.nextInt(40));
        g.drawLine(ran.nextInt(100), ran.nextInt(40),
                ran.nextInt(100), ran.nextInt(40));
        // 4. 输出结果
        // 常见的压缩格式：jpeg(有损压缩), png(无损压缩) ...
        try {
            ImageIO.write(img, "png", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
