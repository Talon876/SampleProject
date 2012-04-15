package com.deflexicon.sample.command.commands;

import java.util.Arrays;

import com.deflexicon.sample.command.Command;
import com.deflexicon.sample.visual.effects.CircleMeshEffect;
import com.deflexicon.sample.visual.effects.Effect;

public class CMCommand extends Command implements EffectCommand
{
	public CMCommand()
	{
		super(50); // default to 50 circles
	}

	public CMCommand(int intArg)
	{
		super(intArg);
	}

	@Override
	public String getHelpText()
	{
		return "Draws a specified number of circles and connects them with lines.";
	}

	@Override
	public String doCommand()
	{
		return "Added Circle Mesh Effect with args " + Arrays.toString(intArgs.toArray());
	}

	@Override
	public Effect getEffect()
	{
		System.out.println("Returning CircleMeshEffect object with " + intArgs.get(0) + " circles");
		CircleMeshEffect effect = new CircleMeshEffect(intArgs.get(0));
		return effect;
	}

}
