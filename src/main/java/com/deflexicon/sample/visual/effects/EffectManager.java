package com.deflexicon.sample.visual.effects;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Stack;

public class EffectManager //implements CommandListener
{
	Stack<Effect> effects;
	
	public EffectManager()
	{
		effects = new Stack<Effect>();
	}
	
	public void update(Point mousePosition)
	{
		for(Effect effect : effects)
		{
			effect.update(mousePosition);
		}
	}

	public void draw(Graphics2D g2d, Point mousePosition)
	{
		for(Effect effect : effects)
		{
			effect.draw(g2d, mousePosition);
		}
	}
	
	//void commandReceived(Command command){}
}
