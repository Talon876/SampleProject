package com.deflexicon.sample;

public class App
{
	public App()
	{
		SDApp sdApp = new SDApp();
		sdApp.doStuff();
		new TDApp();
	}

	public static void main(String[] args)
	{
		new App();
	}
}
