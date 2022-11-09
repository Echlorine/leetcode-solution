import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution351 {
    private Set<Integer> set1 = new HashSet<>() {{
        add(1);
        add(3);
        add(7);
        add(9);
    }};
    private Set<Integer> set2 = new HashSet<>() {{
        add(2);
        add(8);
    }};
    private Set<Integer> set3 = new HashSet<>() {{
        add(4);
        add(6);
    }};
    private int res;

    public int numberOfPatterns(int m, int n) {
        this.res = 0;
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            visited[i] = true;
            dfs(i, visited, list, m, n);
            visited[i] = false;
        }
        return res;
    }

    public void dfs(int cur, boolean[] visited, List<Integer> list, int m, int n) {
        if (list.size() >= m) {
            res++;
        }
        if (list.size() == n) {
            return;
        }
        for (int i = 0; i < 9; i++) {
            // 每个节点只能访问一次
            if (visited[i]) {
                continue;
            }
            // 特例，穿过了没访问过的中心
            if (cross(cur, i)) {
                int mid = (cur + i + 2) / 2;
                if (!visited[mid - 1]) {
                    continue;
                }
            }
            // 访问当前结点
            visited[i] = true;
            list.add(i);
            dfs(i, visited, list, m, n);
            // 回溯
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public boolean cross(int cur, int next) {
        if (set1.contains(cur + 1) && set1.contains(next + 1)) {
            return true;
        } else if (set2.contains(cur + 1) && set2.contains(next + 1)) {
            return true;
        } else if (set3.contains(cur + 1) && set3.contains(next + 1)) {
            return true;
        }
        return false;
    }
}