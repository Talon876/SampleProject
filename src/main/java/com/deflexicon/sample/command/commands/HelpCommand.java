/**
 * 
 */
package com.deflexicon.sample.command.commands;

import com.deflexicon.sample.command.COMMANDS;
import com.deflexicon.sample.command.Command;

/**
 * @author Talon Daniels
 *
 */
public class HelpCommand extends Command implements DataCommand
{
	String helpText = "Type help <command> for help with that command";
	String output = "";

	/**
	 * Creates a Help command which can be executed
	 */
	public HelpCommand()
	{
		output = "Available Commands:\n";
		for(COMMANDS cmd : COMMANDS.values())
		{
			output += cmd + "\n";
		}
	}
	
	public HelpCommand(String stringArg)
	{
		//TODO make this dynamicly get the help text for every command
		if(stringArg.equalsIgnoreCase("help"))
		{
			output = new HelpCommand().getHelpText();
		}
	}

	@Override
	public String getResults()
	{
		return output;
	}

	@Override
	public String getHelpText()
	{
		return helpText;
	}

}
