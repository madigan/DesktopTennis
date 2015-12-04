package com.silferein.tennis;

public interface IPaddleController {
	/**
	 * This method asks the controller for which direction the paddle should 
	 * move.
	 * 
	 * @return The direction to move.
	 */
	public Paddle.Direction getDirection();
}
