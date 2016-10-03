package com.lab;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by saurav on 18/9/16.
 */
public class Text
{

    public Text()
    {
        val = new ArrayList<>();
    }

    public Text(String str)
    {
        this();
        for (int i = 0; i < str.length(); ++i)
        {
            val.add(str.charAt(i));
        }
    }

    public Text(char[] chars)
    {
        this();
        for (int i = 0; i < chars.length; ++i)
        {
            val.add(chars[i]);
        }
    }

    public Text(Text t)
    {
        this.strcpy(t);
    }

    protected ArrayList<Character> val;

    public Text charAt(int i)
    {
        return new Text(val.get(i).toString());
    }

    public Text charAt(int i, int j)
    {
        Text t = new Text();
        for (int x = i; x < j; ++x)
            t.val.add(val.get(x));
        return t;
    }

    public int strlen()
    {
        return val.size();
    }

    public void strcat(Text t)
    {
        for (char ch : t.val)
            val.add(ch);
    }

    public void strcat(String str)
    {
        for (int i = 0; i < str.length(); ++i)
            val.add(str.charAt(i));
    }

    public void strcat(char[] chars)
    {
        for (char ch : chars)
            val.add(ch);
    }

    public static int strcmp(Text a, Text b)
    {

        int l1, l2, c1, c2;

        l1 = a.strlen();
        l2 = b.strlen();

        int less = Math.min(l1, l2);
        for (int i = 0; i < less; ++i)
        {
            c1 = a.val.get(i);
            c2 = b.val.get(i);
            if (c1 != c2)
                return c1 - c2;
        }
        if (l1 == l2)
            return 0;
        else if (l1 > l2)
            return a.val.get(l1 - 1);
        else return b.val.get(l2 - 1);
    }

    public static int strcmp(String a, String b)
    {
        return strcmp(new Text(a), new Text(b));
    }

    public void strcpy(Text t)
    {
        val = new ArrayList<>();
        for (int i = 0; i < t.strlen(); ++i)
            val.add(t.val.get(i));
    }

    public void strcpy(String str)
    {
        val = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i)
            val.add(str.charAt(i));
    }

    public void strcpy(char[] chars)
    {
        val = new ArrayList<>();
        for (int i = 0; i < chars.length; ++i)
            val.add(chars[i]);
    }

    @Override
    public String toString()
    {
        StringBuffer rep = new StringBuffer();
        for (int i = 0; i < strlen(); ++i)
            rep.append(val.get(i));
        return rep.toString();
    }

    public static void main(String[] args)
    {
        PrintWriter p = new PrintWriter(System.out, true);

        Text greet = new Text("Hello. "), question = new Text("How are you?");
        Text reply = new Text(new char[]{'G', 'o', 'o', 'd'});

        p.println("\ntoString\n");
        op("greet = ", greet);
        op("question = ", question);
        op("reply = ", reply);

        p.println("\nstrcat\n");
        op("greet: ", greet);
        greet.strcat(question);
        op("greet = greet + question: ", greet);

        p.println("\ncharAt\n");
        op("reply[1] = ", reply.charAt(0));
        op("Slicing reply[1:3] = ", reply.charAt(1, 3));

        p.println("\nstrlen\n");
        op("question.strlen() = ", Integer.toString(question.strlen()));

        p.println("\nstrcpy\n");
        reply.strcpy(question);
        op("reply.strcpy(question): reply = ", reply);

        p.println("\nstrcmp\n");
        op("(strcmp(reply, question) == 0) = ",
                Boolean.toString(strcmp(reply, question) == 0));

    }

    private static void op(String a, String str)
    {
        System.out.println(a + str);
    }

    private static void op(String a, Text b)
    {
        System.out.println(a + "\"" + b + "\"");
    }
}
