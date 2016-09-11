package com.lab.quadratic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by saurav_msft on 7/27/2016.
 */
public class Equation {
    private double a, b, c;
    private double det;

    public Equation(double a, double b, double c) throws Exception {
        //ALT CODE for 2 SUP is 253
        if (a == 0.0) throw new Exception("coefficient of x² cannot be zero...");

        this.a = a;
        this.b = b;
        this.c = c;
        det = b * b - 4 * a * c;
    }

    public double Discriminant() {
        return det;
    }

    public Complex[] Solution() {
        double s1, s2, det1;

        if (det >= 0) {
            det1 = Math.sqrt(det);
            s1 = (-b + det1) / (2 * a);
            s2 = (-b - det1) / (2 * a);

            return new Complex[]{new Complex(s1, 0), new Complex(s2, 0)};
        } else {
            det1 = Math.sqrt(-det);
            s1 = -b / (2 * a);
            s2 = Math.sqrt(-det) / (2 * a);

            return new Complex[]{new Complex(s1, s2), new Complex(s1, -s2)};
        }
    }

    private String Value(double val) {
        return (val >= 0) ? ("+ " + val) : ("- " + Double.toString(Math.abs(val)));
    }

    public String toString() {
        return Value(a) + "x² " + Value(b) + "x " + Value(c) + " = 0";
    }

    private static void demo() {
        PrintWriter p = new PrintWriter(System.out, true);
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        Equation eq = null;
        do {
            p.println("Enter the coefficients (a, b, c) in ax² + bx + c = 0");
            try {
                double a, b, c;
                p.print("a = ");
                p.flush();
                a = Double.parseDouble(s.readLine());

                p.print("b = ");
                p.flush();
                b = Double.parseDouble(s.readLine());

                p.print("c = ");
                p.flush();
                c = Double.parseDouble(s.readLine());

                eq = new Equation(a, b, c);
            } catch (Exception e) {
                p.println(e.getMessage());
                p.println("Try again.");
            }
        } while (eq == null);

        p.println("The given equation: " + eq);
        String str;
        Complex[] solutions = eq.Solution();

        if (eq.Discriminant() > 0)
            str = "two real and distinct roots.";
        else if (eq.Discriminant() == 0)
            str = "real but equal roots";
        else
            str = "complex roots";

        p.println("The above equation has " + str);

        p.println("The roots are");
        p.println("x = " + solutions[0]);
        p.println("x = " + solutions[1]);
    }

    public static void main(String[] args) {
        demo();
    }
}
