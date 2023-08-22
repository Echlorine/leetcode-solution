class Solution1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adjacent = new ArrayList<>(); // 邻接表
        for(int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<>());
        }
        // 用邻接表表示图
        for (int i = 0; i < paths.length; i++){
            adjacent.get(paths[i][0] - 1).add(paths[i][1] - 1);
            adjacent.get(paths[i][1] - 1).add(paths[i][0] - 1);
        }
        // 颜色标记法
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            // 统计周围节点的颜色
            boolean[] colors = new boolean[5];
            for (int adj : adjacent.get(i)) {
                colors[res[adj]] = true;
            }
            // 给当前节点上色
            for (int j = 1; j <= 4; j++) {
                if (!colors[j]) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}