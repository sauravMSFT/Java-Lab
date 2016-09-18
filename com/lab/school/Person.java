package com.lab.school;

/**
 * Created by saurav on 18/9/16.
 */
public class Person {
    protected String firstName, middleName, lastName;
    public Person(String rep) {
        String[] p = rep.trim().split(" ");
        if (p.length == 2) setValues(p[0], "", p[1]);
        else setValues(p[0], p[1], p[2]);
    }

    private void setValues(String f, String m, String l) {
        firstName = f;
        middleName = m;
        lastName = l;
    }

    public String getName() {
        if (middleName == "") {
            return String.format("%1$s %2$s", firstName, lastName);
        } else return String.format("%1$s %$2s %3$s", firstName, middleName, lastName);
    }
}
