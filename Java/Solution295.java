import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> maxQueue;
    private PriorityQueue<Integer> minQueue;

    public MedianFinder() {
        this.maxQueue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        this.minQueue = new PriorityQueue<>((v1, v2) -> v1 - v2);
    }
    
    public void addNum(int num) {
        if (!maxQueue.isEmpty() && num <= maxQueue.peek()) {
            maxQueue.add(num);
        } else {
            minQueue.add(num);
        }
        // 保持两个队列平衡
        if (maxQueue.size() - minQueue.size() > 1) {
            minQueue.add(maxQueue.poll());
        } else if (minQueue.size() - maxQueue.size() > 1) {
            maxQueue.add(minQueue.poll());
        }
    }
    
    public double findMedian() {
        int num = maxQueue.size() + minQueue.size();
        if (num % 2 == 0) {
            return (double) (maxQueue.peek() + minQueue.peek()) / 2;
        } else {
            return maxQueue.size() > minQueue.size() ? maxQueue.peek() : minQueue.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */