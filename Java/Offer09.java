import java.util.*;

class CQueue {
    private Deque<Integer> s1;
    private Deque<Integer> s2;

    public CQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }
    
    public void appendTail(int value) {
        s1.addLast(value);
    }
    
    public int deleteHead() {
        if (s2.size() + s1.size() == 0) return -1;
        if (s2.size() == 0) {
            while(!s1.isEmpty()) {
                s2.addLast(s1.removeLast());
            }
        }
        return s2.removeLast();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */