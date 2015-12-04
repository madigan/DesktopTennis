package com.silferein.tennis;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Paddle implements IBasicGameObject {
	private static final float SPEED = 100f;
	
	private Sprite sprite;
	private IPaddleController controller;
	
	public Paddle(float x, float y, float w, float h, IPaddleController control) {
		sprite = new Sprite(new Texture("paddle.png"));
		sprite.setSize(w, h);
		sprite.setCenter(x,  y);
		sprite.setOriginCenter();
		sprite.rotate(90);
		controller = control;
	}
	public Paddle(float x, float y, float w, float h) {
		this(x, y, w, h, null);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		this.sprite.draw(batch);
	}
	
	@Override
	public void update(float delta) {
		if(controller == null) return;
		
		switch(controller.getDirection()) {
		case UP:
			sprite.translateY(SPEED * delta);
			break;
		case DOWN:
			sprite.translateY(-SPEED * delta);
			break;
		default:
		}
	}
	
	public enum Direction {
		UP,
		DOWN,
		NONE
	}
	
	public void setController(IPaddleController controller) {
		this.controller = controller;
	}

	@Override
	public Vector2 getCenter() {
		return new Vector2(sprite.getX() + sprite.getWidth()/2f, sprite.getY() + sprite.getHeight()/2f);
	}

	@Override
	public void setCenter(float x, float y) {
		sprite.setCenter(x, y);
	}
}
