/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution277 extends Relation {
    public int findCelebrity(int n) {
        // 找到出度为0，入度为n - 1的结点
        int[][] A = new int[n][n];
        int[] out = new int[n];
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    A[i][j] = 1;
                    // 统计初度和入度
                    out[i]++;
                    in[j]++;
                } else if (i != j) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (out[i] == 0 && in[i] == n - 1) return i;
        }
        return -1;
    }
}

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

class Solution extends Relation {
    public int findCelebrity(int n) {
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (knows(i,j)) i = j;
        }
        // 验证 i 是否为名人
        for (int t = i + 1; t < n; t++) {
            if (!knows(t, i)) return -1;
        }
        for (int t = 0; t < i; t++) {
            if (!knows(t, i)) return -1;
            if (knows(i, t)) return -1;
        }
        return i;
    }
}