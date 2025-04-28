package org.example;

public class App {
    public static void main(String[] args) {
        // Example usage of the QueueTees
        QueueTees<Cutie> queue = new QueueTees<>(3);
        
        // Create some cuties
        Cutie puppy = new Cutie() {
            public String description() {
                return "A little puppy with big, sad eyes";
            }
            public Integer cutenessRating() {
                return 11;
            }
        };
        
        Cutie kitty = new Cutie() {
            public String description() {
                return "A fluffy kitten playing with yarn";
            }
            public Integer cutenessRating() {
                return 10;
            }
        };
        
        Cutie marmoset = new Cutie() {
            public String description() {
                return "Tiny pygmy marmoset with big eyes";
            }
            public Integer cutenessRating() {
                return 9;
            }
        };
        
        // Test the queue
        System.out.println("Initial size: " + queue.size()); // 0
        
        queue.enqueue(puppy);
        queue.enqueue(kitty);
        queue.enqueue(marmoset);
        
        System.out.println("Size after enqueues: " + queue.size()); // 3
        
        // Try to enqueue when full
        queue.enqueue(puppy); // Should print queue is full
        
        System.out.println("First dequeue: " + queue.dequeue().description()); // puppy
        System.out.println("Second dequeue: " + queue.dequeue().description()); // kitty
        
        queue.enqueue(puppy);
        System.out.println("Size after operations: " + queue.size()); // 2
        
        queue.clear();
        System.out.println("Size after clear: " + queue.size()); // 0
    }
}

class QueueTees<T> {
    private final T[] elements;
    private int front;
    private int rear;
    private int count;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public QueueTees(int size) {
        this.capacity = size;
        this.elements = (T[]) new Object[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + ((Cutie)item).description());
            return;
        }
        
        rear = (rear + 1) % capacity;
        elements[rear] = item;
        count++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        
        T item = elements[front];
        elements[front] = null; // clear the reference
        front = (front + 1) % capacity;
        count--;
        return item;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            elements[i] = null;
        }
        front = 0;
        rear = -1;
        count = 0;
    }
}