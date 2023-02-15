class Solution1234 {
    public int balancedString(String s) {
        int[][] hash = new int[s.length()][4]; // 到第 i 个位置时，每个字符的数量
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; i > 0 && j < 4; j++) {
                hash[i][j] = hash[i - 1][j];
            }
            if (s.charAt(i) == 'Q') hash[i][0]++;
            else if (s.charAt(i) == 'W') hash[i][1]++;
            else if (s.charAt(i) == 'E') hash[i][2]++;
            else hash[i][3]++;
        }
        int right = 1;
        int res = Integer.MAX_VALUE;
        for (int left = 0; left < s.length(); left++) {
            int[] diff = get_diff(left, right, hash, s);
            while (right < s.length() && (diff[0] < 0 || diff[1] < 0 || diff[2] < 0 || diff[3] < 0)) {
                right++;
                diff = get_diff(left, right, hash, s);
            }
            if (diff[0] >= 0 && diff[1] >= 0 && diff[2] >= 0 && diff[3] >= 0) res = Math.min(res, right - left);
        }
        return res;
    }

    public int[] get_diff(int start, int end, int[][] hash, String s) {
        int[] res = new int[4];
        int n = s.length() / 4;
        int q = hash[s.length() - 1][0] - (hash[end - 1][0] - (start > 0 ? hash[start - 1][0] : 0));
        int w = hash[s.length() - 1][1] - (hash[end - 1][1] - (start > 0 ? hash[start - 1][1] : 0));
        int e = hash[s.length() - 1][2] - (hash[end - 1][2] - (start > 0 ? hash[start - 1][2] : 0));
        int r = hash[s.length() - 1][3] - (hash[end - 1][3] - (start > 0 ? hash[start - 1][3] : 0));
        res[0] = n - q;
        res[1] = n - w;
        res[2] = n - e;
        res[3] = n - r;
        return res;
    }
}