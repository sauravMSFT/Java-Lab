package com.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by saurav on 3/10/16.
 */
public class BubbleSorter
{
    protected Integer[] array, sorted;

    public BubbleSorter(Integer[] array)
    {
        this.array = array;
    }

    public Integer[] sort()
    {
        if (sorted != null)
            return sorted;
        int len = array.length;
        int tmp;
        sorted = Arrays.copyOf(array, array.length);
        for (int i = 0; i < len; ++i)
        {
            for (int j = 0; j < len - i - 1; ++j)
            {
                if (sorted[j] > sorted[j + 1])
                {
                    tmp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = tmp;
                }
            }
        }
        return sorted;
    }

    public static Integer[] sort(Integer[] array)
    {
        return (new BubbleSorter(array)).sort();
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the numbers to sort: ");

        ArrayList<Integer> array = new ArrayList<>();
        for (String num : br.readLine().split(" "))
            array.add(Integer.parseInt(num));
        System.out.println("Sorted Array: " + Arrays.toString(BubbleSorter.sort(array.toArray(new Integer[array.size()]))));
    }
}
