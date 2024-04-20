package com.entity;

import com.app.GamePanel;
import com.app.KeyListen;

import java.awt.Graphics2D;
import java.awt.Color;

public class Player extends Entity {

	final GamePanel gamePanel;
	final KeyListen keyListen;
	final int leftBorder = 0;

	public Player(GamePanel gamePanel, KeyListen keyListen) {

		this.gamePanel = gamePanel;
		this.keyListen = keyListen;

		this.setDefaultValues();
	}

	public void setDefaultValues() {

		x = gamePanel.screenWidth / 2 - gamePanel.tileSize / 2; // Center screen
		y = (int) (gamePanel.screenHeight * 0.8);
		velocity = 4;
	}

	public void update() {

		if (keyListen.leftPressed) {
			x -= velocity;
			if (x < leftBorder) {
				x = leftBorder;
			}
		}

		if (keyListen.rightPressed) {
			x += velocity;
			if (x > gamePanel.screenWidth - gamePanel.tileSize) {
				x = gamePanel.screenWidth - gamePanel.tileSize;
			}
		}

		gamePanel.enemy.intersect = false;
		gamePanel.collisionDetection.checkTile();
	}

	public void draw(Graphics2D g2D) {

		g2D.setColor(Color.white);
		g2D.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
	}
}
