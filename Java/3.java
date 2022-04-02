import java.util.HashSet;

class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<String> temp = new HashSet<String>();
        int res = 0;
        int left = 0, right = 0; // 左指针，右指针
        for (left = 0; left < s.length(); left++) {
            if (left != 0)
                temp.remove(s.substring(left-1, left));
            if (right == s.length()) // 右指针到字符串最后，没必要继续比较
                break;
            while (!temp.contains(s.substring(right, right+1))) {
                temp.add(s.substring(right, right+1));
                right++;
                if (right == s.length()) // 字符串最后
                    break;
            }
            if (res < right - left)
                res = right - left;
        }
        return res;
    }
}