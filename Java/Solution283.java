class Solution283 {
    public void moveZeroes(int[] nums) {
        int n = 0, index = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0) n++;
        // 移动非零元素
        for (int i = 0; i < nums.length - n; i++) {
            if (nums[i] == 0) index++; // 统计这是遇到的第几个零，从而可以将后面的数往前移
            if (nums[i] !=0 && index != 0) nums[i - index] = nums[i]; // 非零元素
        }
        for (int i = 0; i < n; i++)
            nums[nums.length - n + i] = 0;
    }

    public void two_pointers_moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
}