class Solution1138 {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int x_last = 0, y_last = 0;
        for (int i = 0; i < target.length(); i++) {
            int dis = target.charAt(i) - 'a';
            int x = dis % 5, y = dis / 5;
            while (y < y_last) {
                sb.append('U');
                y_last--;
            }
            while (x < x_last) {
                sb.append('L');
                x_last--;
            }
            while (y > y_last) {
                sb.append('D');
                y_last++;
            }
            while (x > x_last) {
                sb.append('R');
                x_last++;
            }
            sb.append('!');
            x_last = x;
            y_last = y;
        }
        return sb.toString();
    }
}