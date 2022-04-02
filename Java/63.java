/**
class Solution63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0; // 无法通行
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        boolean[] flag = new boolean[1];
        flag[0] = false;
        int[] res = new int[1];
        res[0] = 0;
        dfs(obstacleGrid, visited, 0, 0, res);
        return res[0];
    }

    public static void dfs(int[][] obstacleGrid, boolean[][] visited, int m, int n, int[] res){
        // 到达终点，返回
        if (m == obstacleGrid.length - 1 && n == obstacleGrid[0].length - 1 && obstacleGrid[m][n] != 1) { res[0]++; return;}
        // 下移
        if (m + 1 < obstacleGrid.length - 1 && obstacleGrid[m + 1][n] != 1 && !visited[m + 1][n]){
            visited[m + 1][n] = true;
            dfs(obstacleGrid, visited, m + 1, n, res);
            visited[m + 1][n] = false; // 回溯
        }
        // 右移
        if (n + 1 < obstacleGrid[0].length - 1 && obstacleGrid[m][n + 1] != 1 && !visited[m][n + 1]){
            visited[m][n + 1] = true;
            dfs(obstacleGrid, visited, m, n + 1, res);
            visited[m][n + 1] = false; // 回溯
        }
    }
}

*/

class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0; // 特例，起点就是障碍，无法通行
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 边界条件
        for (int i = obstacleGrid.length - 1; i >= 0 ; i--)
            if (obstacleGrid[i][obstacleGrid[0].length - 1] == 1) {dp[i][obstacleGrid[0].length - 1] = 0; break;}
            else dp[i][obstacleGrid[0].length - 1] = 1;
        for (int i = obstacleGrid[0].length - 1; i >= 0 ; i--)
            if (obstacleGrid[obstacleGrid.length - 1][i] == 1) {dp[obstacleGrid.length - 1][i] = 0; break;}
            else dp[obstacleGrid.length - 1][i] = 1;
        if (dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 0) return 0;
        // dp
        for (int i = obstacleGrid.length - 2; i >= 0; i--)
            for (int j = obstacleGrid[0].length - 2; j >= 0 ; j--){
                if (obstacleGrid[i][j] != 1) dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                else dp[i][j] = 0;
            }
        return dp[0][0];
    }
}