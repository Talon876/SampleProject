/**
 * 
 */
package com.deflexicon.sample.command;

import java.util.ArrayList;

/**
 * Represents the Command class that all commands will inherit from.
 * 
 * @author Talon Daniels
 * 
 */
public abstract class Command
{
	private String stringArg = "";
	ArrayList<Integer> intArgs = new ArrayList<Integer>();

	/**
	 * Creates a Command object
	 */
	public Command()
	{
		
	}

	/**
	 * Creates a Command object
	 * @param arg An optional single string argument
	 */
	public Command(String arg)
	{
		this.stringArg = arg;
	}

	/**
	 * Creates a Command object
	 * @param intArgs An optional list of integer arguments (just keep adding ints as constructor arguments)
	 */
	public Command(int... intArgs)
	{
		for(int i = 0; i < intArgs.length; i++)
		{
			this.intArgs.add(intArgs[i]);
		}
	}

	/**
	 * Creates a Command object
	 * @param arg An optional single string argument
	 * @param intArgs An optional list of integer arguments (just keep adding ints as constructor arguments)
	 */
	public Command(String arg, int... intArgs)
	{
		this.stringArg = arg;
		for(int i = 0; i < intArgs.length; i++)
		{
			this.intArgs.add(intArgs[i]);
		}
	}

	/**
	 * Gets the string argument. Blank if none was given
	 * @return The optional string argument, or an empty string if none was given during creation
	 */
	public String getStringArg()
	{
		return stringArg;
	}

	/**
	 * Gets the list of integer arguments.
	 * @return An ArrayList of integer arguments, or an empty list if none was given during creation
	 */
	public ArrayList<Integer> getIntArgs()
	{
		return intArgs;
	}

	/**
	 * Gets the help text for this command
	 * @return
	 */
	public abstract String getHelpText();
}
