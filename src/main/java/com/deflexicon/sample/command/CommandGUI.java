package com.deflexicon.sample.command;

import javax.swing.JFrame;

public class CommandGUI extends JFrame
{
	/**
	 * Uses a lazy initialized Singleton of CommandGUI to issue command events to all listeners
	 * Takes in commands through a TextField.
	 */
	private static final long serialVersionUID = 207386308260902684L;
	private static CommandGUI _instance = null;
	 
    private CommandGUI() 
    {   
    	
    }

    public static synchronized CommandGUI getInstance() {
            if (_instance == null) {
                    _instance = new CommandGUI();
            }
            return _instance;
    }
    /**
     * @author Steve Dighans
     * Calls the frame's set visable when it is ready to be show.
     */
	public void open()
	{
		this.setVisible(true);
	}
	
}
