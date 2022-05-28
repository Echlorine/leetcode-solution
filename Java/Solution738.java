class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        String target = String.valueOf(n);
        int[] nums = new int[target.length()];
        int index = target.length();
        for (int i = 0; i < target.length(); i++) {
            nums[i] = target.charAt(i) - '0';
            if (i > 0 && nums[i] < nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index < target.length()) nums[index]--;
        while (index < target.length() && index > 0 && nums[index - 1] > nums[index]) {
            nums[--index]--;
        }
        for (int i = index + 1; i < target.length(); i++)
            nums[i] = 9;
        return res(nums);
        
    }

    public int res(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            res = res * 10 + nums[i];
        return res;
    }
}