/**
 * 
 */
package com.deflexicon.sample.command;

import java.util.ArrayList;

import com.deflexicon.sample.command.commands.BGCommand;
import com.deflexicon.sample.command.commands.CMCommand;
import com.deflexicon.sample.command.commands.EchoCommand;
import com.deflexicon.sample.command.commands.HelpCommand;

/**
 * @author Steve Dighans
 *
 */
public class CommandParser {
	private CommandParser(){}
	
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
				if(splitInput.length > 1 && splitInput[1].length() > 0)//with args
					cmd = new HelpCommand(splitInput[1]);
				else
					cmd = new HelpCommand();//without
				break;
			case BG:
				cmd = parseBGCommand(splitInput);
				
				break;
			case ECHO:
				if(!input.equals(splitInput[0]))
					cmd = new EchoCommand(input.substring(splitInput[0].length() + 1)); //incase they type echo without any arguments
				else
					cmd = new EchoCommand();
				break;
			case CM:
				cmd = parseCMCommand(splitInput);
				break;
		}
		return cmd;
	}
	
	private static Command parseCMCommand(String[] splitInput) throws CommandParseException
	{
		ArrayList<Integer> args = new ArrayList<Integer>();
		if(splitInput.length > 1)
		{
			try
			{
				int arg = Integer.parseInt(splitInput[1]);
				if (arg < 0 || arg > 750)
				{
					throw new CommandParseException("Invalid argument. Arguments must be an integer between 0 and 750");
				}
				args.add(arg);
			}
			catch(Exception ex)
			{
				throw new CommandParseException("Invalid argument. Arguments must be an integer between 0 and 750");
			}
		}
		else
		{
			return new CMCommand();
		}
		
		return new CMCommand(args.get(0));
	}

	private static Command parseBGCommand(String[] splitInput) throws CommandParseException
	{
		ArrayList<Integer> args = new ArrayList<Integer>();
		if(splitInput.length > 1)
		{
			for(int i = 1; i < splitInput.length; i++)
			{
				try
				{
					int arg = Integer.parseInt(splitInput[i]);
					if(arg < 0 || arg > 255)
					{
						throw new CommandParseException("Invalid argument. Arguments must be an integer between 0 and 255");
					}
					else
					{
						args.add(arg);
					}
				}
				catch(Exception ex)
				{
					throw new CommandParseException("Invalid argument. Arguments must be an integer between 0 and 255");
				}
			}
		}
		else
		{
			return new BGCommand(); //default
		}
		
		switch(args.size())
		{
			case 1:
				return new BGCommand(args.get(0), 0, 0);
			case 2:
				return new BGCommand(args.get(0), args.get(1), 0);
			case 3:
				return new BGCommand(args.get(0), args.get(1), args.get(2));
			default:
				return new BGCommand();
		}
	}
}
