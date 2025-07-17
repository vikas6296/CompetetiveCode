package org.example;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueImplUsingStack
{
    Queue<Integer> queue ;
    public QueueImplUsingStack()
    {
        queue  = new ArrayDeque<>();
        System.out.println("Non paramterized constructor call");
    }

    public QueueImplUsingStack(int a)
    {
        queue  = new ArrayDeque<>();
        System.out.println(" paramterized constructor call");
    }




    public void push(int x) {
        queue.offer(x);

        // Rotate all other elements behind the new one
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll(); // Front is the top
    }

    public int top() {
        return queue.peek(); // Front is the top
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String a[])
    {
        //QueueImplUsingStack qs = new QueueImplUsingStack();
       QueueImplUsingStack is = new QueueImplUsingStack(1);
    }
}
