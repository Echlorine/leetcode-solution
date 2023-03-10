class Solution2347 {
    public String bestHand(int[] ranks, char[] suits) {
        int[] hash = new int[17];
        for (int i = 0; i < ranks.length; i++) {
            hash[ranks[i] - 1]++;
            hash[13 + suits[i] - 'a']++;
        }
        int num = 0;
        for (int i = 17; i >= 1; i--) {
            if (i > 13) {
                if (hash[i - 1] == 5) return "Flush";
            } else {
                num = Math.max(num, hash[i - 1]);
            }
        }
        if (num >= 3) return "Three of a Kind";
        else if (num == 2) return "Pair";
        return "High Card";
    }
}