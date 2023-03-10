class Solution137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 确定每一位的数值出现的次数
            int temp = 0;
            for (int num : nums) {
                temp += (num >> i) & 1;
            }
            if (temp % 3 == 1) res |= (1 << i); // 将结果的第 i 位设为 1
        }
        return res;
    }
}