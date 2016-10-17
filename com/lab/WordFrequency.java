package com.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by saurav on 2/10/16.
 */
public class WordCount
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a bunch of words: ");
        tokenize(br.readLine().trim());
    }

    private static void tokenize(String line)
    {
        StringTokenizer words = new StringTokenizer(line, " ");
        HashMap<String, Integer> wordMap = new HashMap<>();
        while (words.hasMoreTokens())
        {
            String word = words.nextElement().toString();
            if (wordMap.containsKey(word))
                wordMap.put(word, wordMap.get(word) + 1);
            else
                wordMap.put(word, 1);
        }
        System.out.printf("%-10s %10s\n", "WORD", "FREQUENCY");
        for (String key : wordMap.keySet())
            System.out.printf("%-10s %10s\n", key, wordMap.get(key));
    }
}
