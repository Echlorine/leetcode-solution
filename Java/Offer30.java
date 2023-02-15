class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.addLast(x);
        if (minStack.size() > 0) {
            minStack.addLast(Math.min(minStack.peekLast(),x));
        } else {
            minStack.addLast(x);
        }
    }
    
    public void pop() {
        stack.removeLast();
        minStack.removeLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int min() {
        return minStack.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */