package com.deflexicon.sample.command;

import java.awt.*;

import javax.swing.*;

public class CommandGUI extends JFrame
{
	/**
	 * Uses a lazy initialized Singleton of CommandGUI to issue command events
	 * to all listeners Takes in commands through a TextField.
	 */
	private static final long serialVersionUID = 207386308260902684L;
	private static CommandGUI _instance = null;

	private JTextArea output;

	private JTextField input;
	private JPanel inputPanel;

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
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(640, 320));
		this.setLocation(0, 0);
		this.setTitle("Command Line");

		initGui();
		this.pack();
		this.write("This is the command line\nType help for a list of commands");
	}

	private void initGui()
	{
		output = new JTextArea("");
			output.setEditable(false);
			output.setBackground(Color.BLACK);
			output.setForeground(Color.GREEN);
			
		JScrollPane scrollOutput = new JScrollPane(output);
		
		input = new JTextField("");
			input.setBackground(Color.BLACK);
			input.setForeground(Color.GREEN);
		inputPanel = new JPanel(new GridLayout(1, 2));

		this.setLayout(new BorderLayout());

		inputPanel.add(input);
		this.add(scrollOutput, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
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
	 * @author Talon Daniels
	 * @param text The text to output to the screen
	 */
	private void write(String text)
	{
		if(!output.getText().equals(""))
			output.setText(output.getText() + "\n" + text);
		else
			output.setText(text);
			
	}
	//TODO: Add Echo of command with input
}
