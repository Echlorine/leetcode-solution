// 这是一位大佬写的，时间很快
/**
class Solution76 {
    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;
        // 对t中的每一个字符计算数量
        int[] hash = new int[128];
        for (char c : chart)
            hash[c]--;
        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            hash[chars[i]]++; // s中找到了一个包含t的字符
            if (hash[chars[i]] <= 0) cnt++;
            while (cnt == m && hash[chars[j]] > 0) hash[chars[j++]]--;
            if (cnt == m)
                if (res.equals("") || res.length() > i - j + 1)
                    res = s.substring(j, i + 1);
        }
        return res;
    }
}
*/

// 下面的代码会超时，思考一下怎么优化
 
/**
class Solution76 {
    public String minWindow(String s, String t) {
        int begin = 0, end = 0; //左右指针
        int flag = 0, len = s.length();
        while (end + 1 - begin >= 1){
            // 当前串含有t的全部字母
            if (has(s.substring(begin, end + 1), t)){
                if (len >= end + 1 - begin) {len = end + 1 - begin; flag = begin;}
                begin++; // 左指针右移
                continue;
            }
            if (end < s.length() - 1) {end++; continue;}
            if (end == s.length() - 1) break;
        }
        if (len == s.length() && begin == 0) return "";
        return s.substring(flag, flag + len);
    }
    
    // 该函数判断一个字符串是否含有另一个字符串的全部字母
    public boolean has(String c, String t){
        Map<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < c.length(); i++){
            if (temp.containsKey(c.charAt(i))) temp.put(c.charAt(i), temp.get(c.charAt(i)) + 1);
            else temp.put(c.charAt(i), 1);
        }
        for (int i = 0; i < t.length(); i++){
            if (!temp.containsKey(t.charAt(i)) || temp.get(t.charAt(i)) <= 0) return false;
            temp.put(t.charAt(i), temp.get(t.charAt(i)) - 1);
        }
        return true;
    }
}
*/

// 优化后的代码，好歹不超时了

import java.util.*;

class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        // 构建t的哈希表
        for (int i = 0; i < t.length(); i++){
            if (tmap.containsKey(t.charAt(i))) tmap.put(t.charAt(i), tmap.get(t.charAt(i)) + 1);
            else tmap.put(t.charAt(i), 1);
        }
        int begin = 0, end = 0; //左右指针
        int flag = 0, len = s.length();
        // 初始化s的哈希表
        smap.put(s.charAt(begin), 1);
        while (end + 1 - begin >= 1){
            // 当前串含有t的全部字母
            if (has(smap, tmap)){
                if (len >= end + 1 - begin) {len = end + 1 - begin; flag = begin;}
                begin++; // 左指针右移
                smap.put(s.charAt(begin - 1), smap.get(s.charAt(begin - 1)) - 1); // 更新hash表
                continue;
            }
            if (end < s.length() - 1) {end++; smap.put(s.charAt(end), smap.getOrDefault(s.charAt(end), 0) + 1);continue;}
            if (end == s.length() - 1) break;
        }
        if (len == s.length() && begin == 0) return "";
        return s.substring(flag, flag + len);
    }

    public boolean has(Map<Character, Integer> smap, Map<Character, Integer> tmap){
        for (Character i : tmap.keySet()) {
            if (smap.getOrDefault(i, 0) < tmap.get(i)) return false;
        }
        return true;
    }
}