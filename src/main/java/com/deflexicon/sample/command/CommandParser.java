/**
 * 
 */
package com.deflexicon.sample.command;

import com.deflexicon.sample.command.commands.*;

/**
 * @author Steve Dighans
 *
 */
public class CommandParser {
	
	// private static enum COMMANDS {HELP,}; //replaced this enum with COMMANDS in the command package so the HelpCommand can also loop through them.
	
	/**
	 * Parses the input text to check if it is a valid command returns an instance of that command
	 * @author Steve Dighans
	 * @param input
	 * 			String that is a potential command
	 * @return command
	 * 			Instance of the command inputed
	 * @throws CommandParseException
	 * 			This is thrown if the string is not a valid command
	 */
	public static Command parseString(String input) throws CommandParseException
	{
		String[] splitInput = input.split(" ");
		COMMANDS numCmd = null;
		Command cmd = null;
		try
		{
			numCmd = COMMANDS.valueOf(splitInput[0].toUpperCase());
		}
		catch(IllegalArgumentException e)
		{
			throw new CommandParseException("Command does not exist");
		}
		catch(NullPointerException e)
		{
			throw new CommandParseException("Input a command or 'help' to list commands");
		}
		switch(numCmd)
		{
			case HELP:
				if(splitInput.length > 1 && splitInput[1].length() > 0)
					cmd = new HelpCommand(splitInput[1]);
				else
					cmd = new HelpCommand();
				break;
			case BG:
				cmd = new BGCommand();
				break;
		}
		return cmd;
	}

}
