/**
 * 
 */
package com.deflexicon.sample.command;

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
		throw new CommandParseException();
	}

}
