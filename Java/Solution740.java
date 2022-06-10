import java.util.*;

class Solution740 {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                sum += nums[i];
            }
            else {
                if (nums[i] - nums[i - 1] == 1) {
                    res.add(sum);
                }
                else {
                    res.add(sum);
                    res.add(0);
                }
                sum = nums[i];
            }
        }
        res.add(sum);
        int[] dp = new int[res.size()];
        dp[0] = res.get(0);
        dp[1] = Math.max(res.get(0), res.get(1));
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + res.get(i));
        }
        return dp[dp.length - 1];
    }
}