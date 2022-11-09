class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        int last = 1;
        for (int i = 0; i < target.length && last <= n; i++) {
            int t = target[i];
            while (last < t) {
                res.add("Push");
                res.add("Pop");
                last++;
            }
            res.add("Push");
            last++;
        }
        return res;
    }
}