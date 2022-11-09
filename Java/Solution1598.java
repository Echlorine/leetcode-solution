class Solution1598 {
    public int minOperations(String[] logs) {
        Deque<String> stack = new ArrayDeque<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (stack.size() > 0) stack.removeLast();
            } else if (log.equals("./")) {
                continue;
            } else {
                stack.addLast(log);
            }
        }
        return stack.size();
    }
}