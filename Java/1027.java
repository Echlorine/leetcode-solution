import java.util.*;

class Solution1027 {
    public int longestArithSeqLength(int[] nums) {
        // 哈希超时
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>(); // 记录每一个以该结点结尾的最大长度
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp;
            if (map.containsKey(nums[i])) temp = map.get(nums[i]);
            else temp = new LinkedList<Integer>();
            temp.add(i);
            map.put(nums[i], temp);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                List<Integer> indix = map.getOrDefault(2 * nums[j] - nums[i], new LinkedList<Integer>());
                for (int index : indix) {
                    if (index != -1 && index < j) {
                        int cand = dp.getOrDefault(index * nums.length + j, 2) + 1;
                        dp.put(j * nums.length + i, cand);
                        res = Math.max(res, cand);
                    }
                }
            }
        }
        return res >= 3 ? res : 2;
    }

    public int dplongestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][1001];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j];
                dp[i][d + 500] = dp[j][d + 500] + 1;
                res = Math.max(res, dp[i][d + 500]);
            }
        }
        return res + 1;
    }
}