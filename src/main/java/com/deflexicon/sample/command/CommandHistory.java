/**
 * 
 */
package com.deflexicon.sample.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steve Dighans
 *
 */
public class CommandHistory
{
	private static final int DEFAULTMAXHISTORY = 20;
	//TODO: Recode with Stack or something
	private List<String> history;
	private int currentItem = 0;
	private int maxHistory = 0;
	public CommandHistory()
	{
		history = new ArrayList<String>();
		setMaxHistory(DEFAULTMAXHISTORY);
	}
	
	public CommandHistory(int maxH)
	{
		this();
		setMaxHistory(maxH);
	}
	
	public final void setMaxHistory(int i)
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
		{
			history.remove(history.size()-1);
		}
		history.add(0, command);
		currentItem = 0;
		
	}
	
	public String getPrevCommand()
	{
		if(currentItem == history.size() - 1)
		{
			return history.get(currentItem);
		}
		else if(currentItem == 0)
		{
			currentItem++;
			return history.get(0);
		}
		else if(currentItem + 1 <= history.size() - 1)
		{
			String tmp = history.get(currentItem);
			currentItem++;
			return tmp;
		}
		else
		{
			return null;
		}
	}
	
	public String getNextCommand()
	{
		if(currentItem == 0)
		{
			return "";
		}
		else if(currentItem - 1 >= 0)
		{
			String tmp = history.get(currentItem - 1);
			currentItem--;
			return tmp;
		}
		else
		{
			return null;
		}
	}
}
