package com.codex.cg.geom;

import com.codex.cg.math.ColorRGBA;
import com.codex.cg.render.ImageRaster;

public class Line2D implements Drawable
{
    public int x0, y0;
    public int x1, y1;
    public ColorRGBA color = ColorRGBA.RED;

    @Override
    public void draw(ImageRaster imageRaster)
    {
        imageRaster.drawLine(x0, y0, x1, y1, color);
    }
}
