class Solution1093 {
    public double[] sampleStats(int[] count) {
        double mininum = -1, maxinum = 0, mean = 0, median = 0, mode = 0;
        int count_last = 0, count_sum = 0;
        long sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (mininum == -1 && count[i] != 0) mininum = i;
            if (count[i] > 0 && i > maxinum) maxinum = i;
            if (count[i] > count_last) {
                count_last = count[i];
                mode = i;
            }
            sum = sum + i * count[i];
            count_sum += count[i];
        }
        mean = (double) sum / count_sum;
        int mid = (count_sum - 1) / 2 + 1;
        int count_cur = 0;
        for (int i = 0; i < count.length; i++) {
            if (count_cur <= mid && count_cur + count[i] >= mid) {
                if (count_sum % 2 == 1) {
                    median = i;
                } else {
                    if (count_cur + count[i] >= mid + 1) {
                        median = i;
                    } else {
                        for (int j = i + 1; j < count.length; j++) {
                            if(count[j] > 0) {
                                median = i + j;
                                break;
                            }
                        }
                        median /= 2.0;
                    }
                }
                break;
            }
            count_cur += count[i];
        }
        return new double[] {mininum, maxinum, mean, median, mode};
    }
}