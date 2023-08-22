class Solution1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        for (int[] mat : matrix) {
            char[] arr = new char[mat.length];
            Arrays.fill(arr, '0');
            // 将每一行都翻转成从 1 开始的
            for (int i = 0; i < n; i++) {
                arr[i] = (char) ('0' + mat[i] ^ mat[0]);
            }
            String key = new String(arr);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int res = 0;
        for (String key : map.keySet()) {
            res = Math.max(res, map.get(key));
        }
        return res;
    }
}