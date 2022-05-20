class Solution189 {
    public void rotate(int[] nums, int k) {
        int diff = k % nums.length;
        if (diff == 0) return;
        int count = 0;
        for (int j = 0; count < nums.length; j++) {
            int temp1 = 0; // temp1存储要被替换的原值
            int temp2 = nums[j]; // temp2存储要被替换的原值
            for (int i = j + diff; count < nums.length; i = (i + diff) % nums.length) {
                temp1 = nums[i % nums.length];
                nums[i % nums.length] = temp2;
                temp2 = temp1;
                count++;
                if (i == j) break;
            }
        }
    }
}