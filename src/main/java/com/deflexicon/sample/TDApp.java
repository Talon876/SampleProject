package com.deflexicon.sample;

import javax.swing.SwingUtilities;

import com.deflexicon.sample.engine.Window;

public class TDApp
{
	public TDApp()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new Window();
			}
		});
	}
}
