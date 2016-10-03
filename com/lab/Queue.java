package com.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

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
        queue.add(item);
        count++;
    }

    public T Dequeue()
    {
        count--;
        return queue.remove(0);
    }

    public int size()
    {
        return queue.size();
    }

    public int maxSize()
    {
        return maxSize;
    }

    public void Display()
    {
        System.out.println(toString());
    }

    @Override
    public String toString()
    {
        return Arrays.toString(queue.toArray()) + " <--";
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
                    if (queue.size() == queue.maxSize())
                    {
                        System.out.println("Queue Overflow...");
                        break;
                    }
                    System.out.print("Enter the number to Enqueue: ");
                    item = Integer.parseInt(br.readLine());
                    queue.Enqueue(item);
                    System.out.println(item + " was enqueued.");
                    break;

                case 2:
                    if (queue.size() == 0)
                    {
                        System.out.println("Queue Underflow...");
                        break;
                    }
                    item = queue.Dequeue();
                    System.out.println(item + " was dequeued.");
                    break;
                case 3:
                    System.out.print("The queue contains: ");
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
