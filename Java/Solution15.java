import java.util.*;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            if (first != 0 && nums[first] == nums[first - 1]) continue;
            int second = first + 1, third = nums.length - 1;
            for (int i = first + 1; i < nums.length; i++) {
                if (second >= third) break;
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    // 避免重复
                    second++;
                    continue;
                }
                if (nums[first] + nums[second] + nums[third] < 0) {
                    second++;
                } else if (nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                } else {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[first]);
                        ans.add(nums[second]);
                        ans.add(nums[third]);
                        res.add(ans);
                        second++;
                    }
                }
            }
        return res;
    }
}