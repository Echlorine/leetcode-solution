class Solution38 {
    public String countAndSay(int n) {
        String[] say = new String[n];
        say[0] = String.valueOf(1);
        for (int i = 1; i < n ; i++) {
            String last = say[i - 1];
            StringBuffer bf = new StringBuffer();
            int num = 0; // 计数
            for (int j = 0; j < last.length(); j++) {
                if (j == 0) {
                    num = 1;
                }
                else {
                    if (last.charAt(j) == last.charAt(j - 1)) // 当前字符和前一个相同
                        num++;
                    else {
                        bf.append(String.valueOf(num));
                        bf.append(last.substring(j - 1, j));
                        num = 1; // 计数器置1
                    }
                }
            }
            bf.append(String.valueOf(num));
            bf.append(last.substring(last.length() - 1));
            say[i] = bf.toString();
        }
        return say[n - 1];
    }
}