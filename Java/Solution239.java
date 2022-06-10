import java.util.*;

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // 优先队列，并实现了Comparator接口，按照数值大小排序
        PriorityQueue<int[]> ans =
        new PriorityQueue<int[]>(
            new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] != b[0] ? b[0] - a[0] : b[1] - a[1];
                }
            }
        );
        for (int i = 0; i < k; i++)
            ans.offer(new int[]{nums[i], i});
        res[0] = ans.peek()[0];
        for (int i = 1; i < nums.length - k + 1; i++) {
            while (!ans.isEmpty() && ans.peek()[1] < i)
                ans.poll();
            ans.offer(new int[]{nums[i + k - 1], i + k - 1});
            res[i] = ans.peek()[0];
        }
        return res;
    }
}