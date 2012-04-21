package com.deflexicon.sample.command;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.text.*;

/**
 * Uses a lazy initialized Singleton of CommandGUI to issue command events to
 * all listeners Takes in commands through a TextField.
 */
public class CommandGUI extends JFrame implements CommandListener, OutputWriter
{

	private static final long serialVersionUID = 207386308260902684L;
	private static final Dimension DEFAULTSIZE = new Dimension(640,320);
	private static CommandGUI instance = null;

	private JTextPane output;

	private CommandTextField input;

	private List<CommandListener> listeners;
	
	private Color errorColor;
	
	public static synchronized CommandGUI getInstance()
	{
		if (instance == null)
		{
			instance = new CommandGUI();
		}
		return instance;
	}

	private CommandGUI()
	{
		errorColor = Color.RED;
		listeners = new ArrayList<CommandListener>();
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setPreferredSize(DEFAULTSIZE);
		this.setLocation(0, 0);
		this.setTitle("Command Line");

		initGui();
		this.pack();
		this.writeLine("This is the command line\nType 'help' for a list of commands");
		input.requestFocusInWindow();
		
		//Transfers focus to the input text field when the window gains focus
		this.addWindowListener(new WindowAdapter(){public void windowGainedFocus(WindowEvent e){input.requestFocusInWindow();}} );
		
		//Hides the window when escape is pressed
		/*KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.SHIFT_DOWN_MASK, false);
		Action escapeAction = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
				toggleVisibility();
			}
		};

		this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "HIDE");
		this.getRootPane().getActionMap().put("HIDE", escapeAction);
		
		//TODO: Find out why the main application window is responding to the ESCAPE from this window
		*/
	}

	private void initGui()
	{
		output = new JTextPane();
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
		{
			this.setVisible(false);
		}
		else
		{
			this.setVisible(true);
		}
	}

	/**
	 * Adds a line to the output pane of the CommandGUI
	 * 
	 * @author Talon Daniels
	 * @param text
	 *            The text to output to the screen
	 */
	public void writeLine(String text)
	{
		if(text == null)
		{
			return;
		}
		StyleContext sc = StyleContext.getDefaultStyleContext();
	    AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
	    StyleConstants.Foreground, output.getForeground());

	    int len = output.getDocument().getLength();
	    try {
			output.getDocument().insertString(len, text + "\n", aset);
		} catch (BadLocationException e) {
			
		}

	}
	
	/**
	 * Adds a line to the output pane of the CommandGUI with a specific Color
	 * 
	 * @author Steve Dighans
	 * @param text
	 *            The text to output to the screen
	 * @param clr
	 * 				Color of the text.
	 */
	public void writeLine(String text, Color clr)
	{
		if(text == null)
		{
			return;
		}
		Color curForeground = output.getForeground();
		output.setForeground(clr);
		this.writeLine(text);
		output.setForeground(curForeground);
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
	public void writeLine(String text, boolean prepend)
	{
		String appendText = text;
		if(appendText == null)
		{
			return;
		}
	    if (prepend)
	    {
			appendText = "\n> " + appendText;
	    }
	    this.writeLine(appendText);
	}
	
	/**
	 * Adds the error line to the output pane
	 * 
	 * @author Steve Dighans
	 * @param text
	 *            The error to output to the screen
	 */
	public void writeLineError(String error)
	{
		if(error == null)
		{
			return;
		}
		this.writeLine(error, errorColor);
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
		if(text == null)
		{
			return;
		}
		StyleContext sc = StyleContext.getDefaultStyleContext();
	    AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
	    StyleConstants.Foreground, output.getForeground());

	    int len = output.getDocument().getLength();
	    try {
			output.getDocument().insertString(len, text, aset);
		} catch (BadLocationException e) {
			
		}

	}
	
	/**
	 * Adds a line to the output pane of the CommandGUI with a specific Color
	 * 
	 * @author Steve Dighans
	 * @param text
	 *            The text to output to the screen
	 * @param clr
	 * 				Color of the text.
	 */
	public void write(String text, Color clr)
	{
		if(text == null)
		{
			return;
		}
		Color curForeground = output.getForeground();
		output.setForeground(clr);
		this.write(text);
		output.setForeground(curForeground);
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
		String appendText = text;
		if(appendText == null)
		{
			return;
		}
	    if (prepend)
	    {
			appendText = "\n> " + appendText;
	    }
	    this.write(appendText);
	}
	
	/**
	 * Adds the error line to the output pane
	 * 
	 * @author Steve Dighans
	 * @param text
	 *            The error to output to the screen
	 */
	public void writeError(String error)
	{
		if(error == null)
		{
			return;
		}
		this.write(error, errorColor);
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
		String results = command.doCommand();
		if(results != null && results.length() == 0)//If it comes back with a null string do not append new line
		{
			write(results);
		}
		else
		{
			writeLine(results);
		}
	}
}
