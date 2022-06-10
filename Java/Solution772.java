import java.util.*;

class Solution772 {
    public int calculate(String s) {
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                int temp = 0;
                while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                    temp = temp * 10 + s.charAt(i) - '0';
                    i++;
                }
                // 入栈之前先判断能不能入栈
                if (!stack.isEmpty()) {
                    if (stack.peekLast().equals("*")) {
                        stack.removeLast();
                        temp *= Integer.valueOf(stack.removeLast());
                    }
                    else if (stack.peekLast().equals("/")) {
                        stack.removeLast();
                        temp = Integer.valueOf(stack.removeLast()) / temp;
                    }
                }
                stack.addLast(String.valueOf(temp));
                i--;
            }
            else {
                if (s.charAt(i) == '(' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                    stack.addLast(String.valueOf(s.charAt(i)));
                }
                else if (s.charAt(i) == '-') {
                    stack.addLast(String.valueOf(-1));
                    stack.addLast("*");
                }
                else if (s.charAt(i) == ')') { // 弹栈处理
                    int temp = 0;
                    while(!stack.isEmpty() && !stack.peekLast().equals("(")) {
                        temp += Integer.valueOf(stack.removeLast());
                    }
                    stack.removeLast();
                    // 入栈之前先判断能不能入栈
                    if (!stack.isEmpty()) {
                        if (stack.peekLast().equals("*")) {
                            stack.removeLast();
                            temp *= Integer.valueOf(stack.removeLast());
                        }
                        else if (stack.peekLast().equals("/")) {
                            stack.removeLast();
                            temp = Integer.valueOf(stack.removeLast()) / temp;
                        }
                    }
                    stack.addLast(String.valueOf(temp));
                }
            }
            i++;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += Integer.valueOf(stack.removeLast());
        }
        return res;
    }
}