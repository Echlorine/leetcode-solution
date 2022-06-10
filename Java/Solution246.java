import java.util.*;

class Solution246 {
    public boolean isStrobogrammatic(String num) {
        Set<Integer> set = new HashSet<>() {{
            add(8);
            add(0);
            add(1);
        }};
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            int nleft = num.charAt(left) - '0';
            int nright = num.charAt(right) - '0';
            left++;
            right--;
            if (!set.contains(nleft) || !set.contains(nright)) {
                if (nleft == 6 && nright == 9) continue;
                else if (nleft == 9 && nright == 6) continue;
                else return false;
            }
            if (nleft == nright) continue;
            else return false;
        }
        return true;
    }
}