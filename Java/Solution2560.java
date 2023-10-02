class Solution {
    public int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            int count = getCount(nums, middle);
            if (count >= k) {
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return lower;
    }

    public int getCount(int[] nums, int max) {
        // 在不超过 max 情况下所能窃取的最大房屋数量
        int count = 0;
        boolean visited = false;
        for (int x : nums) {
            if (x <= max && !visited) {
                count++;
                visited = true;
            } else {
                visited = false;
            }
        }
        return count;
    }
}