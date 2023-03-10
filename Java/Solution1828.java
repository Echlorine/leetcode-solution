class Solution1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int num = 0;
            int x = query[0], y = query[1], r = query[2];
            for (int[] point : points) {
                int x_ = point[0], y_ = point[1];
                int len = (x_ - x) * (x_ - x) + (y_ - y) * (y_ - y);
                if (len <= r * r) num++;
            }
            res[i++] = num;
        }
        return res;
    }
}