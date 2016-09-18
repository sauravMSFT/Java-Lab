package com.lab.school;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by saurav on 18/9/16.
 */
public class Examinee extends Student {

    protected double[] marks;

    public Examinee(String nameRep, String register, String sem, double[] marks) {
        super(register, nameRep, sem);
        this.marks = marks;
    }

    protected String getResult(double avg) {
        if (avg > 75)
            return "First Class with Distinction";
        else if (avg > 65)
            return "First Class";
        else if (avg > 55)
            return "Second Class";
        else
            return "Fail";
    }

    public String showReport() {
        StringBuffer rep = new StringBuffer();
        double avg = Arrays.stream(marks).sum() / marks.length;
        return getResult(avg);
    }

    @Override
    public String toString() {
        StringBuffer rep = new StringBuffer();
        rep.append("Name: " + getName() + '\n'
                + "University Serial Number: " + reg + '\n'
                + "Semester: " + semester + '\n'
                + "Marks: " + Arrays.toString(marks) + '\n'
                + "Result: " + showReport());
        return rep.toString();
    }

    public static void main(String[] args) throws Exception{
        Examinee e = Examinee.fromInput();
        System.out.println("\n\nReport Card\n"+ e.toString());
    }

    public static Examinee fromInput() throws Exception {
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
}