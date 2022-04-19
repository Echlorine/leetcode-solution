import java.util.*;

class Solution301 {

    private boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            }
            else if (str.charAt(i) == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int lremove = 0, rremove = 0;
        // 统计需要删除的括号数量
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') lremove++;
            if (s.charAt(i) == ')') {
                if (lremove != 0) lremove--;
                else rremove++;
            }
        }
        removeParentheses(res, s, 0, lremove, rremove);
        return res;
    }

    public void removeParentheses(List<String> res, String str, int index, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) res.add(str);
            return;
        }
        for (int i = index; i < str.length(); i++) {
            // 剪枝，"(((())"情况只需要去掉任意一个左边的左括号
            if (i != index && str.charAt(i) == str.charAt(i - 1))
                continue;
            // 剪枝，如果剩余的字符无法满足去掉的数量要求，")(("情况
            if (lremove + rremove > str.length() - i)
                return;
            if (lremove > 0 && str.charAt(i) == '(')
                removeParentheses(res, str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
            if (rremove > 0 && str.charAt(i) == ')')
                removeParentheses(res, str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
        }
    }
}