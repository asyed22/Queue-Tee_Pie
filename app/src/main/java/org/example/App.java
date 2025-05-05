package org.example;

public class App {
    public static void main(String[] args) {
        QueueTees<Cutie> queue = new QueueTees<>(3);
        queue.enqueue(new Puppy());
        System.out.println("Queue size: " + queue.size());
    }
}