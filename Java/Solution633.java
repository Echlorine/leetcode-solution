class Solution633 {
    public boolean judgeSquareSum(int c) {
        long right = (long) Math.floor(Math.sqrt(c));
        long left = 0;
        while (left <= right) {
            if (left * left + right * right < c) {
                left++;
            }
            else if (left * left + right * right > c) {
                right--;
            }
            else return true;
        }
        return false;
    }
}