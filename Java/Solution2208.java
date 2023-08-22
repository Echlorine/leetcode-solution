class Solution2208 {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o2 > o1) return 1;
                else if (o2 == o1) return 0;
                else return -1;
            }
        });
        long sum = 0;
        for (int num : nums) {
            heap.add(Double.valueOf(num));
            sum += num;
        }
        // 贪心，每次取出最大值
        double ans = 0;
        int res = 0;
        while (ans * 2 < sum) {
            res++;
            double t = heap.poll();
            ans += t / 2;
            heap.add(t / 2);
        }
        return res;
    }
}