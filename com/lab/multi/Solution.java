package com.lab.multi;

import java.util.Random;

/**
 * Created by saurav on 17/10/16.
 */
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int iter = 5;
        Random random = new Random();
        RandomSequence<Integer> integer =
                new RandomSequence<>(
                        () -> random.nextInt(100),
                        iter);

        RandomSequence<Float> floating =
                new RandomSequence<>(
                        () -> random.nextFloat(),
                        iter);

        RandomSequence<Character> chars =
                new RandomSequence<>(
                        () -> (char) (random.nextInt(26) + 'a'),
                        iter);

        Thread a = new Thread(integer, "A");
        Thread b = new Thread(floating, "B");
        Thread c = new Thread(chars, "C");

        a.start();
        b.start();
        c.start();

        a.join(); b.join(); c.join();

        System.out.printf("A: %s\nB: %s\nC: %s",
                          integer.array,
                          floating.array,
                          chars.array);
    }
}
