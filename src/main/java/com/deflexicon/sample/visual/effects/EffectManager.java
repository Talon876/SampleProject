package com.deflexicon.sample.visual.effects;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Stack;

import com.deflexicon.sample.command.Command;
import com.deflexicon.sample.command.CommandListener;
import com.deflexicon.sample.command.commands.DataCommand;
import com.deflexicon.sample.command.commands.EffectCommand;

public class EffectManager implements CommandListener
{
	private Stack<Effect> effects;

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
		for(int i = 0; i < effects.size(); i++)
		{
			effects.get(i).draw(g2d, mousePosition);
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
		System.out.println("Command Received");
		if (command instanceof EffectCommand)
		{
			Effect effect = ((EffectCommand)command).getEffect();
			effects.push(effect);
		}
	}
}
