import java.util.*;

class Solution1079 {
    public int numTilePossibilities(String tiles) {
        char[] chararray = tiles.toCharArray();
        Arrays.sort(chararray);
        String tile = new String(chararray);
        boolean[] visited = new boolean[tile.length()];
        int[] res = new int[] {0};
        dfs(tile, visited, res);
        return res[0];
    }

    public void dfs(String str, boolean[] visited, int[] res) {
        for (int i = 0; i < str.length(); i++) {
            if (i > 0 && str.charAt(i) == str.charAt(i - 1) && !visited[i - 1]) // 剪枝条件，如果相邻的值相同，但是没选前面的，那么也不能选择后面的
                continue;
            if (visited[i]) continue;
            res[0]++;
            visited[i] = true;
            dfs(str, visited, res);
            visited[i] = false;
        }
    }
}