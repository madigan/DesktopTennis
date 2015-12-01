package com.silferein.tennis;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DesktopTennis extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Ball ball;
	
	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		
		batch = new SpriteBatch();
		
		ball = new Ball(camera.viewportWidth / 2, camera.viewportHeight / 2);
	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());
		draw();
	}
	
	private void draw() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		ball.draw(batch);
		batch.end();
	}
	
	private void update(float delta) {
		ball.update(delta);
	}
}
