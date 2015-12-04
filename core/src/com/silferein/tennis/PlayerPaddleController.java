package com.silferein.tennis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class PlayerPaddleController implements IPaddleController {
	@Override
	public Paddle.Direction getDirection() {
		if(Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)) {
			return Paddle.Direction.UP;
		} else if(Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN)) {
			return Paddle.Direction.DOWN;
		} else {
			return Paddle.Direction.NONE;
		}
	}

}
