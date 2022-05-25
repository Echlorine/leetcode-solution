import java.util.*;

class MyStack {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public MyStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (stack1.isEmpty())
            stack2.add(x);
        else stack1.add(x);
    }
    
    public int pop() {
        int len1 = stack1.size(), len2 = stack2.size();
        if (stack1.isEmpty()) {
            for (int i = 0; i < len2 - 1; i++) {
                stack1.add(stack2.remove());
            }
            return stack2.remove();
        }
        else {
            for (int i = 0; i < len1 - 1; i++) {
                stack2.add(stack1.remove());
            }
            return stack1.remove();
        }
    }
    
    public int top() {
        int res;
        int len1 = stack1.size(), len2 = stack2.size();
        if (stack1.isEmpty()) {
            for (int i = 0; i < len2 - 1; i++) {
                stack1.add(stack2.remove());
            }
            res = stack2.peek();
            stack1.add(stack2.remove());
        }
        else {
            for (int i = 0; i < len1 - 1; i++) {
                stack2.add(stack1.remove());
            }
            res = stack1.peek();
            stack2.add(stack1.remove());
        }
        return res;
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */