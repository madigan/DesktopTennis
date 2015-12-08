package com.silferein.tennis;

import com.silferein.tennis.Paddle.Direction;

public class AIPaddleController implements IPaddleController {
	private static final float BUFFER = 20.0f;
	
	private IGameObject parent;
	private IGameObject target;
	
	public AIPaddleController(IGameObject target, IGameObject parent) {
		this.target = target;
		this.parent = parent;
	}

	@Override
	public Direction getDirection() {
		if(target.getCenter().y > parent.getCenter().y + BUFFER) {
			return Direction.UP;
		} else if(target.getCenter().y < parent.getCenter().y - BUFFER) {
			return Direction.DOWN;
		} else {
			return Direction.NONE;
		}
	}

}
