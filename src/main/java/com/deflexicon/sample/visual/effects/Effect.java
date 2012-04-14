package com.deflexicon.sample.visual.effects;

import java.awt.Graphics2D;
import java.awt.Point;

public interface Effect
{
	void update(Point mousePosition);

	void draw(Graphics2D g2d, Point mousePosition);
}