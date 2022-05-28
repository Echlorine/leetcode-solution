import java.util.*;

class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(
            boxTypes,
            new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return b[1] - a[1];
                }
            }
        );
        int res = 0, len = 0;
        for (int i = 0; len < truckSize && i < boxTypes.length; i++) {
            for (int j = 0; len < truckSize && j < boxTypes[i][0]; j++, len++) {
                res += boxTypes[i][1];
            }
        }
        return res;
    }
}