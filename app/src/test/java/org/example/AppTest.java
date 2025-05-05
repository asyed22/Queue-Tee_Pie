package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    static class TestPuppy implements Cutie {
        private final String desc;
        private final int rating;

        TestPuppy(String desc, int rating) {
            this.desc = desc;
            this.rating = rating;
        }

        public String description() { return desc; }
        public Integer cutenessRating() { return rating; }
    }

    @Test
    void testQueueOperations() {
        QueueTees<Cutie> queue = new QueueTees<>(3);
        Cutie puppy = new TestPuppy("Test Puppy", 10);
        
        assertTrue(queue.isEmpty());
        queue.enqueue(puppy);
        assertEquals(1, queue.size());
    }

    @Test
    void testEnqueueAndDequeueFIFO() {
        QueueTees<Cutie> queue = new QueueTees<>(3);
        Cutie a = new TestPuppy("Puppy A", 8);
        Cutie b = new TestPuppy("Puppy B", 9);
        Cutie c = new TestPuppy("Puppy C", 10);

        queue.enqueue(a);
        queue.enqueue(b);
        queue.enqueue(c);

        assertEquals(a, queue.dequeue());
        assertEquals(b, queue.dequeue());
        assertEquals(c, queue.dequeue());
    }

    @Test
    void testQueueFullPrevention() {
        QueueTees<Cutie> queue = new QueueTees<>(2);
        queue.enqueue(new TestPuppy("One", 5));
        queue.enqueue(new TestPuppy("Two", 6));
        assertTrue(queue.isFull());

        int sizeBefore = queue.size();
        queue.enqueue(new TestPuppy("Three", 7)); // Should not be added
        assertEquals(sizeBefore, queue.size());   // Confirm unchanged
    }

    @Test
    void testQueueEmptyDequeue() {
        QueueTees<Cutie> queue = new QueueTees<>(1);
        assertNull(queue.dequeue()); // Should handle empty dequeue gracefully
    }

    @Test
    void testClearQueue() {
        QueueTees<Cutie> queue = new QueueTees<>(3);
        queue.enqueue(new TestPuppy("Clear Me", 7));
        queue.enqueue(new TestPuppy("And Me", 6));
        assertEquals(2, queue.size());

        queue.clear();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
        assertNull(queue.dequeue()); // Confirm it's empty
    }
}
