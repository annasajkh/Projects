package com.github.annasajkh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Particle
{

    Vector2 position;
    Vector2 velocity = new Vector2();
    ParticleClass particleClass;
    float radius = 20;
    float friction = 0.9f;

    public Particle(Vector2 position, ParticleClass particleClass)
    {
        this.position = position;
        this.particleClass = particleClass;
    }


    public void update(Particle otherParticle)
    {
        float distance = getPosition().dst(otherParticle.getPosition());
        Vector2 vectorFromParticleToOtherParticle = otherParticle.getPosition().sub(getPosition());

        if (distance <= particleClass.maxRadius && distance >= particleClass.minRadius)
        {
            velocity.add(new Vector2(vectorFromParticleToOtherParticle.x, vectorFromParticleToOtherParticle.y).nor()
                    .scl(particleClass.attractForce));
            velocity.sub(new Vector2(vectorFromParticleToOtherParticle.x, vectorFromParticleToOtherParticle.y).nor()
                    .scl(particleClass.repulseForce));
        }

        velocity.scl(friction);
        position.add(velocity.scl(Gdx.graphics.getDeltaTime()));
    }


    public void render(ShapeRenderer shapeRenderer)
    {
        shapeRenderer.setColor(particleClass.color);
        shapeRenderer.circle(getPosition().x, getPosition().y, radius);
    }

    public float getX()
    {
        return position.x;
    }

    public float getY()
    {
        return position.y;
    }

    public Vector2 getPosition()
    {
        return new Vector2(position.x, position.y);
    }
}
