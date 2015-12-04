package com.silferein.tennis;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Ball implements IBasicGameObject {
	private static final float BASE_SPEED = 150f;

	private Sprite sprite;
	private Vector2 velocity;
	
	public Ball(float x, float y) {
		sprite = new Sprite(new Texture("ball.png"));
		sprite.setScale(0.5f);
		sprite.setCenter(x, y);
		
		velocity = new Vector2(
				MathUtils.random(-BASE_SPEED, BASE_SPEED), 
				MathUtils.random(-BASE_SPEED, BASE_SPEED));
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
	
	@Override
	public void update(float delta) {
		sprite.translate(velocity.x * delta, velocity.y * delta);
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
