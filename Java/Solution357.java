class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        int[] res = new int[9];
        res[0] = 1;
        res[1] = res[0] + 9;
        for (int i = 2; i <= 8; i++) {
            res[i] = res[i - 1];
            int temp = 9;
            for (int j = 1; j < i; j++)
                temp *= 10 - j;
            res[i] += temp;
        }
        return res[n];
    }
}