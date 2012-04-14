package com.deflexicon.sample.visual;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.deflexicon.sample.command.CommandGUI;
import com.deflexicon.sample.engine.Framework;
import com.deflexicon.sample.visual.effects.CircleMeshEffect;
import com.deflexicon.sample.visual.effects.EffectManager;

public class BaseGame
{
	EffectManager effectManager;
	CommandGUI cmdGui = CommandGUI.getInstance();

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
		effectManager = new EffectManager();
		effectManager.addEffect(new CircleMeshEffect(50));
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
		effectManager.update(mousePosition);
	}

	public void draw(Graphics2D g2d, Point mousePosition)
	{
		g2d.setColor(Color.WHITE);
		g2d.drawString("Press 'h' to toggle the command window.", 4, 14);
		effectManager.draw(g2d, mousePosition);
	}

	public void drawGameOver(Graphics2D g2d, Point mousePosition)
	{

	}

	public void keyReleased(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_H:
			toggleCommandGui();
			break;
		}
	}

	private void toggleCommandGui()
	{
		cmdGui.toggleVisibility();
	}
}