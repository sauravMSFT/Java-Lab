package com.lab.multi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.function.Supplier;

/**
 * Created by saurav on 17/10/16.
 */
public class RandomSequence<T> implements Runnable
{
    int count;
    public ArrayList<T> array;
    Supplier<T> generator;
    Mode mode;

    public RandomSequence(Supplier<T> gen, int count, Mode mode)
    {
        this.array = new ArrayList<T>();
        this.count = count;
        this.generator = gen;
        this.mode = mode;
    }

    public RandomSequence(Supplier<T> gen, int count)
    {
        this(gen, count, Mode.SILENT);
    }

    public void run()
    {
        printDetails("Started");
        for (int i = 0; i < count; ++i)
        {
            if (mode == Mode.VERBOSE) RandomSequence.printDetails("Iteration " + i);
            array.add(generator.get());
        }
        printDetails("Ended");
    }

    public static void printDetails(String message)
    {
        System.out.printf("[Thread %s : Time %s : Log : %s]\n",
                          Thread.currentThread().getName(),
                          new SimpleDateFormat("HH:mm:ss.SSS")
                                  .format(Calendar.getInstance()
                                                  .getTime()),
                          message);
    }
}
