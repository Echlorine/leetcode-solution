class Solution151 {
    public String reverseWords(String s) {
        String[] sarr = s.split(" ");
        int left = 0, right = sarr.length - 1;
        while (left < right) {
            if (sarr[left].equals("")) {
                left++;
                continue;
            }
            if (sarr[right].equals("")) {
                right--;
                continue;
            }
            String temp = sarr[left];
            sarr[left] = sarr[right];
            sarr[right] = temp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sarr.length; i++) {
            if (sarr[i].equals("")) continue;
            sb.append(sarr[i]);
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}