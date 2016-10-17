package com.lab.multi;

import java.util.Random;

/**
 * Created by saurav on 17/10/16.
 */
public class RandomSequence implements Runnable
{
    public RandomSequence(int count, String msg)
    {
        this.count = count;
        this.array = null;
        this.message = msg;
    }

    int count;
    int[] array;
    String message;

    public void run()
    {
        System.out.printf("%s started.\n", message);
        Random random = new Random();
        array = new int[count];
        for (int i = 0; i < count; ++i)
            array[i] = new Random().nextInt();
        System.out.printf("%s ended.\n", message);
    }
}
