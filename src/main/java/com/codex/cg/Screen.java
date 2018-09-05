package com.codex.cg;

import com.codex.cg.render.Image;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.*;

/**
 * 代表显示图像的窗口
 *
 * @author yanmaoyuan
 */
public class Screen
{

    // 主窗口
    private JFrame frame;

    // 画布
    private Canvas canvas;

    private BufferedImage bufferedImage;

    private BufferStrategy bufferStrategy;

    private byte[] displayComponents;

    public Screen(int width, int height, String title)
    {
        canvas = new Canvas();

        // 设置画布的尺寸
        Dimension size = new Dimension(width, height);
        canvas.setPreferredSize(size);
        canvas.setMaximumSize(size);
        canvas.setMinimumSize(size);
        canvas.setFocusable(true);

        // 创建主窗口
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setTitle(title);
        frame.add(canvas);// 设置画布
        frame.pack();
        frame.setVisible(true);
        centerScreen();// 窗口居中

        // 焦点集中到画布上，响应用户输入。
        canvas.requestFocus();


        bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);

        canvas.createBufferStrategy(2);
        bufferStrategy=canvas.getBufferStrategy();


        // 获得图像中的数组
        displayComponents = ((DataBufferByte)bufferedImage.getRaster().getDataBuffer()).getData();
    }


    public void swapBuffer(Image image, int fps)
    {
        // 把渲染好的图像拷贝到BufferedImage中。
        int width = image.getWidth();
        int height = image.getHeight();
        byte[] components = image.getComponents();
        int length = width * height;
        for (int i = 0; i < length; i++) {
            // blue
            displayComponents[i * 3] = components[i * 4 + 2];
            // green
            displayComponents[i * 3 + 1] = components[i * 4 + 1];
            // red
            displayComponents[i * 3 + 2] = components[i * 4];
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();

        // 将BufferedImage绘制到缓冲区
        graphics.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);

        // 显示帧率
        graphics.setColor(Color.WHITE);
        graphics.drawString("FPS:" + fps, 2, 16);

        graphics.dispose();

        // 显示图像
        bufferStrategy.show();
    }


    /**
     * 使窗口位于屏幕的中央。
     */
    private void centerScreen()
    {
        Dimension size = frame.getSize();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - size.width) / 2;
        int y = (screen.height - size.height) / 2;
        frame.setLocation(x, y);
    }

}