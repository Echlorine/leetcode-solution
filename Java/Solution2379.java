class Solution2379 {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int num = 0; // 白色砖块的数量
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') num++;
        }
        res = num;
        for (int right = k; right < blocks.length(); right++, left++) {
            char r = blocks.charAt(right);
            char l = blocks.charAt(left);
            if (r == 'W') num++;
            if (l == 'W') num--;
            res = Math.min(res, num);
        }
        return res;
    }
}