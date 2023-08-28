class Solution1133 {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = -1;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) res = Math.max(res, key);
        }
        return res;
    }
}