import java.util.*;

class Solution856 {
    public int scoreOfParentheses(String s) {
        Deque<String> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int t = 0;
                if (!stack.isEmpty() && stack.peekLast().equals("(")) {
                    t = 1;
                    stack.removeLast();
                } else {
                    while (!stack.isEmpty()) {
                        String temp = stack.removeLast();
                        if (!temp.equals("(")) {
                            t += Integer.valueOf(temp) - 0;
                        } else {
                            break;
                        }
                    }
                    t *= 2;
                }
                if (stack.isEmpty()) {
                    res += t;
                } else {
                    stack.addLast(String.valueOf(t));
                }
            }
            else {
                stack.addLast(s.substring(i, i + 1));
            }
        }
        return res;
    }
}