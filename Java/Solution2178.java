class Solution2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        long sum = 0;
        if (finalSum % 2 == 1) return res;
        for (int i = 1; ; i++) {
            long t = 2 * i;
            if (sum + t > finalSum) {
                t = res.get(res.size() - 1) + finalSum - sum;
                res.remove(res.size() - 1);
                res.add(t);
                break;
            }
            res.add(t);
            sum += t;
        }
        return res;
    }
}