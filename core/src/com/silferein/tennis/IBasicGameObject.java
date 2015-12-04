package com.silferein.tennis;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public interface IBasicGameObject {
	public Vector2 getCenter();
	public void setCenter(float x, float y);
	
	public void update(float delta);
	public void draw(SpriteBatch batch);
}
