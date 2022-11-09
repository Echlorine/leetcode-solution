class Solution1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length / 20;
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < len || i > arr.length - 1 -len) continue;
            res += arr[i];
        }
        return res / (arr.length - len - len);
    }
}