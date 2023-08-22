class Solution771 {
    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        for (int j = 0; j < stones.length(); j++) {
            if (set.contains(stones.charAt(j))) res++;
        }
        return res;
    }
}