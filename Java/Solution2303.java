class Solution2303 {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int last = 0;
        for (int i = 0; i < brackets.length; i++) {
            int upper = brackets[i][0], ration = brackets[i][1];
            if (income <= upper) {
                res += (income - last) * ration / 100.0;
                break;
            }
            else res += (upper - last) * ration / 100.0;
            last = upper;
        }
        return res;
    }
}