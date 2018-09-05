package com.codex.cg;

import com.codex.cg.geom.Point2D;
import com.codex.cg.math.ColorRGBA;

/**
 * Hello world!
 */
public class Main extends Application
{
    @Override
    protected void initialize()
    {
        // 粉色
        ColorRGBA pink = new ColorRGBA(0xFF00FFFF);

        // 画一个方块
        for (int y = 100; y < 200; y++)
        {
            for (int x = 100; x < 200; x++)
            {
                Point2D point = new Point2D();
                point.x = x;
                point.y = y;
                point.color = pink;

                // 添加到场景中
                scene.add(point);
            }
        }
    }

    @Override
    protected void update(float delta)
    {

    }

    public static void main(String[] args)
    {

        Main app = new Main();
        app.setResolution(720, 405);
        app.setTitle("Java Rasterisation");
        app.setFrameRate(120);
        app.start();
    }
}
