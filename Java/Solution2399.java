class Solution2399 {
    public boolean checkDistances(String s, int[] distance) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] dis = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (map.containsKey(c)) {
                dis[c] = i - map.get(c) - 1;
            } else {
                map.put(c, i);
            }
        }
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] != distance[i] && map.containsKey(i)) return false;
        }
        return true;
    }
}