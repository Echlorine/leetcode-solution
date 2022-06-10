import java.util.*;

class Solution394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<String> ans = new Stack<>(); // 存放左括号的位置
        // 从左到右遍历s
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']')
                ans.add(s.substring(i, i + 1));
            else {
                // 遇到右括号，弹栈
                StringBuilder temp = new StringBuilder(), num = new StringBuilder();
                String t = ans.pop();
                while (!t.equals("[")) {
                    temp.insert(0, t);
                    t = ans.pop();
                }
                while(!ans.isEmpty() && Character.isDigit(ans.peek().charAt(0)))
                    num.insert(0, ans.pop());
                int n = Integer.valueOf(num.toString());
                t = temp.toString();
                for (int j = 1; j < n; j++)
                    temp.append(t);
                ans.push(temp.toString());
            }
        }
        while (!ans.isEmpty())
            res.insert(0, ans.pop());
        return res.toString();
    }
}