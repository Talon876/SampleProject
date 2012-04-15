/**
 * 
 */
package com.deflexicon.sample.command;

import com.deflexicon.sample.command.commands.EffectCommand;
import com.deflexicon.sample.visual.effects.Effect;

/**
 * A class with a single static method which takes in Command objects and creates an Effect representing the command.
 * @author Talon
 *
 */
public class CommandToEffect
{
	/**
	 * Converts the given command in to an effect
	 * @param command The command to be converted
	 * @return An effect representing the command
	 */
	public static Effect convertToEffect(EffectCommand command)
	{
		//TODO switch statement checking which command it is with separate methods in this class to construct each Effect
		return null;
	}
}
