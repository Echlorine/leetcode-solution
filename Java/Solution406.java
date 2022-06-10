import java.util.*;

class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][];
        int loc = 0;
        // 排序
        Arrays.sort(
            people,
            new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
                }
            }
        );
        for (int i = 0; i < people.length; i++) {
            loc = people[i][1] + 1;
            int j = 0, k = -1;
            while (j < loc) {
                k++;
                if (res[k] == null) j++;
            }
            res[k] = people[i];
        }
        return res;
    }
}