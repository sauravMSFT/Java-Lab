package com.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by saurav_msft on 22/8/16.
 */
public class Queue<T>
{
    private ArrayList<T> queue;
    private int count, maxSize;


    public Queue(int size)
    {
        queue = new ArrayList<>();
        count = 0;
        maxSize = size;
    }

    public void Enqueue(T item) throws Exception
    {
        if (count == maxSize)
            throw new Exception("Queue Overflow... Can't enqueue anymore items.");
        queue.add(item);
        count++;
    }

    public T Dequeue() throws Exception
    {
        if (count == 0)
            throw new Exception("Queue Underflow... Can't dequeue item.");

        count--;
        return queue.remove(0);
    }

    public void Display()
    {
        System.out.println(toString());
    }

    @Override
    public String toString()
    {
        StringBuffer rep = new StringBuffer("[ ");
        for (int i = 0; i < count; ++i) rep.append(String.format("%1$s  ", queue.get(i)));
        rep.append("] <--");
        return rep.toString();
    }

    private static void demo() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the size of the queue: ");
        int size = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new Queue<>(size);

        while (true)
        {
            System.out.println("Queue Operations:\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit");
            System.out.print("Enter your choice: ");


            int choice = Integer.parseInt(br.readLine());
            int item;
            switch (choice)
            {
                case 1:
                    System.out.println("Enter the number to Enqueue: ");
                    item = Integer.parseInt(br.readLine());

                    try
                    {
                        queue.Enqueue(item);
                        System.out.println(item + " was enqueued.");
                    }
                    catch (Exception e) { System.out.println(e.getMessage()); }

                    break;

                case 2:
                    try
                    {
                        item = queue.Dequeue();
                        System.out.println(item + " was dequeued.");
                    }
                    catch (Exception e) { System.out.println(e.getMessage()); }
                    break;
                case 3:
                    System.out.println("The queue contains: ");
                    queue.Display();
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
