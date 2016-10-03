package com.lab.school;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by saurav on 18/9/16.
 */
public class Student extends Person
{

    protected String reg, semester;

    public Student(String nameRep, String register, String sem)
    {
        super(nameRep);
        reg = register;
        this.semester = sem;
    }

    public static Student fromInput() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, reg, sem;

        System.out.print("Enter Name: ");
        name = br.readLine().trim();

        System.out.print("Enter USN: ");
        reg = br.readLine().trim();

        System.out.print("Enter Semester: ");
        sem = br.readLine().trim();

        return new Student(name, reg, sem);
    }

    @Override
    public String toString()
    {
        return super.toString() +
                "\nUSN: " + reg +
                "\nSemester: " + semester;
    }

    public static void main(String[] args) throws Exception
    {
        Student s = Student.    fromInput();
        System.out.println("\n\n" + s);
    }
}
