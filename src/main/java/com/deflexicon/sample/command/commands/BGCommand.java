package com.deflexicon.sample.command.commands;

import com.deflexicon.sample.command.Command;
import com.deflexicon.sample.visual.effects.BGEffect;
import com.deflexicon.sample.visual.effects.Effect;

public class BGCommand extends Command implements EffectCommand
{

	@Override
	public String getHelpText()
	{
		return "Draws a full sized rectangle in the color provided. Useful to set as the bottom layer as anything drawn under this will not be seen.";
	}

	@Override
	public String doCommand()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Effect getEffect()
	{
		BGEffect effect = new BGEffect(intArgs.get(0), intArgs.get(1), intArgs.get(2));
		return effect;
	}

}
