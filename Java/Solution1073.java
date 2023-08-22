class Solution1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder();
        int len = Math.max(arr1.length, arr2.length) + 2;
        int[][] n = new int[len][2];
        for (int i = 0, flag = 0; i < len; i++, flag ^= 1) {
            int a = 0, b = 0;
            if (i < arr1.length) a = arr1[arr1.length - 1 - i];
            if (i < arr2.length) b = arr2[arr2.length - 1 - i];
            int t = a + b + n[i][0] + n[i][1];
            sb.append(t % 2);
            if (flag == 0) {
                if (t >= 2) {
                    n[i + 2][0] += 1;
                    n[i + 1][1] += 1;
                }
            } else {
                if (t >= 2) {
                    // 判断下一位是否大于 1
                    if (i + 1 < arr1.length) a = arr1[arr1.length - 2 - i];
                    else a = 0;
                    if (i + 1 < arr2.length) b = arr2[arr2.length - 2 - i];
                    else b = 0;
                    if (a + b + n[i + 1][0] + n[i + 1][1] < 1) {
                        n[i + 1][0] += 1;
                        n[i + 2][1] += 1;
                    } else {
                        n[i + 1][1] -= 1;
                    }
                }
            }
        }
        // 去掉前导 0
        len = sb.lastIndexOf("1");
        if (len == -1) return new int[] {0};
        int[] res = new int[len + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = sb.charAt(len - i) - '0';
        }
        return res;
    }
}