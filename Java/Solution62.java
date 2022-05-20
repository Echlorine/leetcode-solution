// class Solution62 {
//     public int uniquePaths(int m, int n) {
//         int[] res = new int[3];
//         res[0] = 0; res[1] = m - 1; res[2] = n - 1;
//         boolean[][] visited = new boolean[m][n];
//         dfs(0, 0, res, visited);
//         return res[0];
//     }

//     public  void dfs(int a, int b, int[] nums, boolean[][] visited){
//         if (a == nums[1] && b == nums[2]) {nums[0]++; return;}
//         // 往下走
//         if (a < nums[1] && !visited[a + 1][b]) {
//             visited[a + 1][b] = true;
//             dfs(a + 1, b, nums, visited);
//             visited[a + 1][b] = false; // 回溯
//         }
//         // 往右走
//         if (b < nums[2] && !visited[a][b + 1]) {
//             visited[a][b + 1] = true;
//             dfs(a, b + 1, nums, visited);
//             visited[a][b + 1] = false; // 回溯
//         }
//     }
// }

class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++)
            res[i][n - 1] = 1;
        for (int i = 0; i < n; i++)
            res[m - 1][i] = 1;
        for (int i = m - 2; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--){
                res[i][j] = res[i + 1][j] + res[i][j + 1];
            }
        return res[0][0];
    }
}