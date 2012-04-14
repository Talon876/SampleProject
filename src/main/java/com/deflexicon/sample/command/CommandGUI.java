package com.deflexicon.sample.command;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Uses a lazy initialized Singleton of CommandGUI to issue command events to
 * all listeners Takes in commands through a TextField.
 */
public class CommandGUI extends JFrame implements CommandListener, OutputWriter
{

	private static final long serialVersionUID = 207386308260902684L;
	private static CommandGUI _instance = null;

	private JTextArea output;

	private CommandTextField input;

	private ArrayList<CommandListener> listeners;
	
	public static synchronized CommandGUI getInstance()
	{
		if (_instance == null)
		{
			_instance = new CommandGUI();
		}
		return _instance;
	}

	private CommandGUI()
	{
		listeners = new ArrayList<CommandListener>();
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setPreferredSize(new Dimension(640, 320));
		this.setLocation(0, 0);
		this.setTitle("Command Line");

		initGui();
		this.pack();
		this.write("This is the command line\nType 'help' for a list of commands");
		input.requestFocusInWindow();
		
	}

	private void initGui()
	{
		output = new JTextArea("");
		output.setEditable(false);
		output.setBackground(Color.BLACK);
		output.setForeground(Color.GREEN);

		JScrollPane scrollOutput = new JScrollPane(output);

		input = new CommandTextField(this);
			input.addCommandListener(this);
			
		this.setLayout(new BorderLayout());

		this.add(scrollOutput, BorderLayout.CENTER);
		this.add(input, BorderLayout.SOUTH);
	}

	/**
	 * Toggles the CommandGUI visibility
	 * 
	 * @author Steve Dighans
	 * 
	 */
	public void toggleVisibility()
	{
		if (this.isVisible())
			this.setVisible(false);
		else
			this.setVisible(true);
	}

	/**
	 * Adds a line to the output pane of the CommandGUI
	 * 
	 * @author Talon Daniels
	 * @param text
	 *            The text to output to the screen
	 */
	public void write(String text)
	{
		if (!output.getText().equals(""))
			output.setText(output.getText() + "\n" + text);
		else
			output.setText(text);

	}

	/**
	 * Adds a line to the output pane that has a \n> prepended
	 * 
	 * @author Steve Dighans
	 * @param text
	 *            The text to output to the screen
	 * @param prepend
	 *            Whether or not to prepend \n> onto the text given
	 */
	public void write(String text, boolean prepend)
	{
		if (prepend)
			text = "\n> " + text;
		if (!output.getText().equals(""))
			output.setText(output.getText() + "\n" + text);
		else
			output.setText(text);

	}
	
	/**
	 * Adds the listener from the GUI
	 * @param listener
	 */
	public void addCommandListener(CommandListener listener)
	{
		listeners.add(listener);
	}
	
	/**
	 * Removes the listener from the GUI
	 * @param listener
	 */
	public void removeCommandListener(CommandListener listener)
	{
		listeners.remove(listener);
	}

	/**
	 * Updates the registered CommandListeners when a new event is fired
	 * @param command The command sent out to the CommandListeners
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
