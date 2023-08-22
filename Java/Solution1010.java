class Solution1010 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : time) {
            int rest = t % 60;
            map.put(rest, map.getOrDefault(rest, 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            if (key > 0 && key < 30 && map.containsKey(60 - key)) {
                res += map.get(key) * map.get(60 - key);
            } else if (key == 30 || key == 0) {
                int t = map.get(key);
                if (t % 2 == 1) res += t * (t / 2);
                else res += t / 2 * (t - 1);
            }
        }
        return res;
    }
}