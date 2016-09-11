package com.lab.school;

/**
 * Created by saurav on 9/6/2016.
 */
public class Name {
    private String firstName, middleName, lastName;

    public Name(String rep) {
        String[] p = rep.split(" ");
        if (p.length == 2) setValues(p[0], "", p[1]);
        else setValues(p[0], p[1], p[2]);
    }

    private void setValues(String f, String m, String l) {
        firstName = f;
        middleName = m;
        lastName = l;
    }

    public Name(String f, String l) {
        setValues(f, "", l);
    }

    public Name(String f, String m, String l) {
        setValues(f, m, l);
    }

    @Override
    public String toString() {
        if (middleName == "") {
            return String.format("%1$s %2$s", firstName, lastName);
        } else return String.format("%1$s %$2s %3$s", firstName, middleName, lastName);
    }
}
