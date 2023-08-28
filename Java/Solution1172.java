class DinnerPlates {
    int capacity;
    Map<Integer, Deque<Integer>> map; // 餐盘栈
    PriorityQueue<Integer> q1 = new PriorityQueue<>(); // 维护暂时还没满的栈
    PriorityQueue<Integer> q2 = new PriorityQueue<>((a, b) -> (b -a)); // 维护有元素的栈
    int index;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        map = new TreeMap<>();
        index = 0;
        q1.offer(index);
    }
    
    public void push(int val) {
        int t = q1.peek();
        if (!map.containsKey(t) || map.get(t).size() == 0) q2.offer(t);
        if (!map.containsKey(t)) {
            map.put(t, new ArrayDeque<>());
        }
        if (map.get(t).size() + 1 == capacity) {
            // 到下一个栈
            q1.poll();
            if (q1.size() == 0) {
                index++;
                q1.offer(index);
            }
        }
        map.get(t).push(val);
    }
    
    public int pop() {
        while (q2.size() > 0 && map.get(q2.peek()).size() == 0) {
            q2.poll();
        }
        if (q2.size() <= 0) return -1;
        int t = q2.peek();
        if (map.get(t).size() == capacity) {
            q1.offer(t);
        }
        if (map.get(t).size() == 1) {
            q2.poll();
        }
        return map.get(t).pop();
    }
    
    public int popAtStack(int index) {
        if (!map.containsKey(index) || map.get(index).size() <= 0) return -1;
        if (map.get(index).size() == capacity) {
            q1.offer(index);
        }
        return map.get(index).pop();
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */