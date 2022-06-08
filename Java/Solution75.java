class Solution75 {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for (int index = 0; index <= two; index++) {
            int temp = nums[index];
            if (temp == 0) {
                if (index != zero) {
                    nums[index] = nums[zero];
                    nums[zero] = temp;
                }
                zero++;
            }
            else if (temp == 2) {
                nums[index] = nums[two];
                nums[two] = temp;
                two--;
                index--;
            }
        }
    }
}