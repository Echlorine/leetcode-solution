import java.util.*;

class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacent = new ArrayList<>(); // 邻接表
        int[] count = new int[numCourses]; // 入度数组
        Stack<Integer> s = new Stack<>();
        int j = 0;

        for(int i = 0; i < numCourses; i++)
            adjacent.add(new ArrayList<>());
        // 统计每个结点的入度与出度
        for (int i = 0; i < prerequisites.length; i++){
            count[prerequisites[i][0]]++; // 对应结点入度 + 1
            adjacent.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // 将入度为0的结点入栈
        for (int i = 0; i < numCourses; i++)
            if (count[i] == 0)
                s.push(i);
        // 拓扑排序
        for (int i = 0; i < numCourses; i++) {
            if (s.isEmpty()) return false;
            j = s.pop();
            for (int k : adjacent.get(j)) {
                count[k]--;
                if (count[k] == 0) s.push(k);
            }
        }
        return true;
    }
}