public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {13, 23, 42, 88, 5, 24, 16, 5};
        // bubblesort(nums);
        bubblesortA(nums, nums.length - 1);
        for (int i : nums)
            System.out.println(i);
    }

    public static void bubblesort(int[] nums) {
        // 冒泡排序
        for (int i = nums.length - 1; i >= 1; i--)
            for (int j = 0; j <= i - 1; j++)
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
    }

    public static void bubblesortA(int[] nums, int loc) {
        // 改进的冒泡排序
        int bound = loc; //每趟冒泡关键词比较的终止位置
        // 冒泡排序
        while (bound != 0) { 
            int t = 0; //每趟冒泡记录交换的最后位置
            for (int j = 0; j <= bound - 1; j++)
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    t = j;
                }
            bound = t;
        }
    }
}
