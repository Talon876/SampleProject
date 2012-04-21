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
		output = getAvailCommands();
	}
	
	/**
	 * Creates the help command with the output of the command's help text
	 * @param cmd String name of the Command
	 * @throws CommandParseException If the String is not a valid command
	 */
	public HelpCommand(String stringArg) throws CommandParseException
	{
		super(stringArg);
		output = getAvailCommands();
		Command cmd = null;
		
		if(stringArg.equalsIgnoreCase(COMMANDS.HELP.toString()))
		{
			return; //if they want help with help well then return the default output
		}
		try
		{
			cmd = CommandParser.parseString(stringArg);
		}
		catch(CommandParseException e)
		{
			throw new CommandParseException("Command " + stringArg + " does not exist\n" + output); //Gives the standard output if the command is invalid
		}
		output = cmd.getHelpText();
	}
	
	private String getAvailCommands()
	{
		String out = helpText + "\nAvailable Commands:\n";
		Command cmdObject = null;
		
		for(COMMANDS cmd : COMMANDS.values())
		{
			if(cmd != COMMANDS.HELP)
			{
				try
				{
					cmdObject = CommandParser.parseString(cmd.toString());
				}
				catch (CommandParseException e)
				{
					e.printStackTrace(); //shouldn't happen
				}
				
				if(cmdObject != null)
				{
					out += cmd.toString().toLowerCase() + " - " + cmdObject.getHelpText() + "\n";
				}
				else
				{
					out += cmd.toString().toLowerCase() + " - not yet implemented.\n";
				}
			}
		}
		return out;
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

	@Override
	public String doCommand() {
		return getResults();
		
	}
}
