package com.github.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Game extends ApplicationAdapter
{
    static ShapeRenderer shapeRenderer;
    static Particle[] particles;
    static ParticleClass[] particleClasses;

    @Override
    public void create()
    {
        shapeRenderer = new ShapeRenderer();
        particles = new Particle[100];
        particleClasses = new ParticleClass[5];
        for (int i = 0; i < particleClasses.length; i++)
        {
            particleClasses[i] = new ParticleClass();
        }


        for (int i = 0; i < particles.length; i++)
        {
            particles[i] = new Particle(
                    new Vector2(MathUtils.random(Gdx.graphics.getWidth()), MathUtils.random(Gdx.graphics.getHeight())),
                    particleClasses[MathUtils.random(particleClasses.length - 1)]);
        }

    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        for (Particle particle : particles)
        {
            for (Particle otherParticle : particles)
            {
                if (!particle.equals(otherParticle))
                {

                    particle.update(otherParticle);

                }
            }
        }

        for (Particle particle : particles)
        {
            for (Particle otherParticle : particles)
            {
                if (!particle.equals(otherParticle))
                {
                    float distance = particle.getPosition().dst(otherParticle.getPosition());
                    if (distance - particle.radius - otherParticle.radius < 0)
                    {
                        float fOverlap = (distance - particle.radius - otherParticle.radius) * 0.5f;

                        Vector2 vectorFromParticleToOtherParticleNormal =
                                otherParticle.getPosition().sub(particle.getPosition()).nor();

                        particle.position.sub(vectorFromParticleToOtherParticleNormal.scl(fOverlap));
                        otherParticle.position.add(vectorFromParticleToOtherParticleNormal.scl(fOverlap));
                    }
                }
            }
            particle.position.x =
                    MathUtils.clamp(particle.getX(), particle.radius, Gdx.graphics.getWidth() - particle.radius);
            particle.position.y =
                    MathUtils.clamp(particle.getY(), particle.radius, Gdx.graphics.getHeight() - particle.radius);
        }

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Particle particle : particles)
        {
            particle.render(shapeRenderer);
        }
        shapeRenderer.end();
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            create();
        }
    }

    @Override
    public void dispose()
    {
        shapeRenderer.dispose();
    }
}
