/**
 * 
 */
package com.deflexicon.sample.command;

import java.util.ArrayList;

/**
 * @author Steve Dighans
 *
 */
public class CommandHistory
{
	//TODO: Recode with Stack or something
	ArrayList<String> history;
	int currentItem = 0;
	int maxHistory = 20;
	public CommandHistory()
	{
		history = new ArrayList<String>();
		setMaxHistory(20);
	}
	
	public CommandHistory(int maxH)
	{
		this();
		setMaxHistory(maxH);
	}
	
	public void setMaxHistory(int i)
	{
		maxHistory = i;
	}

	public int getMaxHistory()
	{
		return maxHistory;
	}
	
	public void addCommand(String command)
	{
		if(history.size() > getMaxHistory())
			history.remove(history.size()-1);
		history.add(0, command);
		currentItem = 0;
		
		System.out.println(history.toString()+ " " + currentItem);
	}
	
	public String getPrevCommand()
	{
		System.out.println(history.toString() + " " + currentItem);
		if(currentItem == history.size() - 1)
			return history.get(currentItem);
		else if(currentItem == 0)
		{
			currentItem++;
			return history.get(0);
		}
		else if(currentItem + 1 <= history.size() - 1)
		{
			String tmp = history.get(currentItem);
			System.out.println(tmp);
			currentItem++;
			return tmp;
		}
		else
			return null;
	}
	
	public String getNextCommand()
	{
		System.out.println(history.toString()+ " " + currentItem);
		if(currentItem == 0)
			return "";
		else if(currentItem - 1 >= 0)
		{
			String tmp = history.get(currentItem - 1);
			System.out.println(tmp);
			currentItem--;
			return tmp;
		}
		else
			return null;
	}
}
