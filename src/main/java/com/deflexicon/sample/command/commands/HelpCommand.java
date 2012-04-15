/**
 * 
 */
package com.deflexicon.sample.command.commands;

import com.deflexicon.sample.command.COMMANDS;
import com.deflexicon.sample.command.Command;
import com.deflexicon.sample.command.CommandParseException;
import com.deflexicon.sample.command.CommandParser;

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
	
	/**
	 * Creates the help command with the output of the command's help text
	 * @param cmd String name of the Command
	 * @throws CommandParseException If the String is not a valid command
	 */
	public HelpCommand(String stringArg) throws CommandParseException
	{
		Command cmd = CommandParser.parseString(stringArg);
		output = cmd.getHelpText();
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
