class Solution1056 {
    public boolean confusingNumber(int n) {
        Map<Integer, Integer> map = new HashMap<>(){{
            put(0, 0);
            put(1, 1);
            put(6, 9);
            put(8, 8);
            put(9, 6);
        }};
        int res = 0;
        int src = n;
        while(src > 0) {
            int t = src % 10;
            if (!map.containsKey(t)) return false;
            res = res * 10 + map.get(t);
            src /= 10;
        }
        return res != n;
    }
}