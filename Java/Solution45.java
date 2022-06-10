class Solution45 {
    public int jump(int[] nums) {
        int res = 0;
        int arrival = 0;
        int index = 0;
        while(index < nums.length - 1) {
            res++;
            int border = index + nums[index];
            if (border >= nums.length - 1) break;
            for (int i = index + 1; i <= border; i++) {
                if (i + nums[i] > arrival) {
                    arrival = i + nums[i];
                    index = i;
                }
            }
        }
        return res;
    }
}