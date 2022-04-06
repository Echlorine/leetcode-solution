class Solution287 {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        int mid = 0;
        int ans = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (left == right) break;
            ans = 0;
            for (int i = 0; i < nums.length; i++)
                if (nums[i] <= mid)
                    ans++;
            if (ans > mid) {right = mid;}
            else left = mid + 1;
        }
        return mid;
    }
}