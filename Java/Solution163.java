import java.util.*;

class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        StringBuilder build = new StringBuilder();
        if (nums.length == 0) {
            // 特例
            build.delete(0, build.length());
            build.append(Integer.toString(lower));
            if (upper > lower) {
                build.append("->");
                build.append(Integer.toString(upper));
            }
            res.add(build.toString());
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            build.delete(0, build.length());
            if (i == 0 && nums[i] != lower) {
                build.append(Integer.toString(lower));
                if (nums[i] - lower > 1) {
                    build.append("->");
                    build.append(Integer.toString(nums[i] - 1));
                }
                res.add(build.toString());
            }
            if (i > 0 && nums[i] - nums[i - 1] > 1) {
                build.append(Integer.toString(nums[i - 1] + 1));
                if (nums[i] - nums[i - 1] > 2) {
                    build.append("->");
                    build.append(Integer.toString(nums[i] - 1));
                }
                res.add(build.toString());
            }
        }
        if (nums[nums.length - 1] != upper) {
            build.delete(0, build.length());
            build.append(Integer.toString(upper));
            if (upper - nums[nums.length - 1] > 1) {
                build.insert(0, "->");
                build.insert(0, Integer.toString(nums[nums.length - 1] + 1));
            }
            res.add(build.toString());
        }
        return res;
    }
}