import java.util.*;

class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(
            costs,
            new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return (a[1] - a[0]) - (b[1] - b[0]);
                }
            }
        );
        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) res += costs[i][1];
            else res += costs[i][0];
        }
        return res;
    }
}