/**
 * 
 */
package com.deflexicon.sample.command;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * @author Steve Dighans
 *
 */
public class CommandTextField extends JTextField implements KeyListener
{
	public CommandTextField()
	{
		super();
		this.setBackground(Color.BLACK);
		this.setForeground(Color.GREEN);
	}
	public CommandTextField(Color background, Color foreground)
	{
		this();
		this.setBackground(background);
		this.setForeground(foreground);
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent ke)
	{
		int kc = ke.getKeyCode();
		JTextField field;
		
		if(kc == ke.VK_ENTER)
		{
			//Enter
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
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}
}
