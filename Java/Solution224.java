import java.util.*;

class Solution224 {
    public int calculate(String s) {
        Deque<String>stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') { // 弹栈，直到遇到左括号
                StringBuilder sb = new StringBuilder();
                while(!stack.peekLast().equals("("))
                    sb.insert(0, stack.removeLast());
                stack.removeLast(); // 弹出对应的左括号
                stack.addLast(cal(sb.toString()));
            }
            else if (s.charAt(i) != ' ') stack.addLast(s.substring(i, i + 1));
        }
        if (!stack.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            while(!stack.isEmpty())
                sb.insert(0, stack.removeLast());
            stack.addLast(cal(sb.toString()));
        }
        String res = stack.peekLast();
        return Integer.valueOf(res);
    }

    public String cal(String str) {
        int res = 0;
        int end = str.length() - 1; // 记录每个数字
        for (int i = end; i >= 0 ; i--) {
            if (str.charAt(i) == '+') {
                int temp = Integer.valueOf(str.substring(i + 1, end + 1));
                end = i - 1;
                res += temp;
            }
            else if (str.charAt(i) == '-') {
                if (i > 0 && str.charAt(i - 1) == '+') {
                    int temp = Integer.valueOf(str.substring(i + 1, end + 1));
                    i--;
                    end = i - 1;
                    res -= temp;
                }
                else if (i > 0 && str.charAt(i - 1) == '-') {
                    int temp = Integer.valueOf(str.substring(i + 1, end + 1));
                    i--;
                    end = i - 1;
                    res += temp;
                }
                else {
                    int temp = Integer.valueOf(str.substring(i + 1, end + 1));
                    end = i - 1;
                    res -= temp;
                }
            }
        }
        if (str.charAt(0) != '-') res += Integer.valueOf(str.substring(0, end + 1));
        return String.valueOf(res);
    }
}