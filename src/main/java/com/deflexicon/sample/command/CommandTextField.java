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
	private CommandHistory history;
	
	public CommandTextField(OutputWriter parentComponent)
	{
		super();
		history = new CommandHistory();
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
		System.out.println(ke.getKeyCode());
		if(kc == KeyEvent.VK_ENTER)
		{
			//Enter
			String command = this.getText();
			Command cmd = null;
			parent.writeLine(command,true);
			this.setText("");
			try
			{
				cmd = CommandParser.parseString(command);
				commandReceived(cmd);
			}
			catch(CommandParseException e)
			{
				parent.writeLineError(e.getMessage());
			}
			history.addCommand(command);
		}
		else if (kc == KeyEvent.VK_DOWN)
		{
			//Down
			System.out.println("Down");
			String tmpCmd = history.getNextCommand();
			System.out.println(tmpCmd);
			if(tmpCmd != null)
				this.setText(tmpCmd);
		}
		else if (kc == KeyEvent.VK_UP)
		{
			//Up
			String tmpCmd = history.getPrevCommand();
			System.out.println(tmpCmd);
			if(tmpCmd != null)
				this.setText(tmpCmd);
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
