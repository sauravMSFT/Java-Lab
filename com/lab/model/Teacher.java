package com.lab.model;

/**
 * Created by saurav on 23/10/16.
 */
public class Teacher implements IPerson
{
    private static Generator codeGen = new Generator("14GATA", 1000);

    protected String name, code;
    protected int scale;

    public Teacher(String name, int scale)
    {
        this.name = name.trim();
        this.scale = scale;
        this.code = codeGen.generate();
    }

    public String getName() {return name;}

    @Override public void work() {
        System.out.println("\"I'm going to teach a new concept today...\"");
    }

    @Override public String toString()
    {
        return String.format("%1$10s %2$20s - %3$s",
                             code,
                             name,
                             scale);
    }
}
