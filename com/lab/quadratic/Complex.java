package com.lab.quadratic;

/**
 * Created by saurav_msft on 7/27/2016.
 */
public class Complex
{
    private double real, imag;

    public Complex(double r, double i)
    {
        real = r;
        imag = i;
    }

    private String Value(double val)
    {
        return (val > 0) ? ("+" + val) : Double.toString(val);
    }

    public String toString()
    {
        if(imag == 0)
            return Value(real);
        if(real == 0)
            return Value(imag) + "i";
        return Value(real) + " " + Value(imag) + "i";
    }
}
