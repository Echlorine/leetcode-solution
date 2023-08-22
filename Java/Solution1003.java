class Solution1003 {
    public boolean isValid(String s) {
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'c') {
                if (stack.isEmpty() || !stack.pop().equals("ab")) return false;
            } else if (c == 'b') {
                if (stack.isEmpty() || !stack.pop().equals("a")) return false;
                else stack.push("ab");
            } else {
                stack.push("a");
            }
        }
        return stack.isEmpty();
    }
}