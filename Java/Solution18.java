import java.util.*;

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue; // 去重
            for (int b = a + 1; b < nums.length; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue; // 去重
                int c = b + 1, d = nums.length - 1;
                for (int i = b + 1; i < nums.length; i++) {
                    if (c >= d) break;
                    if (c > b + 1 && nums[c] == nums[c - 1]) {
                        // 去重
                        c++;
                        continue;
                    }
                    long t = 0l + nums[a] + nums[b] + nums[c] + nums[d];
                    if (t == target) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[a]);
                        ans.add(nums[b]);
                        ans.add(nums[c]);
                        ans.add(nums[d]);
                        res.add(ans);
                        c++;
                    } else if (t < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return res;
    }
}