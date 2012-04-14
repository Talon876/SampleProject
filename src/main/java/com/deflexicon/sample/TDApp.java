package com.deflexicon.sample;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TDApp extends JFrame implements ActionListener
{
	JTextArea output;
	JButton begin;
	JTextField input;
	JPanel inputPanel;

	public TDApp()
	{
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setTitle("Main");

		initGui();
	}

	private void initGui()
	{
		output = new JTextArea("");
		JScrollPane scrollOutput = new JScrollPane(output);
		begin = new JButton("Begin");
		input = new JTextField("");
		inputPanel = new JPanel(new GridLayout(1, 2));

		this.setLayout(new BorderLayout());

		begin.addActionListener(this);
		
		inputPanel.add(input);
		inputPanel.add(begin);
		this.add(scrollOutput, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(begin))
		{
			populate();
		}
	}

	private void populate()
	{
		for (int i = 0; i < 100; i++)
		{
			write("This is line " + i);
		}
	}

	private void write(String text)
	{
		output.setText(output.getText() + "\n" + text);
		
	}
}
