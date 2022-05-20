class Solution400 {
    public int findNthDigit(int n) {
        int i = 0;
        while (i < 8) {
            if (count(i) < n && count(i + 1) >= n) break;
            i++;
        }
        int res = n - count(i);
        int begin = 1;
        for (int j = 0; j < i; j++) {
            begin *= 10;
        }
        int j = 0;
        while (true) {
            if ((i + 1) * j < res && (i + 1) * (j + 1) >= res) break;
            j++;
        }
        int num = begin + j;
        int index = res - j * (i + 1);
        return Digit(num, index);
    }

    public int count(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {
                temp *= 10;
            }
            sum += 9 * temp * (i + 1);
        }
        return sum;
    }

    public int Digit(int num, int index) {
        String str = String.valueOf(num);
        return str.charAt(index - 1) - '0';
    }
}