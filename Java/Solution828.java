import java.util.*;

class Solution828 {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<Integer>());
                map.get(c).add(-1);
            }
            map.get(c).add(i);
        }
        // 计算
        int res = 0;
        for (char key : map.keySet()) {
            List<Integer> list = map.get(key);
            list.add(s.length());
            for (int i = 1; i < list.size() - 1; i++) {
                int x = list.get(i) - list.get(i - 1);
                int y = list.get(i + 1) - list.get(i);
                res += x * y;
            }
        }
        return res;
    }
}