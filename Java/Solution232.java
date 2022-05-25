import java.util.*;

class MyQueue {
    private Deque<Integer> inqueue;
    private Deque<Integer> outqueue;

    public MyQueue() {
        inqueue = new ArrayDeque<>();
        outqueue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        inqueue.addLast(x);
    }
    
    public int pop() {
        if (outqueue.isEmpty()) {
            while (!inqueue.isEmpty()) {
                outqueue.addLast(inqueue.removeLast());
            }
        }
        return outqueue.removeLast();
    }
    
    public int peek() {
        if (outqueue.isEmpty()) {
            while (!inqueue.isEmpty()) {
                outqueue.addLast(inqueue.removeLast());
            }
        }
        return outqueue.peekLast();
    }
    
    public boolean empty() {
        return inqueue.isEmpty() && outqueue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */