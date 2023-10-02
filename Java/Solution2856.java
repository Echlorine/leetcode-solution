class Solution2856 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int n = 1;
        int last = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) != last) {
                queue.offer(n);
                n = 1;
         } else {
                n++;
            }
            last = nums.get(i);
        }
        queue.offer(n);
        // 每次取前两个
        while (queue.size() >= 2) {
            int a = queue.poll();
            int b = queue.poll();
            if (a > 1) queue.offer(a - 1);
            if (b > 1) queue.offer(b - 1);
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}