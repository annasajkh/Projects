package com.github.annasajkh;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class CreateBody
{
	
	public static Body createRect(Vector2 position,Vector2 size,float angle,BodyType bodyType,boolean lockRotation,World world)
	{
		Body pBody;
		BodyDef bodyDef = new BodyDef();
		FixtureDef fixtureDef = new FixtureDef();
		bodyDef.type = bodyType;
		bodyDef.position.set(position);
		bodyDef.angle = angle;
		bodyDef.fixedRotation = lockRotation;
		fixtureDef.density = 1f;
		fixtureDef.friction = 1f;
		pBody = world.createBody(bodyDef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(size.x * 0.5f,size.y * 0.5f);
		fixtureDef.shape = shape;
		pBody.createFixture(fixtureDef);
		shape.dispose();
		return pBody;
	}

}
