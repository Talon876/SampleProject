/**
 * 
 */
package com.deflexicon.sample.command.commands;

import com.deflexicon.sample.command.Command;

/**
 * @author Steve
 *
 */
public class EchoCommand extends Command implements DataCommand
{
	public EchoCommand()
	{
		super("Echo is ON");
	}
	/**
	 * Creates a Command object
	 * @param arg An optional single string argument
	 */
	public EchoCommand(String arg)
	{
		super(arg);
	}
	/* (non-Javadoc)
	 * @see com.deflexicon.sample.command.commands.DataCommand#getResults()
	 */
	@Override
	public String getResults()
	{
		// TODO Auto-generated method stub
		return stringArg;
	}

	/* (non-Javadoc)
	 * @see com.deflexicon.sample.command.Command#getHelpText()
	 */
	@Override
	public String getHelpText()
	{
		// TODO Auto-generated method stub
		return "Echos the arguments you provide";
	}

	/* (non-Javadoc)
	 * @see com.deflexicon.sample.command.Command#doCommand()
	 */
	@Override
	public String doCommand()
	{
		return getResults();
	}

}
