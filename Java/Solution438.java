import java.util.*;

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        int[] smap = new int[26], pmap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pmap[p.charAt(i) - 97] += 1;
            smap[s.charAt(i) - 97] += 1;
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (Arrays.equals(smap, pmap)) res.add(i);
            if (i < s.length() - p.length()) {
                smap[s.charAt(i) - 97] -= 1;
                smap[s.charAt(i + p.length()) - 97] += 1;
            }
        }
        return res;
    }

    public List<Integer> Anagrams(String s, String p) {
        // 优化上述算法的空间复杂度
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[s.charAt(i) - 97] += 1;
            map[p.charAt(i) - 97] -= 1;
        }
        int count = 0; // 不同的字母的个数
        for (int i = 0; i < 26; i++)
            if (map[i] != 0) count++;
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (count == 0) res.add(i);
            if (i < s.length() - p.length()) {
                // 移除左指针
                if (map[s.charAt(i) - 97] == 1) // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                    count--;
                if (map[s.charAt(i) - 97] == 0) // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                    count++;
                map[s.charAt(i) - 97] -= 1;
                // 增加右指针
                if (map[s.charAt(i + p.length()) - 97] == -1) // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                    count--;
                if (map[s.charAt(i + p.length()) - 97] == 0) // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                    count++;
                map[s.charAt(i + p.length()) - 97] += 1;
            }
        }
        return res;
    }
}