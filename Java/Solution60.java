class Solution60 {
    private String res;
    
    public String getPermutation(int n, int k) {
        dfs(new StringBuffer(), new boolean[n], n, new int[] {0, k});
        return res;
    }

    public void dfs(StringBuffer bf, boolean[] visited, int n, int[] index) {
        if (bf.length() == n) {
            if (++index[0] == index[1]) res = bf.toString();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            bf.append(String.valueOf(i + 1));
            dfs(bf, visited, n, index);
            if (index[0] == index[1]) return;
            bf.delete(bf.length() - 1, bf.length());
            visited[i] = false;
        }
    }
}