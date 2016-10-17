package com.lab;

import static java.lang.Math.pow;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by saurav on 17/10/16.
 */
public class Polynomial
{
    protected double[] coeff, diff;
    protected int degree;
    protected double assumedRoot;

    public Polynomial(double[] coefficients, double ar) throws Exception
    {
        coeff = coefficients;
        diff = differentiate(coeff);

        if (calculate(diff, ar) == 0)
            throw new Exception("Assumed root's derivative is 0. Choose a different root.");
        assumedRoot = ar;
    }

    protected double calculate(double[] coeff, double x)
    {
        double val = 0;
        for (int i = coeff.length - 1, j = 0; i >= 0; --i, ++j)
            val += (pow(x, j) * coeff[i]);
        return val;
    }

    protected double[] differentiate(double[] coefficient)
    {
        int len = coefficient.length;
        double[] diff = new double[len];
        diff[0] = 0;
        for (int i = len - 2, j = 1; i >= 0; --i, ++j)
            diff[i + 1] = coefficient[i] * j;
        return diff;
    }

    public static void main(String[] args) throws Exception
    {
        new Polynomial(new double[]{2, 4, 1}, 0);
    }
}
