package com.deflexicon.sample.visual.effects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.deflexicon.sample.engine.Framework;
import com.deflexicon.sample.tools.Vector2;

public class CircleMeshEffect implements Effect
{
	int numCircles = 25;
	ArrayList<Circle> circles = new ArrayList<Circle>();

	public CircleMeshEffect(int numCircles)
	{
		this.numCircles = numCircles;
		for (int i = 0; i < this.numCircles; i++)
		{
			Vector2 velocity = new Vector2();
			velocity.x = Math.random() * (100 - -100) + -100;
			velocity.y = Math.random() * (100 - -100) + -100;
			Circle circle = new Circle(new Point(Framework.frameWidth / 2 + (int) velocity.x, Framework.frameHeight / 2 + (int) velocity.y));
			circle.setVelocity(velocity);
			circle.setSpeed((int) (Math.random() * (12 - 4) + 4));
			circles.add(circle);
		}
		for (Circle circle : circles)
		{
			Vector2 velocity = new Vector2();
			velocity.x = Math.random() * (100 - -100) + -100;
			velocity.y = Math.random() * (100 - -100) + -100;
			circle.setVelocity(velocity);
		}

	}

	public void shuffle()
	{
		for (Circle circle : circles)
		{
			Vector2 velocity = new Vector2();
			velocity.x = Math.random() * (100 - -100) + -100;
			velocity.y = Math.random() * (100 - -100) + -100;
			circle.setVelocity(velocity);
		}
	}

	@Override
	public void update(Point moustLocation)
	{
		if (Framework.mouseButtonState(MouseEvent.BUTTON1))
		{
			for (Circle circle : circles)
			{
				Vector2 velocity = new Vector2();
				velocity.x = Math.random() * (100 - -100) + -100;
				velocity.y = Math.random() * (100 - -100) + -100;
				circle.setVelocity(velocity);
			}
		}
		for (Circle circle : circles)
		{
			circle.update();
		}
	}

	@Override
	public void draw(Graphics2D g2d, Point mousePosition)
	{
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.white);
		for (Circle circle : circles)
		{
			circle.draw(g2d);
			for (Circle circle2 : circles)
			{
				if (circle2.getPosition().distanceSq(circle.getPosition()) <= 220 * 220)
				{
					g2d.drawLine(circle.getPosition().x, circle.getPosition().y, circle2.getPosition().x, circle2.getPosition().y);
				}
			}
		}
	}

}
