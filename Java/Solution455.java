import java.util.*;

class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; i++, j++) {
            while (j < s.length && s[j] < g[i])
                j++;
            if (j < s.length)
                res++;
        }
        return res;
    }
}