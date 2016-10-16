package com.lab.quadratic;

/**
 * Created by saurav_msft on 7/27/2016.
 */
public class Complex
{
    protected double real, imag;

    public Complex(double r, double i)
    {
        real = r;
        imag = i;
    }

    protected String value(double val)
    {
        return (val > 0) ? ("+" + val) : Double.toString(val);
    }
    @Override
    public String toString()
    {
        if(imag == 0)
            return value(real);
        if(real == 0)
            return value(imag) + "i";
        return value(real) + " " + value(imag) + "i";
    }
}
