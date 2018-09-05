package com.codex.cg.render;

import com.codex.cg.math.ColorRGBA;

public class Renderer
{
    // 渲染图像
    private Image renderContext;
    // 光栅器
    private ImageRaster imageRaster;
    // 清屏颜色
    private ColorRGBA clearColor = ColorRGBA.WHITE;

    /**
     * 初始化渲染器
     *
     * @param width
     * @param height
     */
    public Renderer(int width, int height)
    {
        renderContext = new Image(width, height);
        imageRaster = new ImageRaster(renderContext);
    }

    /**
     * 设置背景色
     *
     * @param color
     */
    public void setBackgroundColor(ColorRGBA color)
    {
        if (color != null)
            this.clearColor = color;

    }

    /**
     * 使用背景色填充图像数据
     */
    public void clear()
    {
        imageRaster.fill(clearColor);
    }

    /**
     * 获得渲染好的图像
     *
     * @return
     */
    public Image getRenderContext()
    {
        return renderContext;
    }

    /**
     * 获得光栅器
     *
     * @return
     */
    public ImageRaster getImageRaster()
    {
        return imageRaster;
    }
}
