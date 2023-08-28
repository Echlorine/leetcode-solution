class Solution266 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) % 2 == 1) {
                res++;
            } else  {
                res--;
            }
        }
        return res <= 1;
    }
}