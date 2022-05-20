class Solution165 {
    public int compareVersion(String version1, String version2) {
        int left1 = 0, right1 = left1 + 1;
        int left2 = 0, right2 = left2 + 1;
        while (left1 < version1.length() || left2 < version2.length()) {
            String str1 = "", str2= "";
            while (right1 <= version1.length()) {
                if (right1 == version1.length() || version1.charAt(right1) == '.') {
                    str1 = version1.substring(left1, right1);
                    left1 = ++right1;
                    break;
                }
                right1++;
            }
            while (right2 <= version2.length()) {
                if (right2 == version2.length() || version2.charAt(right2) == '.') {
                    str2 = version2.substring(left2, right2);
                    left2 = ++right2;
                    break;
                }
                right2++;
            }
            int temp = compare(str1, str2);
            if (temp != 0) return temp;
        }
        return 0;
    }

    public int compare(String str1, String str2) {
        int a = 0, b = 0;
        if (!str1.equals("")) a = Integer.valueOf(str1);
        if (!str2.equals("")) b = Integer.valueOf(str2);
        if (a > b) return 1;
        else if (a < b) return -1;
        else return 0;
    }
}