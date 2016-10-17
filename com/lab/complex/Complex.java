package com.lab.complex;

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
        if (imag == 0)
            return value(real);
        if (real == 0)
            return value(imag) + "i";
        return value(real) + " " + value(imag) + "i";
    }

    Complex add(Complex b) { return new Complex(real + b.real, imag + b.imag); }

    Complex subtract(Complex b) { return new Complex(real - b.real, imag - b.imag); }

    Complex multiply(Complex b)
    {
        return new Complex(
                real * b.real - imag * b.imag,
                real * b.imag + imag * b.real
        );
    }

    Complex divide(Complex b)
    {
        double den = b.real * b.real + b.imag * b.imag;
        Complex c = this.multiply(new Complex(b.real, -b.imag));
        c.real /= den;
        c.imag /= den;
        return c;
    }

    //Static Overloaded Methods
    public static Complex add(Complex a, Complex b) { return a.add(b); }

    public static Complex subtract(Complex a, Complex b) { return a.subtract(b); }

    public static Complex multiply(Complex a, Complex b) { return a.multiply(b); }

    public static Complex divide(Complex a, Complex b) { return a.divide(b); }
}
