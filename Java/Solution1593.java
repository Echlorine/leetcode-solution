import java.util.*;

class Solution1593 {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return dfs(set, s);
    }

    public int dfs(Set<String> set, String str) {
        if (str == "") {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.substring(0, i + 1))) // 剪枝
                continue;
            set.add(str.substring(0, i + 1));
            res = Math.max(res, 1 + dfs(set, str.substring(i + 1, str.length())));
            // 回溯
            set.remove(str.substring(0, i + 1));
        }
        return res;
    }
}