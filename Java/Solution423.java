import java.util.HashMap;
import java.util.Map;

class Solution423 {
    public String originalDigits(String s) {
        // 计数
        Map<Character, Integer> map = new HashMap<>(){{
            put('e', 0); put('g', 1); put('f', 2); put('i', 3); put('h', 4);
            put('o', 5); put('n', 6); put('s', 7); put('r', 8); put('u', 9);
            put('t', 10); put('w', 11); put('v', 12); put('x', 13); put('z', 14);
        }};
        int[] counts = new int[map.size()];
        for (int i = 0; i < s.length(); i++) {
            counts[map.get(s.charAt(i))]++;
        }
        // 处理特例
        Map<Integer, Integer> all = new HashMap<>();
        deleteFirst(map, counts, all);
        deleteSecond(map, counts, all);
        deleteThird(map, counts, all);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < all.getOrDefault(i, 0); j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public void deleteFirst(Map<Character, Integer> map, int[] counts, Map<Integer, Integer> all) {
        if (counts[map.get('z')] > 0) { // 有 'z' 说明有 0
            all.put(0, counts[map.get('z')]);
            counts[map.get('e')] -= counts[map.get('z')];
            counts[map.get('r')] -= counts[map.get('z')];
            counts[map.get('o')] -= counts[map.get('z')];
        }
        if (counts[map.get('w')] > 0) { // 有 'w' 说明有 2
            all.put(2, counts[map.get('w')]);
            counts[map.get('t')] -= counts[map.get('w')];
            counts[map.get('o')] -= counts[map.get('w')];
        }
        if (counts[map.get('u')] > 0) { // 有 'u' 说明有 4
            all.put(4, counts[map.get('u')]);
            counts[map.get('o')] -= counts[map.get('u')];
            counts[map.get('f')] -= counts[map.get('u')];
            counts[map.get('r')] -= counts[map.get('u')];
        }
        if (counts[map.get('x')] > 0) { // 有 'x' 说明有 6
            all.put(6, counts[map.get('x')]);
            counts[map.get('s')] -= counts[map.get('x')];
            counts[map.get('i')] -= counts[map.get('x')];
        }
        if (counts[map.get('g')] > 0) { // 有 'g' 说明有 8
            all.put(8, counts[map.get('g')]);
            counts[map.get('e')] -= counts[map.get('g')];
            counts[map.get('i')] -= counts[map.get('g')];
            counts[map.get('h')] -= counts[map.get('g')];
            counts[map.get('t')] -= counts[map.get('g')];
        }
    }

    public void deleteSecond(Map<Character, Integer> map, int[] counts, Map<Integer, Integer> all) {
        if (counts[map.get('o')] > 0) { // 有 'o' 说明有 1
            all.put(1, counts[map.get('o')]);
            counts[map.get('n')] -= counts[map.get('o')];
            counts[map.get('e')] -= counts[map.get('o')];
        }
        if (counts[map.get('h')] > 0) { // 有 'h' 说明有 3
            all.put(3, counts[map.get('h')]);
            counts[map.get('t')] -= counts[map.get('h')];
            counts[map.get('r')] -= counts[map.get('h')];
            counts[map.get('e')] -= 2 * counts[map.get('h')];
        }
        if (counts[map.get('f')] > 0) { // 有 'f' 说明有 5
            all.put(5, counts[map.get('f')]);
            counts[map.get('i')] -= counts[map.get('f')];
            counts[map.get('v')] -= counts[map.get('f')];
            counts[map.get('e')] -= counts[map.get('f')];
        }
        if (counts[map.get('s')] > 0) { // 有 's' 说明有 7
            all.put(7, counts[map.get('s')]);
            counts[map.get('e')] -= 2 * counts[map.get('s')];
            counts[map.get('v')] -= counts[map.get('s')];
            counts[map.get('n')] -= counts[map.get('s')];
        }
    }

    public void deleteThird(Map<Character, Integer> map, int[] counts, Map<Integer, Integer> all) {
        if (counts[map.get('i')] > 0) { // 有 'i' 说明有 9
            all.put(9, counts[map.get('i')]);
        }
    }
}