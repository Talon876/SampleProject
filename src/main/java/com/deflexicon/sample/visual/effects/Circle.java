package com.deflexicon.sample.visual.effects;

import java.awt.Graphics2D;
import java.awt.Point;

import com.deflexicon.sample.engine.Framework;
import com.deflexicon.sample.tools.ValueInterpolator;
import com.deflexicon.sample.tools.Vector2;

public class Circle
{
	private Point position = new Point();
	private int radius = 1;
	private Vector2 velocity = new Vector2();
	private int speed = 2;
	private ValueInterpolator radiusChanger = new ValueInterpolator(100, 250);

	/**
	 * Creates a Circle
	 */
	public Circle()
	{
		position = new Point(0, 0);
		radiusChanger = new ValueInterpolator(15, 15);
		velocity = new Vector2(0, 0);
	}

	/**
	 * Creates a Circle at a given position
	 * @param position The initial position of the circle
	 */
	public Circle(Point position)
	{
		this.position = position;
		radiusChanger = new ValueInterpolator(15, 15);
		velocity = new Vector2(0, 0);
	}

	/**
	 * Creates a Circle at a given position with a given velocity
	 * @param position The initial position of the circle
	 * @param velocity The initial velocity of the circle
	 */
	public Circle(Point position, Vector2 velocity)
	{
		this.position = position;
		radiusChanger = new ValueInterpolator(15, 15);
		this.velocity = velocity;
	}

	/**
	 * Updates the circle
	 * Position is updated according to velocity
	 * If the circle attempts to leave the screen, it bounces back in to view
	 */
	public void update()
	{
		if (velocity.length() != 0)
		{
			velocity.normalize();
		}

		position.x += velocity.x * speed;
		position.y += velocity.y * speed;

		if (position.x - radius < 0)
		{
			velocity.x *= -1;
			position.x = 0 + radius;
		}
		if (position.x + radius > Framework.frameWidth)
		{
			velocity.x *= -1;
			position.x = Framework.frameWidth - radius;
		}

		if (position.y - radius < 0)
		{
			velocity.y *= -1;
			position.y = 0 + radius;
		}
		if (position.y + radius > Framework.frameHeight)
		{
			velocity.y *= -1;
			position.y = Framework.frameHeight - radius;
		}

		radiusChanger.update();
		radius = radiusChanger.getValue();
	}

	/**
	 * Draws the circle
	 * @param g2d The graphics2D object to do the drawing
	 */
	public void draw(Graphics2D g2d)
	{
		g2d.drawOval(position.x - radius, position.y - radius, radius * 2, radius * 2);
	}

	/**
	 * 
	 * @return the current velocity of the circle
	 */
	public Vector2 getVelocity()
	{
		return velocity;
	}

	/**
	 * Sets the velocity of the circle
	 * @param velocity The new velocity
	 */
	public void setVelocity(Vector2 velocity)
	{
		this.velocity = velocity.normalize();
	}

	/**
	 * 
	 * @return the current speed of the circle
	 */
	public int getSpeed()
	{
		return speed;
	}

	/**
	 * Sets the speed of the circle
	 * @param speed The new speed
	 */
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	/**
	 * 
	 * @return the current position of the circle
	 */
	public Point getPosition()
	{
		return position;
	}

	/**
	 * 
	 * @return the radius of the circle
	 */
	public int getRadius()
	{
		return radius;
	}

}
