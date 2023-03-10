class Solution1753 {
    public int maximumScore(int a, int b, int c) {
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((q1, q2) -> q2 - q1);
        queue.add(a);
        queue.add(b);
        queue.add(c);
        while(queue.size() > 1) {
            boolean flag = false;
            int t1 = queue.poll();
            int t2 = queue.poll();
            t1--;
            t2--;
            if (t1 >= 0 && t2 >= 0) {
                queue.add(t1);
                queue.add(t2);
                res++;
            }
        }
        return res;
    }
}