import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {13, 23, 42, 88, 5, 24, 16, 5};
        // quicksort(nums, 0, nums.length - 1);
        qsort(nums);
        for (int i : nums)
            System.out.println(i);
    }

    public static void quicksort(int[] nums, int begin, int end) {
        // 递归快速排序
        int j = 0;
        if (begin < end){
            j = partion(nums, begin, end);
            quicksort(nums, begin, j - 1);
            quicksort(nums, j + 1, end);
        }
    }

    public static void qsort(int[] nums) {
        // 非递归快速排序
        Stack<int[]> s = new Stack<>();
        int begin = 0, end = nums.length - 1;
        // 初始化堆栈
        s.push(new int[] {begin, end});
        // 利用栈实现递归
        while (!s.isEmpty()) {
            begin = s.peek()[0]; end = s.peek()[1];
            s.pop();
            if (begin < end){
                int j = partion(nums, begin, end);
                s.push(new int[] {begin, j - 1});
                s.push(new int[] {j + 1, end});
            }
        }
    }

    public static int partion(int[] nums, int l, int r) {
        // 分划操作算法，左右交换
        int pivot = l; // 待确定位置的元素
        while (l < r) {
            while (l < r && nums[r] >= nums[pivot])
                r--;
            while (l < r && nums[l] <= nums[pivot])
                l++;
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        int temp = nums[r];
        nums[r] = nums[pivot];
        nums[pivot] = temp;
        return r;
    }
}
