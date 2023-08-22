class Solution2679 {
    public int matrixSum(int[][] nums) {
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 把每一行都用优先队列排序
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int j = 0; j < nums[i].length; j++) {
                queue.add(nums[i][j]);
            }
            list.add(queue);
        }
        // 得到每一行的最大值，确定每一次的分数
        int res = 0;
        for (int j = 0; j < nums[0].length; j++) {
            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                max = Math.max(max, list.get(i).poll());
            }
            res += max;
        }
        return res;
    }
}