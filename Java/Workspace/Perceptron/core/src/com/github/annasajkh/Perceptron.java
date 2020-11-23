package com.github.annasajkh;

public class Perceptron
{

    float[] weights;
    float learningRate;
    float bias = 1;

    enum ActivationFunctions
    {
        STEP,
        SIGNUM
    }

    ActivationFunctions activationFunction;

    public Perceptron(int numberOfInput, float learningRate, ActivationFunctions activationFunction)
    {
        weights = new float[numberOfInput + 1];
        this.activationFunction = activationFunction;
        this.learningRate = learningRate;

        for (int i = 0; i < weights.length; i++)
        {
            weights[i] = (float) (-1 + Math.random() * 2);
        }
    }


    public float guess(float[] inputs)
    {
        float sum = 0;
        for (int i = 0; i < weights.length - 1; i++)
        {
            sum += inputs[i] * weights[i];
        }
        sum += bias * weights[weights.length - 1];

        if (activationFunction == ActivationFunctions.STEP)
        {
            return stepActivationFunction(sum);
        }
        else if (activationFunction == ActivationFunctions.SIGNUM)
        {
            return sigmoidActivationFunction(sum);
        }
        else
        {
            return 0;
        }
    }


    public void train(float[] inputs, float expectedOutput)
    {

        //Tweak weights
        float guess = guess(inputs);
        float error = expectedOutput - guess;

        for (int i = 0; i < weights.length - 1; i++)
        {
            weights[i] += error * inputs[i] * learningRate;
        }
        weights[weights.length - 1] += error * bias * learningRate;
    }


    public float stepActivationFunction(float x)
    {
        if (x > 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public float sigmoidActivationFunction(float x)
    {
        return (float) (1.0 / (1.0 + Math.pow(Math.E, -4.9 * x)));
    }

    public float guessY(float x)
    {
        //        float m = weights[1] / weights[0];
        //        float b = weights[2];
        //        return m * x + b;
        return -(weights[2] / weights[1]) - (weights[0] / weights[1]) * x;
    }

}
