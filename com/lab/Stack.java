package com.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by saurav_msft on 22/8/16.
 */
public class Stack<T>
{
    private ArrayList<T> stack;
    private int top, count, maxSize;


    public Stack(int size)
    {
        stack = new ArrayList<T>();
        top = -1;
        count = 0;
        maxSize = size;
    }

    public void Push(T item) throws Exception
    {
        if (top == maxSize - 1)
            throw new Exception("Stack Overflow... Could not Push " + item.toString() + ".");
        stack.add(item);
        top++;
        count++;
    }

    public T Pop() throws Exception
    {
        if (stack.isEmpty())
            throw new Exception("Stack Underflow... Could not Pop element.");

        top--;
        count--;
        return stack.remove(top + 1);
    }

    public void Display()
    {
        System.out.println(this.toString());
    }

    @Override
    public String toString()
    {
        StringBuffer rep = new StringBuffer("--> [ ");
        if (top != -1)
        {
            for (int i = top; i > 0; --i) rep.append(String.format("%1$s, ", stack.get(i)));
            rep.append(String.format("%1$s ]", stack.get(0)));
        } else rep.append("]");
        return rep.toString();
    }

    private static void demo() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the size of the stack: ");
        int size = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>(size);

        while (true)
        {
            System.out.println("Stack Operations:\n1. Push\n2. Pop\n3. Display\n4. Exit");
            System.out.print("Enter your choice: ");


            int choice = Integer.parseInt(br.readLine());
            int item;
            switch (choice)
            {
                case 1:
                    System.out.println("Enter the number to Push: ");
                    item = Integer.parseInt(br.readLine());

                    try
                    {
                        stack.Push(item);
                        System.out.println(item + " was pushed onto the Stack.");
                    }
                    catch (Exception e) { System.out.println(e.getMessage()); }

                    break;

                case 2:
                    try
                    {
                        item = stack.Pop();
                        System.out.println(item + " was popped off the Stack.");
                    }
                    catch (Exception e) { System.out.println(e.getMessage()); }
                    break;
                case 3:
                    System.out.println("The stack contains: ");
                    stack.Display();
                    break;
                case 4:
                    return;
            }
        }
    }


    public static void main(String[] args) throws Exception
    {
        demo();
    }
}
