class MovingAverage {

    private Queue<Integer> queue;
    private int size;
    
    private int sum = 0;

    public MovingAverage(int size) {
        queue = new ArrayDeque<>();
        this.size = size;
    }
    
    public double next(int val) {
        if (queue.size() >= size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return 1.0 * sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */