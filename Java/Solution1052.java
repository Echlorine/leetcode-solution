class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int base = 0, temp = 0, sum = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 0) base += customers[i];
            else temp += customers[i];
        }
        sum = temp;
        for (int i = minutes; i < grumpy.length; i++) {
            if (grumpy[i] == 0) base += customers[i];
            else temp += customers[i];
            if (grumpy[i - minutes] != 0) temp -= customers[i - minutes];
            sum = Math.max(sum, temp);
        }
        return base + sum;
    }
}