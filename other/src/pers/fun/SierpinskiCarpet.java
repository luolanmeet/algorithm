package pers.fun;

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
 * 谢尔宾斯基地毯
 */
public class SierpinskiCarpet {

    private static final int width = 999;
    private static final int heigth = 999;

    private static final String img_url = "img/sierpinskiCarpet.png";

    public static void create() throws IOException {

        BufferedImage bi = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bi.getGraphics();

        Point topL = new Point(0, 0);
        Point topR = new Point(width, 0);
        Point bottomL = new Point(0, heigth);
        Point bottomR = new Point(width, heigth);

        method(topL, topR, bottomL, bottomR, graphics);

        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("png");
        ImageWriter writer = it.next();
        File f = new File(img_url);
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        writer.setOutput(ios);
        writer.write(bi);
    }

    private static void method(Point topL, Point topR, Point bottomL, Point bottomR, Graphics graphics) {

        if (topR.getX() - topL.getX() < 10) {
            return ;
        }

        // 当前正方形的长度 / 3
        int len = (topR.getX() - topL.getX()) / 3;

        Point newTopL = new Point(topL.getX() + len, topL.getY() + len);
        Point newTopR = new Point(topR.getX() - len, topL.getY() + len);

        Point newBottomL = new Point(bottomL.getX() + len, bottomL.getY() - len);
        Point newBottomR = new Point(bottomR.getX() - len, bottomR.getY() - len);

        draw(newTopL, newTopR, newBottomL, newBottomR, graphics);

        // 新产生8个正方形，坐标可共同使用
        Point a1 = new Point(topL.getX() + len, topL.getY());
        Point b0 = new Point(topL.getX(), topL.getY() + len);
        method(topL, a1, b0, newTopL, graphics);

        Point a2 = new Point(a1.getX() + len, topL.getY());
        method(a1, a2, newTopL, newTopR, graphics);

        Point b3 = new Point(newTopR.getX() + len, newTopR.getY());
        method(a2, topR, newTopR, b3, graphics);

        Point c0 = new Point(newBottomL.getX() - len, newBottomL.getY());
        method(b0, newTopL, c0, newBottomL, graphics);

        Point c3 = new Point(newBottomR.getX() + len, newBottomR.getY());
        method(newTopR, b3, newBottomR, c3, graphics);

        Point d1 = new Point(bottomL.getX() + len, bottomL.getY());
        method(c0, newBottomL, bottomL, d1, graphics);

        Point d2 = new Point(d1.getX() + len, d1.getY());
        method(newBottomL, newBottomR, d1, d2, graphics);

        Point d3 = new Point(d1.getX() + len, d1.getY());
        method(newBottomR, c3, d2, bottomR, graphics);
    }

    private static void draw(
            Point topL, Point topR,
            Point bottomL, Point bottomR, Graphics graphics) {

        int[] color = new int[3];
//        color[0] = 155;
//        color[1] = 130;
//        color[2] = 100;
//        color[0] = topL.getX() % 255;
//        color[1] = topR.getX() % 255;
//        color[2] = bottomL.getX() % 255;
        color[0] = (topL.getX() + bottomR.getY()) % 255;
        color[1] = (topR.getY() + bottomR.getX()) % 255;
        color[2] = (bottomL.getX() + bottomL.getY()) % 255;

        // 设置画笔颜色
        graphics.setColor(new Color(color[0], color[1], color[2]));
        // 画线
        graphics.drawLine(topL.getX(), topL.getY(), topR.getX(), topR.getY());
        graphics.drawLine(topL.getX(), topL.getY(), bottomL.getX(), bottomL.getY());
        graphics.drawLine(bottomR.getX(), bottomR.getY(), topR.getX(), topR.getY());
        graphics.drawLine(bottomR.getX(), bottomR.getY(), bottomL.getX(), bottomL.getY());
    }

    public static void main(String[] args) throws IOException {

        create();
        ImageIcon icon = new ImageIcon(img_url);

        JFrame frame = new JFrame("谢尔宾斯基地毯");
        JLabel label = new JLabel(icon);
        label.setIcon(icon);
        frame.add(label);
        frame.setSize(width + 20, heigth + 40);
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
