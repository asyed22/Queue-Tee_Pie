package org.example;

public class QueueTees<T> {
    private final T[] queueArray;
    private int front;
    private int rear;
    private int currentSize;
    private final int maxSize;

    @SuppressWarnings("unchecked")
    public QueueTees(int size) {
        this.maxSize = size;
        this.queueArray = (T[]) new Object[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item.toString());
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = item;
        currentSize++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        T item = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return item;
    }

    public int size() {
        return currentSize;
    }

    public void clear() {
        front = 0;
        rear = -1;
        currentSize = 0;
    }
}