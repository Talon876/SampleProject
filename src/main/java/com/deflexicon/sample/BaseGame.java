package com.deflexicon.sample;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.deflexicon.sample.engine.Framework;

public class BaseGame
{
	
	public BaseGame()
	{
		Framework.gameState = Framework.GameState.GAME_CONTENT_LOADING;
		System.out.println("State: " + Framework.gameState.toString());
		Thread threadForInitGame = new Thread()
		{
			@Override
			public void run()
			{
				initialize();
				loadContent();

				Framework.gameState = Framework.GameState.PLAYING;
				System.out.println("State: " + Framework.gameState.toString());
			}
		};
		threadForInitGame.start();
		
	}

	private void initialize()
	{
		System.out.println("game init");
	}

	private void loadContent()
	{
		System.out.println("load content");
	}

	public void restartGame()
	{
		System.out.println("restart game");
	}

	public void updateGame(long gameTime, Point mousePosition)
	{
		checkForInput(mousePosition);
		
		
	}

	private void checkForInput(Point mousePosition)
	{
		if(Framework.keyboardKeyState(KeyEvent.VK_ESCAPE)) //exit if escape is pressed
		{
			System.exit(0);
		}		
	}

	public void draw(Graphics2D g2d, Point mousePosition)
	{
		g2d.setColor(Color.WHITE);
		g2d.drawString("Test", 40, 40);
	}
	
	public void drawGameOver(Graphics2D g2d, Point mousePosition)
	{
		
	}
}