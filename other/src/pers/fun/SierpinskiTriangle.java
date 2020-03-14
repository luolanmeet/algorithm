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
 * 谢尔宾斯基三角形
 */
public class SierpinskiTriangle {

    private static final int width = 840;
    private static final int heigth = 840;

    private static final String img_url = "img/sierpinskiTriangle.png";

    public static void create() throws IOException {

        BufferedImage bi = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bi.getGraphics();

        Point top = new Point(width / 2, 0);
        Point left = new Point(0, heigth);
        Point right = new Point(width, heigth);

        draw(top, left, right, graphics);
        method(top, left, right, graphics);

        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("png");
        ImageWriter writer = it.next();
        File f = new File(img_url);
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        writer.setOutput(ios);
        writer.write(bi);
    }

    private static void method(Point top, Point left, Point right, Graphics graphics) {

        // 退出递归
        if (right.getX() - left.getX() < 10) {
            return ;
        }

        int halfPx = (right.getX() - left.getX()) / 2;
        int quarterPx = halfPx / 2;

        Point bottomMid = new Point(top.getX(), left.getY());
        Point leftMid = new Point(left.getX() + quarterPx, left.getY() - halfPx);
        Point rightMid = new Point(right.getX() - quarterPx, left.getY() - halfPx);

        draw(bottomMid, leftMid, rightMid, graphics);
        method(top, leftMid, rightMid, graphics);
        method(leftMid, left, bottomMid, graphics);
        method(rightMid, bottomMid, right, graphics);
    }

    private static void draw(Point point, Point left, Point right, Graphics graphics) {

        int[] color = new int[3];
//        int colorVal = (point.getX() + point.getY()) % 256;
//        color[0] = (point.getX() + point.getY()) % 125 + 100;
//        color[1] = (left.getX() + left.getY()) % 180 + 50;
//        color[2] = (right.getX() + right.getY()) % 256;

        color[0] = (left.getX() + left.getY()) % 180 + 10;
        color[1] = (right.getX() + right.getY()) % 256;
        color[2] = (point.getX() + point.getY()) % 60 + 60;

        // 设置画笔颜色
        graphics.setColor(new Color(color[0], color[1], color[2]));
        // 画线
        graphics.drawLine(point.getX(), point.getY(), left.getX(), left.getY());
        graphics.drawLine(point.getX(), point.getY(), right.getX(), right.getY());
        graphics.drawLine(left.getX(), left.getY(), right.getX(), right.getY());
    }

    public static void main(String[] args) throws IOException {

        create();
        ImageIcon icon = new ImageIcon(img_url);

        JFrame frame = new JFrame("谢尔宾斯基三角形");
        JLabel label = new JLabel(icon);
        label.setIcon(icon);
        frame.add(label);
        frame.setSize(width + 20, heigth + 40);
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
