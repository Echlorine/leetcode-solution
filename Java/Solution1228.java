class Solution1228 {
    public int missingNumber(int[] arr) {
        // 确定公差
        int l = arr.length;
        int d = (arr[l - 1] - arr[0]) / (l);
        if (d == 0) return arr[0];
        // 二分查找
        int left = 0, right = l - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if (mid * d + arr[0] != arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left * d + arr[0];
    }
}