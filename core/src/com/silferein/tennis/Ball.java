package com.silferein.tennis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Ball implements IGameObject {
	private static final float BASE_SPEED = 150f;

	private Sound bounceSfx;
	private Sprite sprite;
	private Vector2 velocity;
	
	public Ball(float x, float y) {
		sprite = new Sprite(new Texture("ball.png"));
		sprite.setCenter(x, y);
		
		bounceSfx = Gdx.audio.newSound(Gdx.files.internal("bounce.wav"));
		
		velocity = new Vector2().setToRandomDirection().scl(BASE_SPEED);
		System.out.println(velocity.angle());
		if(velocity.angle() < 45 || velocity.angle() > 315) {
			velocity.rotate90(1);
		}
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
	
	@Override
	public void update(GameWorld world, float delta) {
		// Move the ball
		sprite.translate(velocity.x * delta, velocity.y * delta);
		
		// Check for paddle collisions
		for(IGameObject other : world.getCollidables()) {
			if(	   other.getPosition().x + other.getSize().x > this.getPosition().x
				&& other.getPosition().x < this.getPosition().x + this.getSize().x) {
				//if(	   other.getPosition().y + other.getSize().y > this.getPosition().y
				//	&& other.getPosition().y < this.getPosition().y) {
					System.out.println("We bounced!");
					System.out.println(this.getPosition().toString());
					System.out.println(this.getSize().toString());
					System.out.println(other.getPosition().toString());
					System.out.println(other.getSize().toString());
					// We've collided, but which way do we bounce?
					if(this.getCenter().x > other.getCenter().x) {
						this.sprite.setX(other.getPosition().x + other.getSize().x);
					} else {
						this.sprite.setX(other.getPosition().x - this.getSize().x);
					}
					this.velocity.x *= -1;
					bounceSfx.play();
				//}
			}
		}

		// Keep the sprite within the game walls
		if(sprite.getY() < 0) {
			sprite.setY(0);
			velocity.y *= -1;
			bounceSfx.play();
		} else if(sprite.getY() + sprite.getHeight() > world.getDimensions().y){
			sprite.setY(world.getDimensions().y - sprite.getHeight());
			velocity.y *= -1;
			bounceSfx.play();
		}

		// Check to see if the ball is out of bounds.
		if(sprite.getX() < -sprite.getWidth()) {
			// TODO: Generate the "out of bounds" event.
		} else if(sprite.getX() > world.getDimensions().x) {
			// TODO: Generate the "out of bounds" event.
		}
	}

	@Override
	public Vector2 getCenter() {
		return new Vector2(sprite.getX() + sprite.getWidth()/2f, sprite.getY() + sprite.getHeight()/2f);
	}

	@Override
	public void setCenter(float x, float y) {
		sprite.setCenter(x, y);
	}

	@Override
	public Vector2 getPosition() {
		return new Vector2(sprite.getX(), sprite.getY());
	}

	@Override
	public Vector2 getSize() {
		return new Vector2(sprite.getWidth(), sprite.getHeight());
	}
}
