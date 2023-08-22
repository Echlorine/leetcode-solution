class Solution2423 {
    public boolean equalFrequency(String word) {
        int[] freqs = new int[26];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            freqs[index]++;
        }
        for (int freq : freqs) {
            if (freq == 0) continue;
            map.put(freq, map.getOrDefault(freq, 0) + 1);
        }
        if (map.size() > 2) return false;
        if (map.size() == 1) return map.containsKey(1) || map.containsValue(1);
        int key1 = 0, key2 = 0;
        for (int key : map.keySet()) {
            if (key == 1 && map.get(key) == 1) return true;
            if (key1 == 0) {
                key1 = key;
                continue;
            }
            if (key2 == 0) key2 = key;
        }
        return (key2 - key1 == 1 && map.get(key2) == 1) || (key1 - key2 == 1 && map.get(key1) == 1);
    }
}