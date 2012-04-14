package com.deflexicon.sample;

public class App
{
	public App()
	{
		System.out.println("Hello World");
		SDApp sdApp = new SDApp();
		sdApp.doStuff();
	}

	public static void main(String[] args)
	{
		new App();
	}
}
