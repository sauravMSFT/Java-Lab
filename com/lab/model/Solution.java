package com.lab.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by saurav on 23/10/16.
 */
public class Solution
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter p = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {

        ArrayList<Student> students = new ArrayList<>();
        Teacher t;
        for (int i = 1; i <= 3; ++i)
        {
            System.out.print("Enter Name for Student " + i + ": ");
            students.add(new Student(br.readLine()));
        }
        System.out.print("Enter Class Teacher's Name: ");
        String name = br.readLine();
        System.out.print("Enter Scale: ");
        int scale = Integer.parseInt(br.readLine().trim());
        t = new Teacher(name, scale);

        p.println("\n\nSorted Students according to Name.");
        students.sort(new Comparator<Student>() {
            @Override public int compare(Student p, Student q) {
                return p.name.compareTo(q.name);
            }
        });
        printClass(students, t);

        p.println("\n\nSorted students according to Register Number.");
        students.sort((p, q) -> p.compareTo(q));
        printClass(students, t);

        System.out.println("\n\n\"What are you doing?\"");
        System.out.print("Student: "); students.get(0).work();
        System.out.print("Teacher: "); t.work();
    }

    private static void printClass(ArrayList<Student> students, Teacher t)
    {
        p.println("Class Teacher: " + t.getName());
        for (Student s : students)
            p.println(s);
    }
}