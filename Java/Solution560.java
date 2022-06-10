import java.util.*;

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        // 枚举实现
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;
    }

    public int rimarraySum(int[] nums, int k) {
        // 前缀和
        int pre = 0, res = 0;
        Map<Integer, Integer> ans = new HashMap<>();
        ans.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            res += ans.getOrDefault(pre - k, 0);
            ans.put(pre, ans.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}