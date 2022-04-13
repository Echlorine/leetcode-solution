public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {13, 23, 42, 88, 5, 24, 16, 5};
        // insertsort(nums);
        insertsortA(nums, 0, nums.length);
        for (int i : nums)
            System.out.println(i);
    }

    public static void insertsort(int[] nums) {
        // 直接插入排序
        for (int i = 1; i < nums.length; i++) {
            int k = i - 1;
            int cur = nums[i]; // 暂存当前值
            while (k >= 0 && nums[k] > cur) {
                // 比当前值大的元素后移
                nums[k + 1] = nums[k];
                k--;
            }
            // 把当前值插入合适位置
            nums[k + 1] = cur;
        }
    }

    public static void insertsortA(int[] nums, int start, int end) {
        // 改进插入排序
        // 确立哨兵
        // 正常而言，确立哨兵不需要那么麻烦，左边添加一个负无穷即可
        // 不过数组左边无法添加新元素，只能将最小值最为哨兵了
        int minv = nums[0], minl = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < minv) {
                minv = nums[i];
                minl = i;
            }
        if (minl != 0) {
            int temp = nums[minl];
            nums[minl] = temp;
            nums[0] = nums[minl];
        }
        // 插入排序
        for (int i = start + 1; i < end; i++) {
            int k = i - 1;
            int cur = nums[i]; // 暂存当前值
            while (nums[k] > cur) { // 不需要进行边界判断
                // 比当前值大的元素后移
                nums[k + 1] = nums[k];
                k--;
            }
            // 把当前值插入合适位置
            nums[k + 1] = cur;
        }
    }
}
