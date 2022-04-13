public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {13, 23, 42, 88, 5, 24, 16, 5};
        heapsort(nums, nums.length);
        for (int i : nums)
            System.out.println(i);
    }

    public static void heapsort(int[] nums, int len) {
        // 建立初始堆
        for (int i = len / 2; i >= 1; i--)
            restore(nums, i, len);
        // 进行堆排序
        for (int i = len; i >= 2; i--) {
            int temp = nums[0];
            nums[0] = nums[i - 1];
            nums[i - 1] = temp;
            restore(nums, 1, i - 1);
        }
    }

    public static void restore(int[] nums, int root, int len) {
        // 利用最大堆进行排序，需要注意数组的下标与堆结点下标的之间相差 1
        int p = root; // 堆的根结点
        int m = 0, temp = 0;
        while (p <= len / 2) {
            // 比较当前结点的左右孩子的大小
            if (2 * p + 1 <= len && nums[2 * p - 1] < nums[2 * p])
                m = 2 * p +1;
            else m = 2 * p;
            // 判断孩子结点与父节点是否需要交换位置
            if (nums[m - 1] > nums[p - 1]) {
                temp = nums[m - 1];
                nums[m - 1] = nums[p - 1];
                nums[p - 1] = temp;
                p = m;
            }
            else break;
        }
    }
}
