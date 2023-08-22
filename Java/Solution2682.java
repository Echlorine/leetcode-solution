class Solution2682 {
    public int[] circularGameLosers(int n, int k) {
        int[] nums = new int[n];
        int index = 1;
        int l = n;
        for (int i = 1; nums[index - 1] < 2; i++) {
            if (nums[index - 1] == 0) l--;
            if (++nums[index - 1] == 2) break;
            index = (i * k + index) % n;
            if (index == 0) index = n;
        }
        int[] res = new int[l];
        for (int i = 1, j = 0; i <= n; i++) {
            if (nums[i - 1] == 0) res[j++] = i; 
        }
        return res;
    }
}