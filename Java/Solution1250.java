class Solution1250 {
    public boolean isGoodArray(int[] nums) {
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            last = gcd(last, nums[i]);
            if  (last == 1) return true;
        }
        return last == 1;
    }

    public int gcd(int a, int b) {
        int t1 = Math.max(a, b), t2 = Math.min(a, b);
        int d = t1 % t2;
        while (d != 0) {
            t1 = t2;
            t2 = d;
            d = t1 % t2;
        }
        return t2;
    }
}