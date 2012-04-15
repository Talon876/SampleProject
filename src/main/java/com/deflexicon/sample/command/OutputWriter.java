/**
 * 
 */
package com.deflexicon.sample.command;

import java.awt.Color;

/**
 * This interface is for the writing functionality of the GUI.
 * It allows the CommandTextFields to know if the parent can write output
 * @author Steve Dighans
 */
public interface OutputWriter
{
	public void write(String text);
	public void write(String text, boolean prepend);
	public void writeError(String error);
	public void write(String text, Color clr);
	
	public void writeLine(String text);
	public void writeLine(String text, boolean prepend);
	public void writeLineError(String error);
	public void writeLine(String text, Color clr);
}
