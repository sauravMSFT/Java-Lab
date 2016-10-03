package com.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by saurav_msft on 22/8/16.
 */
public class Stack<T>
{
    private ArrayList<T> stack;
    private int top, count, maxSize;


    public Stack(int size)
    {

        stack = new ArrayList<>();
        top = -1;
        count = 0;
        maxSize = size;
    }

    public int size()
    {
        return stack.size();
    }

    public int maxSize()
    {
        return maxSize;
    }

    public void Push(T item)
    {
        stack.add(item);
        top++;
        count++;
    }

    public T Pop()
    {
        top--;
        count--;
        return stack.remove(top + 1);
    }

    public void Display()
    {
        System.out.println(toString());
    }

    @Override
    public String toString()
    {
        return Arrays.toString(stack.toArray()) + " <-- ";
    }

    private static void demo() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the size of the stack: ");
        int size = Integer.parseInt(br.readLine()), item;
        Stack<Integer> stack = new Stack<>(size);

        while (true)
        {
            System.out.println("Stack Operations:\n1. Push\n2. Pop\n3. Display\n4. Exit");
            System.out.print("Enter your choice: ");

            switch (Integer.parseInt(br.readLine()))
            {
                case 1:
                    if (stack.size() == stack.maxSize())
                    {
                        System.out.println("Stack Overflow...");
                        break;
                    }
                    System.out.print("Enter the number to Push: ");
                    item = Integer.parseInt(br.readLine());
                    stack.Push(item);
                    System.out.println(item + " was pushed onto the Stack.");
                    break;

                case 2:
                    if (stack.size() == 0)
                    {
                        System.out.println("Stack Underflow...");
                        break;
                    }
                    item = stack.Pop();
                    System.out.println(item + " was popped off the Stack.");
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
