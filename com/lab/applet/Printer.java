package com.lab.applet;

import java.awt.Graphics;
import java.awt.Font;

/**
 * Created by saurav on 19/10/16.
 */
class Printer
{
    Printer(Graphics g)
    {
        graphics = g;
        font = g.getFont();
        x = 6;
        y = font.getSize();
    }

    int x, y;
    Graphics graphics;
    Font font;

    public void print(String msg)
    {
        graphics.drawString(msg, x, y);
        y += font.getSize();
    }
}
