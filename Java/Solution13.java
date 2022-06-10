import java.util.*;

class Solution13 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    res += map.get(s.substring(i, i + 2));
                    i++;
                }
                else res += map.get(s.substring(i, i + 1));
            }
            else if (s.charAt(i) == 'X') {
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                    res += map.get(s.substring(i, i + 2));
                    i++;
                }
                else res += map.get(s.substring(i, i + 1));
            }
            else if (s.charAt(i) == 'C') {
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    res += map.get(s.substring(i, i + 2));
                    i++;
                }
                else res += map.get(s.substring(i, i + 1));
            }
            else res += map.get(s.substring(i, i + 1));
        }
        return res;
    }
}