package com.silferein.tennis;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public interface IGameObject {
	public Vector2 getCenter();
	public void setCenter(float x, float y);
	public Vector2 getPosition();
	public Vector2 getSize();
	
	public void update(GameWorld world, float delta);
	public void draw(SpriteBatch batch);
}
