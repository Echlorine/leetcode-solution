import java.util.*;

class Solution784 {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new LinkedList<>();
        dfs(res, s, 0, s);
        return res;
    }

    public void dfs(List<String> res, String s, int index, String str) {
        if (index == s.length()) {res.add(str); return;}
        if (s.charAt(index) >= '0' && s.charAt(index) <= '9')
            dfs(res, s, index + 1, str); // 数字不需要比较
        if (s.charAt(index) >= 'a' && s.charAt(index) <= 'z') {// 小写改大写
            char temp = (char) (s.charAt(index) - 32);
            dfs(res, s, index + 1, str.substring(0, index) + String.valueOf(temp) + str.substring(index + 1, s.length()));
            dfs(res, s, index + 1, str);
        }
        if (s.charAt(index) >= 'A' && s.charAt(index) <= 'Z') {// 大写改小写
            char temp = (char) (s.charAt(index) + 32);
            dfs(res, s, index + 1, str.substring(0, index) + String.valueOf(temp) + str.substring(index + 1, s.length()));
            dfs(res, s, index + 1, str);
        }
    }
}