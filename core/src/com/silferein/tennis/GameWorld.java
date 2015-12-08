package com.silferein.tennis;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class GameWorld {
	private List<IGameObject> collidables = new ArrayList<IGameObject>();
	private Vector2 dimensions = new Vector2();
	
	public List<IGameObject> getCollidables() {
		return collidables;
	}
	
	public void addCollidable(IGameObject obj) {
		collidables.add(obj);
	}
	
	public void removeCollidable(IGameObject obj) {
		collidables.remove(obj);
	}
	
	public Vector2 getDimensions() {
		return dimensions.cpy();
	}
	
	public void setWorldDimensions(float width, float height) {
		dimensions = new Vector2(width, height);
	}
}
