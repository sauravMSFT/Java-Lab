package com.lab.school;

/**
 * Created by saurav on 18/9/16.
 */
public class Student extends Person{

    protected String reg;
    protected String semester;
    public Student(String register, String nameRep, String sem)
    {
        super(nameRep);
        reg = register;
        this.semester = sem;
    }
}
