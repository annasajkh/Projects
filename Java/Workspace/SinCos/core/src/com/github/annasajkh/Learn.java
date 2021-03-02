package com.github.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class Learn extends ApplicationAdapter 
{
	ShapeRenderer shapeRenderer;
	
	int offset = 0;
	
	@Override
	public void create()
	{
		shapeRenderer = new ShapeRenderer();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
	}

	@Override
	public void render()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		shapeRenderer.begin(ShapeType.Filled);
		int count = offset;
		for (int i = 0; i < 1000; i++)
		{
			shapeRenderer.setColor(Color.RED);
			shapeRenderer.circle(i,MathUtils.sinDeg(count) * offset + 200,2);

			shapeRenderer.setColor(Color.BLUE);
			shapeRenderer.circle(i,MathUtils.cosDeg(count) * offset + 200,2);
			
			count++;
			
			if(count > 360)
			{
				count = 0;
			}
		}
		shapeRenderer.end();
		
		offset+=2;
		
		if(offset == 270)
		{
			offset = -270;
		}
		
	}
	
	@Override
	public void dispose() 
	{
		shapeRenderer.dispose();
		
		
	}
}
