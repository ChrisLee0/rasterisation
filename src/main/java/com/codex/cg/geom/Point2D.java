package com.codex.cg.geom;

import com.codex.cg.math.ColorRGBA;
import com.codex.cg.render.ImageRaster;

public class Point2D implements Drawable
{
    public int x, y;
    public ColorRGBA color;

    @Override
    public void draw(ImageRaster imageRaster)
    {
        imageRaster.drawPixel(x, y, color);
    }
}
