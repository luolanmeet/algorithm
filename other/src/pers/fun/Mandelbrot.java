package pers.fun;

import pers.fun.Complex;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * 曼德勃罗集
 */
public class Mandelbrot {

    private static final String img_url = "mandelbrot.png";
    private static final int width = 1300;
    private static final int heigth = 1000;

    public static void create() throws IOException {

        BufferedImage bi = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bi.getGraphics();

        // 轴
        double xaxis = width / 2.2 + 80;
        double yaxis = heigth / 2D;
        // 缩放
        double scale = 300;
        // 最大迭代次数
        int maxit = 200;

        int[] color = new int[3];

        for (int y = 0; y <= heigth / 2; y++) {

            for (int x = 0; x < width; x++) {

                Complex d = new Complex(0, 0);
                Complex c = new Complex((x - xaxis) / scale, (y - yaxis) / scale);

                color[0] = 0;
                color[1] = 0;
                color[2] = 10;

                for (int i = 0; i < maxit; i++) {

                    d = d.pow(2).add(c);

                    // 半径超过2则判断为非集合元素
                    if (d.getReal() * d.getReal() + d.getImag() * d.getImag() < 4.0) {
                        continue;
                    }

                    if (i <= 25) {
                        color[0] = i * 10;
                    } else {
                        color[0] = 255;
                        color[1] = (int) (Math.sqrt(i) * 10);
                        color[2] = 125;
                    }

                    //设置画笔颜色
                    graphics.setColor(new Color(color[0], color[1], color[2]));
                    //画点
                    graphics.drawLine(x, y, x, y);
                    graphics.drawLine(x, heigth - y - 1, x, heigth - y - 1);
                    break;
                }
            }
        }

        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("png");
        ImageWriter writer = it.next();
        File f = new File(img_url);
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        writer.setOutput(ios);
        writer.write(bi);
    }

    public static void main(String[] args) throws IOException {

        create();
        ImageIcon icon = new ImageIcon(img_url);

        JFrame frame = new JFrame("曼德勃罗集");
        JLabel label = new JLabel(icon);
        label.setIcon(icon);
        frame.add(label);

        frame.setSize(width, heigth);
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
