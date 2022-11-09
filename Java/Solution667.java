class Solution667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[];
        int start = 1, end = 1 + k;
        for (int i = 0; i <= k; i++) {
            if (i % 2 == 0) {
                a[i] = start++;
            } else {
                a[i] = end--;
            }
        }
        for (int i = k + 1; i < n) {
            a[i] = i + 1;
        }
        return res;
    }
}