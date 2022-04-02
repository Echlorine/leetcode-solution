import java.util.*;

class Solution118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        res.add(ans);
        if (numRows == 1) return res;
        for (int i = 2; i <= numRows; i++){
            ans = yanghui(i, ans);
            res.add(ans);
        }
        return res;
    }

    public static List<Integer> yanghui(int n, List<Integer> p){
        // n是当前计算的层数，p是上一层的值
        List<Integer> r = new ArrayList<>(); // 当前层的值
        r.add(1);
        for (int i = 0; i < p.size() - 1; i++)
            r.add(p.get(i) + p.get(i + 1));
        r.add(1);
        return r;
    }
}