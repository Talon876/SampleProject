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
	private String name = "";
	private String stringArg = "";
	ArrayList<Integer> intArgs = new ArrayList<Integer>();

	/**
	 * Creates a Command object
	 * @param name The command name; must be a valid command or nothing will happen when it is executed.
	 */
	public Command(String name)
	{
		this.name = name;
	}

	/**
	 * Creates a Command object
	 * @param name The command name; must be a valid command or nothing will happen when it is executed.
	 * @param arg An optional single string argument
	 */
	public Command(String name, String arg)
	{
		this.name = name;
		this.stringArg = arg;
	}

	/**
	 * Creates a Command object
	 * @param name The command name; must be a valid command or nothing will happen when it is executed.
	 * @param intArgs An optional list of integer arguments (just keep adding ints as constructor arguments)
	 */
	public Command(String name, int... intArgs)
	{
		this.name = name;
		for(int i = 0; i < intArgs.length; i++)
		{
			this.intArgs.add(intArgs[i]);
		}
	}

	/**
	 * Creates a Command object
	 * @param name The command name; must be a valid command or nothing will happen when it is executed.
	 * @param arg An optional single string argument
	 * @param intArgs An optional list of integer arguments (just keep adding ints as constructor arguments)
	 */
	public Command(String name, String arg, int... intArgs)
	{
		this.name = name;
		this.stringArg = arg;
		for(int i = 0; i < intArgs.length; i++)
		{
			this.intArgs.add(intArgs[i]);
		}
	}

	/**
	 * Gets the name of the command.
	 * @return The command name
	 */
	public String getName()
	{
		return name;
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
}
