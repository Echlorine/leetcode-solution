class Solution1055 {
    public int shortestWay(String source, String target) {
        int res = 0;
        char[] targetArray = target.toCharArray();
        int cursor = -1; // 最后一次成功匹配的位置
        for (int i = 0; i < targetArray.length; i++) {
            int temp = cursor + 1;
            while (temp < source.length() && targetArray[i] != source.charAt(temp)) {
                temp++;
            }
            if (temp == source.length()) {
                res++;
                temp = 0; // 到达最后，重置游标
                while (temp < source.length() && targetArray[i] != source.charAt(temp)) {
                    temp++;
                }
                if (temp == source.length()) {
                    // 有一个字母源串中没有
                    return -1;
                }
            }
            cursor = temp;
        }
        return res + 1;
    }
}