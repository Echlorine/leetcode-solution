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

    public static int partion(int[] nums, int begin, int end) {
        // 分划操作算法
        int s = begin, e = end + 1;
        int k = nums[s], temp = 0;
        while (s < e){
            s++;
            while (nums[s] < k && s < end) s++;
            e--;
            while (nums[e] > k) e--;
            if (s < e) {
                temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
            }
        }
        temp = nums[e];
        nums[e] = nums[begin];
        nums[begin] = temp;
        return e;
    }
}
