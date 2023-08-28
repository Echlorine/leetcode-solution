class Solution484 {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        int t = 1, index = 0;
        stack.push(1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                while(!stack.isEmpty()) {
                    res[index++] = stack.pop();
                }
            } 
            stack.push(++t);
        }
        while(!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }
}