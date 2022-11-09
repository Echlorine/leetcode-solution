import java.util.HashMap;
import java.util.Map;

// This is the robot's control interface.
// You should not implement it, or speculate about its implementation
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}

class Solution489 {
    static int[][] dirs = new int[][] {
        new int[] {-1, 0}, // 上 0 
        new int[] {0, 1}, // 右 1
        new int[] {1, 0}, // 下 2
        new int[] {0, -1} // 左 3
    };

    public void cleanRoom(Robot robot) {
        int[] init_P = new int[] {0, 0}; // 假设是初始位置
        Map<String, Integer> visited = new HashMap<>();
        dfs(visited, init_P, 0, robot);
    }

    public void dfs(Map<String, Integer> visited, int[] current_P, int dir, Robot robot) {
        String cur = current_P[0] + "," + current_P[1];
        // 打扫当前位置
        robot.clean();
        visited.put(cur, visited.getOrDefault(cur, 0) + 1);
        // DFS
        for (int i = 0; i < 4; i++) { // 上，右，下，左
            int d = (dir + i) % 4; // 确定当前方向
            String next = (current_P[0] + dirs[d][0]) + "," + (current_P[1] + dirs[d][1]);
            if (visited.getOrDefault(next, 0) == 0 && robot.move()) {
                dfs(visited, new int[] {current_P[0] + dirs[d][0], current_P[1] + dirs[d][1]}, d, robot);
            }
            robot.turnRight();
        }
        // 回溯
        back(robot);
    }

    public void back(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}