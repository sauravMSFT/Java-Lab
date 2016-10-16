package com.lab;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public static boolean strcmp(Text a, Text b)
    {

        int l1, l2, c1, c2;

        l1 = a.strlen();
        l2 = b.strlen();
        if(l1 != l2) return false;
        for (int i = 0; i < l1; ++i)
        {
            c1 = a.val.get(i);
            c2 = b.val.get(i);
            if (c1 != c2)
                return false;
        }
        return true;
    }

    public static boolean strcmp(String a, String b)
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

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out, true);

        p.println("Enter String 1: ");
        Text str1 = new Text(br.readLine().trim());

        p.println("Enter String 2: ");
        Text str2 = new Text(br.readLine().trim());

        p.println("Enter String 3: ");
        Text str3 = new Text(br.readLine().trim());

        p.print(String.format("\n1. strcpy\n\"%1$s\".strcpy(\"%2$s\") = \"", str1, str2));
        str1.strcpy(str2);
        p.println(str1 + "\"");

        p.println(String.format("\n2. strlen\n\"%1$s\".strlen() = %2$s", str1, str1.strlen()));

        p.print(String.format("\n3. strcat\n\"%1$s\".strcat(\"%2$s\") = \"", str1, str2));
        str1.strcat(str2);
        p.println(str1 + "\"");

        p.println(String.format("\n4. strcmp\nstrcmp(\"%1$s\", \"%2$s\") = %3$s", str1, str3, strcmp(str1, str3)));

        p.println(String.format("\n3. charAt\n\"%1$s\".charAt(%2$s) = \"%3$s\"", str3, str3.strlen()/2, str3.charAt(str3.strlen()/2)));
    }
}
