import java.util.*;

class Solution679 {

    private boolean flag = false;
    static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<Double>();
        for (int card : cards) {
            list.add((double) card);
        }
        dfs(list);
        return flag;
    }

    public void dfs(List<Double> list) {
        if (list.size() == 0) return;
        if (list.size() == 1 && Math.abs(list.get(0) - 24) < EPSILON) {flag = true; return;}
        for (int i = 0; i < list.size(); i++) { // 选择第一个数
            for (int j = 0; j < list.size(); j++) { // 选择第二个数
                if (i == j) continue;
                List<Double> list2 = new ArrayList<Double>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j)
                        list2.add(list.get(k));
                }
                for (int k = 0; k < 4; k++) { // 选操作符
                    if (k < 2 && i > j) continue; // 剪枝，对于 '+'，'*'操作符而言，顺序不影响结果
                    if (k == 0) list2.add(list.get(i) + list.get(j));
                    if (k == 1) list2.add(list.get(i) * list.get(j));
                    if (k == 2) list2.add(list.get(i) - list.get(j));
                    if (k == 3) {
                        if (Math.abs(list.get(j)) < EPSILON)
                            continue;
                        else
                            list2.add(list.get(i) / list.get(j));
                    }
                    dfs(list2);
                    if (flag) return; // 一能算出来结果就无需继续执行
                    list2.remove(list2.size() - 1); // 回溯
                }
            }
        }
    }
}