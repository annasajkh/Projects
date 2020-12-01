package com.github.annasajkh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeuralNetwork
{
    double[][] network;
    Matrix[] weights;
    Matrix[] biases;
    int inputSize;
    int hiddenLayerSize;
    int layerCount;
    int outputSize;
    double[] expectedOutput;
    double learningRate = 0.01;

    public static double activationFunction(double x)
    {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    public NeuralNetwork(int inputSize, int hiddenLayerSize, int outputSize)
    {
        weights = new Matrix[3];
        biases = new Matrix[3];
        network = new double[][]{new double[inputSize], new double[hiddenLayerSize], new double[outputSize]};
        this.inputSize = inputSize;
        this.hiddenLayerSize = hiddenLayerSize;
        this.outputSize = outputSize;
        this.layerCount = 1;
    }

    public NeuralNetwork(int inputSize, int hiddenLayerSize, int outputSize, int layerCount)
    {
        weights = new Matrix[1 + layerCount];
        biases = new Matrix[1 + layerCount];
        this.inputSize = inputSize;
        this.hiddenLayerSize = hiddenLayerSize;
        this.outputSize = outputSize;
        this.layerCount = layerCount;
        double[] hiddenLayer = new double[hiddenLayerSize];
        network = new double[layerCount + 2][];

        network[0] = new double[inputSize];
        for (int i = 1; i < network.length - 1; i++)
        {
            network[i] = hiddenLayer;
        }
        network[network.length - 1] = new double[outputSize];
    }

    public void preprocess(Matrix weight, Matrix bias, int i, boolean train)
    {
        //a lot of MATRIX MATH
        Matrix beforeLayer = new Matrix(network[i - 1].length, 1);

        for (int j = 0; j < beforeLayer.array.length; j++)
        {
            beforeLayer.array[j][0] = network[i - 1][j];
        }
        Matrix results = Matrix.dot(weight, beforeLayer);
        results.add(bias);
        double[] resultsArray = Matrix.transpose(results).array[0];
        for (int j = 0; j < resultsArray.length; j++)
        {
            resultsArray[j] = activationFunction(resultsArray[j]);
        }
        network[i] = resultsArray;
        if (i == network.length - 1 && train)
        {
            backpropagation(resultsArray);
        }
    }

    public double[] process(double[] input)
    {
        if (weights[weights.length - 1] != null)
        {
            //pass input to input layer
            for (int i = 1; i < input.length; i++)
            {
                network[0][i] = input[i];
            }

            for (int i = 1; i < network.length; i++)
            {
                preprocess(weights[i - 1], biases[i - 1], i, false);
            }
        }
        return network[network.length - 1];
    }

    public Matrix calulateError(Matrix weights, Matrix resultArray)
    {
        System.out.println("w " + weights.toString());
        System.out.println("r " +
                           resultArray)
                                 .toString();

        List<Double> errors = new ArrayList<>();
        System.out.println(Matrix.dot(weights, resultArray)
                                 .toString());
        System.exit(0);
        return weights;
    }

    public void backpropagation(double[] output)
    {
        Matrix errors = new Matrix(expectedOutput);
        errors.sub(new Matrix(output));
        for (int i = weights.length - 1; i >= 0; i--)
        {
            errors = calulateError(weights[i], errors);
        }
    }

    public void train(double[] input, double[] expectedOutput)
    {
        this.expectedOutput = expectedOutput;
        //pass input to input layer
        for (int i = 0; i < input.length; i++)
        {
            network[0][i] = input[i];
        }
        for (int i = 1; i < network.length; i++)
        {
            System.out.println("network = " + Arrays.deepToString(network));
            Matrix weight;
            Matrix bias;
            if (weights[weights.length - 1] == null)
            {
                //generate random weights
                if (i > 1 && i != network.length - 1)
                {
                    weight = new Matrix(hiddenLayerSize, hiddenLayerSize);
                }
                else
                {
                    if (i == network.length - 1)
                    {
                        weight = new Matrix(outputSize, hiddenLayerSize);
                    }
                    else
                    {
                        weight = new Matrix(hiddenLayerSize, inputSize);
                    }
                }
                weight.randomize();
                weights[i - 1] = weight;

                //generate random biases
                if (i > 1 && i != network.length - 1)
                {
                    bias = new Matrix(hiddenLayerSize, 1);
                }
                else
                {
                    if (i == network.length - 1)
                    {
                        bias = new Matrix(outputSize, 1);
                    }
                    else
                    {
                        bias = new Matrix(inputSize, 1);
                    }
                }
                bias.randomize();
                biases[i - 1] = bias;
            }
            else
            {
                weight = weights[i - 1];
                bias = biases[i - 1];
            }
            preprocess(weight, bias, i, true);
        }


    }

}
