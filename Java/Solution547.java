class Solution547 {

    private int[] parent;
    private int num;

    public int findCircleNum(int[][] isConnected) {
        // 初始化并查集和操作数
        parent = new int[isConnected.length];
        for(int i = 0; i < isConnected.length; i++) {
            parent[i] = i;
        }
        num = 0;
        // 操作并查集
        for (int i = 0 ; i < isConnected.length; i++) {
            for (int j = i; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) union(i, j);
            }
        }
        // 根据初始并查集状态和操作次数确定省份数量
        return parent.length - num;
    }

    public void union(int x, int y) {
        // 合并
        if(find(x) != find(y)){
            parent[find(y)] = find(x);
            num++;
        }
    }

    public int find(int x) {
        // 查询
        if(parent[x] == x){ // 只有根节点满足parent[x] = x
            return x;
        } else{
            return find(parent[x]); // 递归查询找到某一结点的根结点
        }
    }

    public int dfsfindCircleNum(int[][] isConnected) {
        // 深度优先搜索确定所有连通分量
        boolean[] visited = new boolean[isConnected.length];
        int num = 0;
        for (int i = 0 ; i < isConnected.length; i++) {
            if (visited[i]) continue;
            dfs(isConnected, visited, i);
            num++;
        }
        return num;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int index) {
        visited[index] = true;
        int[] veradjs = isConnected[index];
        for (int i = 0; i < veradjs.length; i++) {
            if (visited[i]) continue;
            if (veradjs[i] == 1)
                dfs(isConnected, visited, i);
        }
    }
}