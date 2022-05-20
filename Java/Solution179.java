class Solution179 {
    public String largestNumber(int[] nums) {
        // 对数组按照一定规则从大到小排序
        quicksort(nums, 0, nums.length - 1);
        if (nums[0] == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(String.valueOf(nums[i]));
        }
        return sb.toString();
    }

    public void quicksort(int[] nums, int begin, int end) {
        // 快排
        if (begin < end) {
            int j = partion(nums, begin, end);
            quicksort(nums, begin, j - 1);
            quicksort(nums, j + 1, end);
        }
    }

    public int partion(int[] nums, int lk, int rk) {
        // 分划操作
        int pivot = lk;
        while (lk < rk) {
            while (lk < rk && compare(nums[rk], nums[pivot]) <= 0) rk--;
            while (lk < rk && compare(nums[lk], nums[pivot]) >= 0) lk++;
            if (lk < rk) {
                int temp = nums[rk];
                nums[rk] = nums[lk];
                nums[lk] = temp;
            }
        }
        int temp = nums[rk];
        nums[rk] = nums[pivot];
        nums[pivot] = temp;
        return rk;
    }

    public int compare(int num1, int num2) {
        /**
         * 返回值 > 0 代表num1 > num2
         * 返回值 < 0 代表num1 < num2
         * 返回值 = 0 代表num1 = num2
        */
        if (num1 == num2) return 0;
        String s1 = String.valueOf(num1) + String.valueOf(num2);
        String s2 = String.valueOf(num2) + String.valueOf(num1);
        // return s1.compareTo(s2);
        for (int i = 0; i < s1.length(); i++) {
            int temp = s1.charAt(i) - s2.charAt(i);
            if (temp != 0) return temp;
        }
        return 0;
    }
}