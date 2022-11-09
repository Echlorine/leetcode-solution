class Solution1592 {
    public String reorderSpaces(String text) {
        String[] strs = text.split(" ");
        int num = 0;
        int len = 0;
        for (String str : strs) {
            if (str.length() == 0) continue;
            len += str.length();
            num++;
        }
        int remain = num == 1 ? text.length() - len : (text.length() - len) % (num - 1);
        int interval = num == 1 ? 0 : (text.length() - len) / (num - 1);
        StringBuilder iv = new StringBuilder();
        for (int i = 0; i < interval; i++) {
            iv.append(" ");
        }
        StringBuilder rm = new StringBuilder();
        for (int i = 0; i < remain; i++) {
            rm.append(" ");
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (String str : strs) {
            if (str.length() == 0) continue;
            sb.append(str);
            if (++index < num) {
                sb.append(iv);
            }
        }
        sb.append(rm);
        return sb.toString();
    }
}