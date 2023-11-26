package org.CDA.commend.Run;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class imagevi {
    public static void HelpShow(String[] args){
        System.out.println("ConsoleImagePreviewer");
    }
    public static void Runtime(String[] args){
        if (args.length>1){
            lookPic(args[1]);
        }else {
           System.out.println("what?");
        }
    }
    private static void lookPic(String path){
        try {
            BufferedImage image = ImageIO.read(new File(path));
            outputColorfulAsciiArt(image);
//            System.out.println(asciiArt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static void outputColorfulAsciiArt(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y += 6) {
            for (int x = 0; x < width; x += 3) {
                int pixel = image.getRGB(x, y);
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                // 根据像素的颜色输出相应的 ANSI 转义码
                if (r > 200 && g > 200 && b > 200) {
                    System.out.print("\u001B[37m@\u001B[0m"); // 白色
                } else if (r > 200) {
                    System.out.print("\u001B[31m#\u001B[0m"); // 红色
                } else if (g > 200) {
                    System.out.print("\u001B[32m*\u001B[0m"); // 绿色
                } else if (b > 200) {
                    System.out.print("\u001B[34m=\u001B[0m"); // 蓝色
                } else {
                    System.out.print("\u001B[33m.\u001B[0m"); // 黄色
                }
            }
            System.out.println();
        }
    }
}
