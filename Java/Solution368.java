import java.util.*;

class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i]表示以nums[i]结尾的最长整除子集的长度
        Arrays.sort(nums);
        // 边界
        dp[0] = 1;
        int len = dp[0];
        // dp
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            len = Math.max(len, dp[i]);
        }
        // 生成答案
        List<Integer> res = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (res.isEmpty() && dp[i] == len) {
                res.add(0, nums[i]);
                len--;
            }
            else if (!res.isEmpty() && dp[i] == len && res.get(0) % nums[i] == 0){
                res.add(0, nums[i]);
                len--;
            }
            if (len == 0) break;
        }
        return res;
    }
}