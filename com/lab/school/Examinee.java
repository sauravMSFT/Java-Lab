package com.lab.school;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by saurav on 18/9/16.
 */
public class Examinee extends Student
{

    protected double[] marks;

    public Examinee(String nameRep, String register, String sem, double[] marks)
    {
        super(register, nameRep, sem);
        this.marks = marks;
    }

    @Override
    public String toString()
    {
        return super.toString() +
                "\nMarks: " + Arrays.toString(marks) +
                "\nTotal Marks: " + Arrays.stream(marks).sum() + " / " + 800;
    }


    public static Examinee fromInput() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, reg, sem, tmp;
        double[] marks = new double[8];

        System.out.print("Enter Name: ");
        name = br.readLine().trim();

        System.out.print("Enter USN: ");
        reg = br.readLine().trim();

        System.out.print("Enter Semester: ");
        sem = br.readLine().trim();

        System.out.print("Enter marks for 8 subjects: ");
        tmp = br.readLine().trim();
        int i = 0;
        for (String mark : tmp.split(" "))
            marks[i++] = Double.parseDouble(mark);

        return new Examinee(name, reg, sem, marks);
    }

    public static void main(String[] args) throws Exception
    {
        Examinee e = Examinee.fromInput();
        System.out.println("\n\nReport Card\n" + e);
    }
}
