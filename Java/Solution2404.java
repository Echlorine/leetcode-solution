class Solution2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0, cnt = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > cnt) {
                res = key;
                cnt = map.get(key);
            }
            else if (map.get(key) == cnt && key < res) {
                res = key;
            }
        }
        return cnt == 0 ? -1 : res;
    }
}