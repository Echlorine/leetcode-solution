class Solution1601 {
    private int res;
    private int[] diff;

    public int maximumRequests(int n, int[][] requests) {
        diff = new int[n];
        res = 0;
        dfs(requests, 0, 0);
        return res;
    }

    public void dfs(int[][] requests, int index, int num) {
        if (index == requests.length) {
            boolean flag = false;
            for (int i = 0; i < diff.length; i++) {
                if (diff[i] != 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag && num > res) {
                res = num;
            }
            return;
        }
        // 不同意当前换楼要求
        dfs(requests, index + 1, num);
        // 同意当前换楼要求
        diff[requests[index][0]]--;
        diff[requests[index][1]]++;
        dfs(requests, index, num + 1);
        // 回溯
        diff[requests[index][0]]++;
        diff[requests[index][1]]--;
    }
}