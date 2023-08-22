class Solution2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = -1;
        for (int num : nums) {
            if (set.contains(0 - num)) {
                res = Math.max(res, Math.abs(num));
            }
        }
        return res;
    }
}