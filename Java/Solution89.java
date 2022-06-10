import java.util.*;

class Solution89 {
    private boolean flag = false;

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int len = (int) Math.pow(2, n);
        boolean[] visited = new boolean[len];
        res.add(0);
        visited[0] = true;
        dfs(res, visited, n, len);
        return res;
    }

    public void dfs(List<Integer> res, boolean[] visited, int n, int len) {
        if (res.size() == len) {flag = true; return;}
        if (flag) return;
        int last = res.get(res.size() - 1);
        for (int i = 1; i < len; i <<= 1) {
            int cur = last ^ i;
            if (cur >= 0 && cur < len && !visited[cur]) {
                res.add(cur);
                visited[cur] = true;
                dfs(res, visited, n, len);
                if (flag) return; // 遇到正确答案即终止
                // 回溯
                visited[cur] = false;
                res.remove(res.size() - 1);
            }
        }
    }
}