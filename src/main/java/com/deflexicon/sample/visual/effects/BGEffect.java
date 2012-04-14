package com.deflexicon.sample.visual.effects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.deflexicon.sample.engine.Framework;

public class BGEffect implements Effect
{
	Rectangle fillArea;
	Color bgColor;

	public BGEffect(int r, int g, int b)
	{
		fillArea = new Rectangle(0, 0, Framework.frameWidth, Framework.frameHeight);
		bgColor = new Color(r, g, b);
	}

	@Override
	public void update(Point mousePosition)
	{

	}

	@Override
	public void draw(Graphics2D g2d, Point mousePosition)
	{
		g2d.setColor(bgColor);
		g2d.fillRect(fillArea.x, fillArea.y, fillArea.width, fillArea.height);
	}
}
