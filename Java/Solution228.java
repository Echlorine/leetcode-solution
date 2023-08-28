class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int first = nums[0], last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last != 1) {
                if (last == first) res.add(String.valueOf(last));
                else res.add(first + "->" + last);
                first = nums[i];
            }
            last = nums[i];
        }
        if (last == first) res.add(String.valueOf(last));
        else res.add(first + "->" + last);
        return res;
    }
}