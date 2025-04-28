package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testQueueOperations() {
        QueueTees<Cutie> queue = new QueueTees<>(2);
        
        Cutie testCutie = new Cutie() {
            public String description() { return "Test"; }
            public Integer cutenessRating() { return 5; }
        };
        
        // Test initial state
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        
        // Test enqueue
        queue.enqueue(testCutie);
        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());
        
        // Test dequeue
        Cutie dequeued = queue.dequeue();
        assertEquals("Test", dequeued.description());
        assertEquals(5, dequeued.cutenessRating());
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
        
        // Test full queue
        queue.enqueue(testCutie);
        queue.enqueue(testCutie);
        assertTrue(queue.isFull());
        queue.enqueue(testCutie); // Should print full message
        assertEquals(2, queue.size());
        
        // Test clear
        queue.clear();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }
    
    @Test
    void testEmptyDequeue() {
        QueueTees<Cutie> queue = new QueueTees<>(1);
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }
}