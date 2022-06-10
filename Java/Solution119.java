import java.util.*;

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>() {{
            add(1);
        }};
        for (int i = 1; i <= rowIndex; i++) { // 处理第 i 行
            // 依次更新从右边界到左边界的值
            for (int j = i - 1; j > 0; j--) {
                int temp = res.get(j) + res.get(j - 1);
                    res.set(j, temp);
            }
            res.add(1);
        }
        return res;
    }
}