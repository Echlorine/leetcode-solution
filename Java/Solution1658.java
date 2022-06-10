class Solution1658 {
    public int minOperations(int[] nums, int x) {
        int[] presum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        int left = 1, right = nums.length;
        // 根据最小值确定右边界
        while (left < right - 1) {
            int mid = (left + right) / 2;
            int temp = minValue(presum, mid);
            if (temp > x) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        int maxlen = right;
        left = 1;
        right = nums.length;
        // 根据最大值确定左边界
        while (left < right - 1) {
            int mid = (left + right) / 2;
            int temp = maxValue(presum, mid);
            if (temp < x) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        int minlen = left;
        for (int i = minlen; i <= maxlen; i++) {
            if (isValue(presum, x, i) == 0) return i;
        }
        return -1;
    }

    public int minValue(int[] presum, int k) {
        /**
         * 记录 k 次操作数能取到的最小值
         */
        int maxsum = Integer.MIN_VALUE;
        int len = presum.length - 1 - k;
        for (int i = len; i < presum.length; i++) {
            int temp = presum[i] - presum[i - len];
            maxsum = Math.max(maxsum, temp);
        }
        return presum[presum.length - 1] - maxsum;
    }

    public int maxValue(int[] presum, int k) {
        /**
         * 记录 k 次操作数能取到的最大值
         */
        int minsum = Integer.MAX_VALUE;
        int len = presum.length - 1 - k;
        for (int i = len; i < presum.length; i++) {
            int temp = presum[i] - presum[i - len];
            minsum = Math.min(minsum, temp);
        }
        return presum[presum.length - 1] - minsum;
    }

    public int isValue(int[] presum, int x, int k) {
        /**
         * 记录 k 次操作数是否能取到目标值
         */
        int len = presum.length - 1 - k;
        for (int i = len; i < presum.length; i++) {
            int temp = presum[i] - presum[i - len];
            if (temp == presum[presum.length - 1] - x) return 0;
        }
        return -1;
    }
}