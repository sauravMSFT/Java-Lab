package com.lab;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by saurav on 18/9/16.
 */
public class ExceptionHandling {
    public static void division()
            throws IOException, NumberFormatException, ArithmeticException, ArrayIndexOutOfBoundsException, Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b;

        System.out.print("Enter two numbers separated by space: ");
        String line = br.readLine().trim();
        if (line.equals("")) throw new Exception("Expected two integers, found empty string.");
        String[] str = line.split(" ");

        a = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[1]);

        if (b == 0) throw new ArithmeticException();
        System.out.println(a + " / " + b + " = " + (float) (a) / b);
    }

    public static void main(String[] args) {

        boolean success = false;
        while (!success) {
            try {
                division();
                success = true;
            } catch (IOException e) {
                System.out.println("Could not read input correctly.");
            } catch (NumberFormatException e) {
                System.out.println("Could not parse input as Integers.");
            } catch (ArithmeticException e) {
                System.out.println("Attempted a divide by zero.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter two integers.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
