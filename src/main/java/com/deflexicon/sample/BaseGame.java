package com.deflexicon.sample;

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
	private EffectManager effectManager;
	private CommandGUI cmdGui = CommandGUI.getInstance();
	
	private int xOffset = 4;
	private int yOffset = 14;
	public BaseGame()
	{
		Framework.gameState = Framework.GameState.GAME_CONTENT_LOADING;

		initialize();
		loadContent();

		Framework.gameState = Framework.GameState.PLAYING;
		
	}

	private void initialize()
	{
		effectManager = new EffectManager();
		cmdGui.addCommandListener(effectManager);
		
		effectManager.addEffect(new CircleMeshEffect(50));
	}

	private void loadContent()
	{
	}

	public void restartGame()
	{
	}

	public void updateGame(long gameTime, Point mousePosition)
	{
		effectManager.update(mousePosition);
	}

	public void draw(Graphics2D g2d, Point mousePosition)
	{
		g2d.setColor(Color.WHITE);
		g2d.drawString("Press 'h' to toggle the command window.", xOffset, yOffset);
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