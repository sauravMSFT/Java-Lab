package com.lab;

import java.util.ArrayList;

/**
 * Created by saurav on 18/9/16.
 */
public class Text {
    protected ArrayList<Character> val;
    protected int length;

    public char charAt(int i) {
        return val.get(i);
    }

    public int strlen() {
        return length;
    }

    public void strcat(Text t) {
        for (char ch : t.val)
            val.add(ch);
    }

    public void strcat(String str) {
        for (int i = 0; i < str.length(); ++i)
            val.add(str.charAt(i));
    }
}
