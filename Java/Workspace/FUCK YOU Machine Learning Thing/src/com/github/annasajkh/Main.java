package com.github.annasajkh;

import java.io.IOException;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        NeuralNetwork neuralNetwork = new NeuralNetwork(2, 5, 2, 2);
        neuralNetwork.train(new double[]{1, 0}, new double[]{0, 1});
        neuralNetwork.process(new double[]{1, 0});
    }
}
