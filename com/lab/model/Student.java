package com.lab.model;

import java.util.ArrayList;

/**
 * Created by saurav on 23/10/16.
 */
public class Student implements IPerson, IComparable<Student>
{
    private static Generator regGen = new Generator("14GAEC", 9000);

    protected String name, reg;

    public Student(String name)
    {
        this.name = name.trim();
        this.reg = regGen.generate();
    }

    @Override public void work()
    {
        System.out.println("\"Okay, I'm going to study...\"");
    }

    @Override public int compareTo(Student other)
    {
        return reg.compareTo(other.reg);
    }

    @Override public String toString()
    {
        return String.format("%1$10s %2$s",
                             reg,
                             name);
    }
}
