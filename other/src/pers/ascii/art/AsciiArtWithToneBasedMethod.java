package pers.ascii.art;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 
 */
public class AsciiArtWithToneBasedMethod {
    
    public static void main(String[] args) throws IOException {
    
        File imgFile = new File(args[0]);
        if (!imgFile.exists() || imgFile.isDirectory()) {
            System.out.println("file no exist or file is dir.");
            return ;
        }
    
        BufferedImage bi = ImageIO.read(imgFile);
    
        int width = bi.getWidth();
        int height = bi.getHeight();
        int minX = bi.getMinX();
        int minY = bi.getMinY();
    
        int[] rgb = new int[3];
        // 获取灰度值
        int[][] grayValue = new int[width][height];
        for (int i = minX; i < width; i++) {
            for (int j = minY; j < height; j++) {
    
                //获得像素值
                int pixel = bi.getRGB(i, j);
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                grayValue[i][j] = (rgb[0] * 150 + rgb[1] * 59 + rgb[2] * 11 + 150) / 150;
            }
        }
    
        // 把灰度值替换成字符
        String[] strs = {"M", "N", "H", "Q", "$", "O", "C", "?", "7", ">", "!", ":", "–", ";", "."};
        String[][] res = new String[width][height];
        for (int i = minX; i < width; i++) {
            for (int j = minY; j < height; j++) {
                res[i][j] = strs[grayValue[i][j] % 15];
            }
        }

        // 输出结果
        for (int i = minX; i < width; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        
    }

}
