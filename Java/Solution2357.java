class Solution2357 {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a1, a2) -> (a1 - a2));
        for (int num : nums) {
            if(num != 0) heap.add(num);
        }
        int res = 0;
        int total = 0, cur = 0;
        while(!heap.isEmpty()) {
            cur = heap.poll() - total;
            total += cur;
            res++;
            while (!heap.isEmpty() && heap.peek() == total) {
                heap.poll();
            }
        }
        return res;
    }
}

class Solution2357 {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num != 0) set.add(num);
        }
        return set.size();
    }
}