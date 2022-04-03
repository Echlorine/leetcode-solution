class Solution279 {
    public int numSquares(int n) {
        // dp
        int[] res = new int[n + 1];
        int temp;
        res[0] = 0;
        for (int i = 1; i < res.length; i++) {
            temp = 101;
            for(int j = 1; j <= Math.sqrt(i); j++)
                temp = 1 + Math.min(temp, res[i - j * j]);
            res[i] = 1 + temp;
        }
        return res[n];
    }
}