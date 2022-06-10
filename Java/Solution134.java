class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int len = cost.length;
        while (index < len) {
            int sumgas = 0, sumcost = 0;
            for (int i = 0; i < len; i++) {
                int temp = (index + i) % len;
                sumgas += gas[temp];
                sumcost += cost[temp];
                if (i == len - 1 && sumgas >= sumcost) return index;
                if (sumgas < sumcost) {
                    if (temp + 1 <= index) return -1;
                    index = temp + 1;
                    break;
                }
            }
        }
        return -1;
    }
}