class Solution439 {
    public String parseTernary(String expression) {
        Deque<Boolean> s1 = new ArrayDeque<>(); // 标记真值
        Deque<Character> s2 = new ArrayDeque<>(); // 标记字符
        Deque<Integer> n = new ArrayDeque<>(); // 标记数量
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '?') {
                s1.push(expression.charAt(i - 1) == 'T');
                n.push(0);
            } else if (expression.charAt(i) == ':') {
                if (expression.charAt(i - 2) == '?') {
                    s2.push(expression.charAt(i - 1));
                    n.push(n.pop() + 1);
                }
                if (i + 2 == expression.length() || expression.charAt(i + 2) == ':') {
                    // 弹栈，计算部分三元表达式的值
                    n.pop();
                    boolean flag = s1.pop();
                    char t = s2.pop();
                    s2.push(flag ? t : expression.charAt(i + 1));
                    while (!n.isEmpty() && n.peek() == 1) {
                        n.pop();
                        flag = s1.pop();
                        char t2 = s2.pop();
                        t = s2.pop();
                        s2.push(flag ? t : t2);
                    }
                    if (!n.isEmpty()) n.push(n.pop() + 1);
                }
            }
        }
        while (!n.isEmpty() && n.peek() == 1) {
            n.pop();
            boolean flag = s1.pop();
            char c1 = s2.pop();
            char c2 = s2.pop();
            s2.push(flag ? c2 : c1);
        }
        return String.valueOf(s2.pop());
    }
}