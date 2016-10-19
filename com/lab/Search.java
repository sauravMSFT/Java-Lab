package com.lab;

import java.io.BufferedReader;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by saurav on 18/10/16.
 */
public class Search
{
    public static int search(int[] arr, int key)
    {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high)
        {
            mid = (low + high) / 2;
            if (arr[mid] == key)
                return mid;
            if (key > arr[mid])
                low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int search(double[] arr, double key)
    {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high)
        {
            mid = (low + high) / 2;
            if (arr[mid] == key)
                return mid;
            if (key > arr[mid])
                low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out, true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers;
        int length, key, res;
        int[] ints;
        double key1;
        double[] doubles;

        //Integer
        pw.println("Enter sorted integers: ");
        numbers = Arrays.asList(br.readLine().trim().split(" "));
        length = numbers.size();
        ints = new int[length];

        for (int i = 0; i < length; ++i)
            ints[i] = parseInt(numbers.get(i));

        pw.println("Enter key to search: ");
        key = parseInt(br.readLine().trim());
        res = search(ints, key);
        if (res != -1)
            pw.printf("'%d' found at index %d.\n", key, res);
        else pw.printf("'%d' was not found in the array.\n", key);

        //Double
        pw.println("Enter sorted floats: ");
        numbers = Arrays.asList(br.readLine().trim().split(" "));
        length = numbers.size();
        doubles = new double[length];

        for (int i = 0; i < length; ++i)
            doubles[i] = parseDouble(numbers.get(i));

        pw.println("Enter key to search: ");
        key1 = parseDouble(br.readLine().trim());
        res = search(doubles, key1);
        if (res != -1)
            pw.printf("'%f' found at index %d.\n", key1, res);
        else pw.printf("'%f' was not found in the array.\n", key1);
    }

}
