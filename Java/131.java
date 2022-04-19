import java.util.*;

class Solution131 {

    private List<List<String>> res = new ArrayList<List<String>>();
    private List<String> ans = new ArrayList<String>();

    public List<List<String>> partition(String s) {

        boolean[][] flag = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < s.length(); j++)
                flag[i][j] = true;
        for (int i = s.length() - 1; i >= 0; --i)
            for (int j = i + 1; j < s.length(); ++j)
                flag[i][j] = (s.charAt(i) == s.charAt(j)) && flag[i + 1][j - 1];
        dfs(flag, s, 0, s.length());
        return res;
    }

    public void dfs(boolean[][] flag, String s, int index, int n) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = index; j < n; ++j) {
            if (flag[index][j]) {
                ans.add(s.substring(index, j + 1));
                dfs(flag, s, j + 1, n);
                ans.remove(ans.size() - 1);
            }
        }
    }
}