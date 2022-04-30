class Solution473 {
    public boolean makesquare(int[] matchsticks) {
        boolean[] visited = new boolean[matchsticks.length];
        // 计算边长
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++)
            sum += matchsticks[i];
        if (sum %4 != 0) return false;
        sum /= 4;
        return dfs(matchsticks, visited, new int[] {0,0,0,0}, sum, 0);
    }

    public boolean dfs(int[] matchsticks, boolean[] visited, int[] matrixlen, int sum, int index) {
        if (matrixlen[3] == sum && matrixlen[2] == sum && matrixlen[1] == sum && matrixlen[0] == sum) return true;
        for (int loc = 0; loc < 4; loc++) {
            // 判断当前加在4组中的哪一组
            // 剪枝条件，添加元素在第一个不为0的边长或者不为0的边长
            if (loc > 0 && matrixlen[loc] == 0 && matrixlen[loc - 1] == 0)
                continue;
            if (matrixlen[loc] + matchsticks[index] <= sum) {
                visited[index] = true;
                matrixlen[loc] += matchsticks[index];
                if (dfs(matchsticks, visited, matrixlen, sum, index + 1)) return true;
                // 回溯
                visited[index] = false;
                matrixlen[loc] -= matchsticks[index];
            }
        }
        return false;
    }
}