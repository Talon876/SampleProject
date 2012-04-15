package com.deflexicon.sample.command.commands;

import com.deflexicon.sample.visual.effects.Effect;

/**
 * Any command which will represent an Effect should implement this interface. This allows the CommandToEffect class to properly check if the command is an effect.
 * @author Talon
 *
 */
public interface EffectCommand
{
	public Effect getEffect();
}
