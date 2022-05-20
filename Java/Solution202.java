import java.util.*;

class Solution202 {
    public boolean isHappy(int n) {
        // 从1~9计算快乐数，发现不是快乐数最后一定能算到4
        while (n != 4){
            if (n == 1) return true;
            n = happy(n);
        }
        return false;
    }

    public int happy(int h){
        int res = 0;
        List<Integer> ans = new ArrayList<>();
        while (h >= 10){
            ans.add(h % 10);
            h = (h - (h % 10)) / 10;
        }
        ans.add(h);
        for (int i = 0; i < ans.size(); i++)
            res += ans.get(i) * ans.get(i);
        return res;
    }
}
