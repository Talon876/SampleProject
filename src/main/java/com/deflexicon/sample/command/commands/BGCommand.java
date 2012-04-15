package com.deflexicon.sample.command.commands;

import java.util.Arrays;

import com.deflexicon.sample.command.Command;
import com.deflexicon.sample.visual.effects.BGEffect;
import com.deflexicon.sample.visual.effects.Effect;

public class BGCommand extends Command implements EffectCommand
{
	/**
	 * Creates a BGCommand with a default Black background
	 */
	public BGCommand()
	{
		super(0,0,0);
	}
	
	/**
	 * Creates a BGCommand object
	 * @param intArgs Any ints missing will be treated as 0
	 */
	public BGCommand(int... intArgs)
	{
		super(intArgs);
	}

	@Override
	public String getHelpText()
	{
		return "Draws a full sized rectangle in the color provided. Useful to set as the bottom layer as anything drawn under this will not be seen.";
	}

	@Override
	public String doCommand()
	{
		return "Added BG effect with args " + Arrays.toString(intArgs.toArray());
	}

	@Override
	public Effect getEffect()
	{
		BGEffect effect = new BGEffect(intArgs.get(0), intArgs.get(1), intArgs.get(2));
		return effect;
	}

}
