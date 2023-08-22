class Solution150 {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>() {{
            add("+");
            add("-");
            add("*");
            add("/");
        }};
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (operators.contains(s)) {
                int a = stack.pop();
                int b = stack.pop();
                int t = 0;
                switch (s) {
                    case "+":
                        t = b + a;
                        break;
                    case "-":
                        t = b - a;
                        break;
                    case "*":
                        t = b * a;
                        break;
                    case "/":
                        t = b / a;
                        break;
                }
                stack.push(t);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.poll();
    }
}