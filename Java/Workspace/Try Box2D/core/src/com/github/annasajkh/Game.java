package com.github.annasajkh;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class Game extends ApplicationAdapter 
{
	
	private OrthographicCamera camera;
	public static World world;
	private Body floor;
	private List<Body> boxes;
	private float boxSpawnTimer = 0;
	private Box2DDebugRenderer b2dRenderer;
	private float rotation;
	
	@Override
	public void create() 
	{
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.position.x = Gdx.graphics.getWidth() * 0.5f;
		camera.position.y = Gdx.graphics.getHeight() * 0.5f;
		camera.update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		world = new World(new Vector2(0,-9.8f),false);
		b2dRenderer = new Box2DDebugRenderer();
		floor = CreateBody.createRect(	new Vector2(Gdx.graphics.getWidth() * 0.5f,200),
										new Vector2(Gdx.graphics.getWidth() * 0.25f,50),
										0,
										BodyType.StaticBody,
										true,
										world);
		boxes = new ArrayList<>();
	}
	
	public void update(float delta)
	{
		boxSpawnTimer += Gdx.graphics.getRawDeltaTime();
		for(int i = 0 ; i < 10; i++)
		{
			world.step(delta,8, 3);
			if(boxSpawnTimer >= 0.5f)
			{
				boxSpawnTimer = 0;
				boxes.add(CreateBody.createRect(new Vector2(Gdx.graphics.getWidth() * 0.5f,Gdx.graphics.getHeight()),
												new Vector2(50,50),
												MathUtils.random(360),
												BodyType.DynamicBody,
												false,
												world));
			}
			for(int j = boxes.size() - 1; j >= 0; j--)
			{
				Body box = boxes.get(j);
				if(box.getPosition().y < 0)
				{
					world.destroyBody(box);
					boxes.remove(box);
				}
			}
			floor.setTransform(floor.getPosition().x,floor.getPosition().y,rotation);
			
		}
		rotation+=0.05f;
	}

	@Override
	public void render() 
	{
		update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		b2dRenderer.render(world,camera.combined);
				
	}
	
	@Override
	public void dispose()
	{
		world.dispose();
		b2dRenderer.dispose();
	}
}
