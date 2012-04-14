package com.deflexicon.sample.visual.effects;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Stack;

import com.deflexicon.sample.command.Command;
import com.deflexicon.sample.command.CommandListener;

public class EffectManager implements CommandListener
{
	Stack<Effect> effects;

	public EffectManager()
	{
		effects = new Stack<Effect>();
	}

	public void update(Point mousePosition)
	{
		for (Effect effect : effects)
		{
			effect.update(mousePosition);
		}
	}

	public void draw(Graphics2D g2d, Point mousePosition)
	{
		for (Effect effect : effects)
		{
			effect.draw(g2d, mousePosition);
		}
	}

	public void addEffect(Effect effect)
	{
		effects.add(effect);
	}

	public void removeEffect(Effect effect)
	{
		effects.remove(effect);
	}

	@Override
	public void commandReceived(Command command)
	{

	}
}
