import java.util.ArrayList;
import java.util.List;

class Solution267 {
    private char odd;
    private List<String> res;

    public List<String> generatePalindromes(String s) {
        res = new ArrayList<String>();
        // 统计每个字符的数量
        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        boolean flag = true;
        for (int count : counts) {
            if (count % 2 == 1) {
                if (flag) {
                    flag = false;
                } else {
                    return res;
                }
            }
        }
        // 把所有元素放入暂存集合
        int index = 0;
        odd = '#';
        char[] cArray = new char[s.length() / 2];
        boolean[] visited = new boolean[s.length() / 2];
        for (int i = 0; i < counts.length; i++) {
            char c = (char) (i + 'a');
            // 找到那个数量为奇数的字符
            if (counts[i] % 2 == 1) {
                odd = c;
            }
            for (int k = 0; k < counts[i] / 2; k++, index++) {
                cArray[index] = c;
            }
        }
        // 回溯生成所有可能的值
        dfs(cArray, new ArrayList<Character>(), visited);
        return res;
    }

    public void dfs(char[] cArray, List<Character> ans, boolean[] visited) {
        if (ans.size() == cArray.length) {
            // 处理答案
            StringBuilder sb = new StringBuilder();
            for (char c : ans) {
                sb.append(c);
            }
            if (odd == '#') {
                res.add(sb.toString() + sb.reverse().toString());
            } else {
                res.add(sb.toString() + odd + sb.reverse().toString());
            }
        }
        for (int i = 0; i < cArray.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && cArray[i] == cArray[i - 1] && !visited[i - 1]) continue;
            // 访问当前值
            visited[i] = true;
            ans.add(cArray[i]);
            dfs(cArray, ans, visited);
            // 回溯
            visited[i] = false;
            ans.remove(ans.size() - 1);
        }
    }
}