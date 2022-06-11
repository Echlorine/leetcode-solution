public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {13, 23, 42, 88, 5, 24, 16, 5};
        ssort(nums);
        for (int i : nums)
            System.out.println(i);
    }

    public static void ssort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i], l = i;
            for (int j = i + 1; j < nums.length; j++)
                // 找到最小值
                if (nums[j] < min) {
                    min = nums[j];
                    l = j;
                }
            // 把最小值放入待排序的最前面
            if (l != i) {
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
            }
        }
    }
}
