class Solution1086 {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> s = new PriorityQueue<>();
        for (int[] item : items) {
            if (!map.containsKey(item[0])) {
                map.put(item[0], new PriorityQueue<>((a, b) -> (b - a)));
                s.offer(item[0]);
            }
            map.get(item[0]).offer(item[1]);
        }
        int[][] res = new int[map.size()][2];
        for(int i = 0; i < res.length; i++) {
            res[i][0] = s.poll();
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += map.get(res[i][0]).poll();
            }
            res[i][1] = sum / 5;
        }
        return res;
    }
}