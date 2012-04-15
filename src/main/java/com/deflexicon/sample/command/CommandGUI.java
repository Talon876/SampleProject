package com.deflexicon.sample.command;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.*;

/**
 * Uses a lazy initialized Singleton of CommandGUI to issue command events to
 * all listeners Takes in commands through a TextField.
 */
public class CommandGUI extends JFrame implements CommandListener, OutputWriter
{

	private static final long serialVersionUID = 207386308260902684L;
	private static CommandGUI _instance = null;

	private JTextPane output;

	private CommandTextField input;

	private ArrayList<CommandListener> listeners;
	
	private Color errorColor;
	
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
		errorColor = Color.RED;
		listeners = new ArrayList<CommandListener>();
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setPreferredSize(new Dimension(640, 320));
		this.setLocation(0, 0);
		this.setTitle("Command Line");

		initGui();
		this.pack();
		this.write("This is the command line\nType 'help' for a list of commands");
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
		StyleContext sc = StyleContext.getDefaultStyleContext();
	    AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
	    StyleConstants.Foreground, output.getForeground());

	    int len = output.getDocument().getLength();
	    try {
			output.getDocument().insertString(len, text + "\n", aset);
		} catch (BadLocationException e) {
			e.printStackTrace();
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
	    if (prepend)
			text = "\n> " + text;
	    this.write(text);
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
		
	}
}
