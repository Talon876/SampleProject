/**
 * 
 */
package com.deflexicon.sample.command;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JTextField;

/**
 * @author Steve Dighans
 *
 */
public class CommandTextField extends JTextField implements KeyListener, CommandListener
{
	private static final long serialVersionUID = -475144318279111232L;

	private OutputWriter parent;
	private ArrayList<CommandListener> listeners;
	
	public CommandTextField(OutputWriter parentComponent)
	{
		super();
		listeners = new ArrayList<CommandListener>();
		parent = parentComponent;
		this.setBackground(Color.BLACK);
		this.setForeground(Color.GREEN);
		this.setCaretColor(Color.GREEN);
		this.addKeyListener(this);
	}
	public CommandTextField(OutputWriter parentComponent, Color background, Color foreground)
	{
		this(parentComponent);
		this.setBackground(background);
		this.setForeground(foreground);
		this.setCaretColor(foreground);
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent ke)
	{
		//TODO: Escape hide window
		int kc = ke.getKeyCode();
		
		if(kc == ke.VK_ENTER)
		{
			//Enter
			String command = this.getText();
			parent.write(command,true);
			this.setText("");
			try
			{
				CommandParser.parseString(command);
			}
			catch(CommandParseException e)
			{
				parent.writeError("Command not found");
			}
		}
		else if (kc == ke.VK_DOWN)
		{
			//Down
		}
		else if (kc == ke.VK_UP)
		{
			//Up
		}
	
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e){}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e){}
	
	/**
	 * Adds the listener from the TextField
	 * @param listener
	 */
	public void addCommandListener(CommandListener listener)
	{
		listeners.add(listener);
	}
	
	/**
	 * Removes the listener from the TextField
	 * @param listener
	 */
	public void removeCommandListener(CommandListener listener)
	{
		listeners.remove(listener);
	}
	
	/**
	 * Sends the command out from the parser to the listeners
	 * @param command The command to send out to the listeners
	 */
	@Override
	public void commandReceived(Command command)
	{
		for(CommandListener listener: listeners)
		{
			listener.commandReceived(command);
		}
	}
}
