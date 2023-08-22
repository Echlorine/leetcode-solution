class Solution2475 {
    public int unequalTriplets(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    for (int k = j + 1; k < nums.length; k++) {
                        if (!set.contains(nums[k])) res++;
                    }
                    set.remove(nums[j]);
                }
            }
        }
        return res;
    }
}