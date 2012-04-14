/**
 * 
 */
package com.deflexicon.sample.command;

/**
 * This interface is for the writing functionality of the GUI.
 * It allows the CommandTextFields to know if the parent can write output
 * @author Steve Dighans
 */
public interface OutputWriter
{
	public void write(String text);
	public void write(String text, boolean prepend);
}
