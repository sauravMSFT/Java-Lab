package com.lab.complex;

import java.io.*;

import static java.lang.Double.parseDouble;

/**
 * Created by saurav on 17/10/16.
 */
public class Solution
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter pw = new PrintWriter(System.out, true);

    private static Complex fromInput(String real, String imag)
            throws Exception
    {
        double r, i;
        pw.printf("Enter (%s, %s) in %s + i%s\n%s = ", real, imag, real, imag, real);
        r = parseDouble(br.readLine());
        pw.printf("%s = ", imag);
        i = parseDouble(br.readLine());
        return new Complex(r, i);
    }

    private static void op(String operation, char operator, Complex a, Complex b, Complex res)
    {
        pw.printf("%s\n(%s) %c (%s) = %s\n",
                  operation,
                  a,
                  operator,
                  b,
                  res);
    }
    public static void main(String[] args) throws Exception
    {
        Complex a = fromInput("a", "b"), b = fromInput("c", "d");

        int x = 1;
        op(x++ + ". Addition", '+', a, b, a.add(b));
        op(x++ + ". Subtraction", '-', a, b, a.subtract(b));
        op(x++ + ". Multiplication", '*', a, b, a.multiply(b));
        op(x++ + ". Division", '/', a, b, a.divide(b));
    }
}
