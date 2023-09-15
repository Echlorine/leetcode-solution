class LCR50 {
    public int giveGem(int[] gem, int[][] operations) {
        // 模拟
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] o : operations) {
            int t = gem[o[0]] / 2;
            gem[o[0]] -= t;
            gem[o[1]] += t;
        }
        for (int g : gem) {
            if (g > max) max = g;
            if (g < min) min = g;
        }
        return max - min;
    }
}