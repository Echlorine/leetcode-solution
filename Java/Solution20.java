class Solution20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(){{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        
        if (s.length() % 2 == 1) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '{' || temp == '[') {
                // 左括号入栈
                stack.addLast(temp);
            } else if (temp == ')' || temp == '}' || temp == ']') {
                // 遇到右括号则弹出栈顶元素
                if (stack.size() == 0) return false;
                char t = stack.removeLast();
                if (map.get(t) == temp) continue;
                else return false;
            }
        }
        // 栈为空则匹配成功
        return stack.size() == 0;
    }
}