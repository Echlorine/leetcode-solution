class Solution624 {
    public int maxDistance(List<List<Integer>> arrays) {
        // 找到最小的值和行数，最大的值和行数
        int minValue = Integer.MAX_VALUE, minLine = -1;
        int maxValue = Integer.MIN_VALUE, maxLine = -1;
        int secondMin = Integer.MAX_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.size(); i++) {
            int min = arrays.get(i).get(0);
            int max = arrays.get(i).get(arrays.get(i).size() - 1);
            if (min < minValue) {
                secondMin = minValue;
                minValue = min;
                minLine = i;
            } else if (min < secondMin) {
                secondMin = min;
            }
            if (max > maxValue) {
                secondMax = maxValue;
                maxValue = max;
                maxLine = i;
            } else if (max > secondMax) {
                secondMax = max;
            }
        }
        if (minLine != maxLine) return maxValue - minValue;
        return Math.max(secondMax - minValue, maxValue - secondMin);
    }
}