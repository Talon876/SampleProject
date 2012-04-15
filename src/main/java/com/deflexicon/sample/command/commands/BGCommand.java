package com.deflexicon.sample.command.commands;

import com.deflexicon.sample.command.Command;

public class BGCommand extends Command implements EffectCommand
{

	@Override
	public String getHelpText()
	{
		return "Draws a full sized rectangle in the color provided. Useful to set as the bottom layer as anything drawn under this will not be seen.";
	}

	@Override
	public String doCommand() {
		// TODO Auto-generated method stub
		return null;
	}

}
