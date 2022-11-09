class Solution1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] map = new int[26][2];
        for (int i = 0; i < map.length; i++) {
            map[i][0] = -1;
        }
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (map[idx][0] == -1) {
                map[idx][0] = i;
            }
            map[idx][1] = i;
            res = Math.max(res, map[idx][1] - map[idx][0] - 1);
        }
        return res;
    }
}