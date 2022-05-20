import java.util.*;

class Solution354 {
    public int dpmaxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,
                    new Comparator<int[]>() {
                        public int compare(int[] a, int[] b) {
                            return a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0];
                        }
                    });
        int[] dp = new int[envelopes.length]; // 包含当前结点的最长子序列的长度
        int res = 1;
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1])
                    if (dp[j] + 1 > dp[i])
                        dp[i] = dp[j];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,
                    new Comparator<int[]>() {
                        public int compare(int[] a, int[] b) {
                            return a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0];
                        }
                    });
        int[] len = new int[envelopes.length + 1]; // len[j] 表示前 i 个元素可以组成的长度为 j 的最长严格递增子序列的末尾元素的最小值
        len[0] = 0; len[1] = envelopes[0][1]; // 初始化
        int res= 1;
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > len[res]) {
                res++;
                len[res] = envelopes[i][1];
            }
            else {
                len[binaryserarch(len, res, envelopes[i][1])] = envelopes[i][1];
            }
        }
        return res;
    }

    public int binaryserarch(int[] len, int end, int target) {
        int left = 0;
        int right = end;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (len[mid] < target)
                left = mid;
            else
                right = mid;
        }
        return left + 1;
    }
}