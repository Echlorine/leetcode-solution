import java.util.*;

class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        // 统计每个任务的数量
        int[] task = new int[26];
        for (char t : tasks)
            task[t - 'A'] += 1;
        int count = 0; // 需要执行的任务数
        List<Integer> nextValid = new ArrayList<Integer>(); // 任务的下一个可执行时间
        List<Integer> rest = new ArrayList<Integer>(); // 剩余的任务数量
        // 初始化
        for (int i = 0; i < task.length; i++)
            if (task[i] != 0) {
                count++;
                nextValid.add(1);
                rest.add(task[i]);
            }
        
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time++;
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < count; j++) {
                if (rest.get(j) != 0) 
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
            }
            // 下一个任务可以被执行的最小时间
            time = Math.max(time, minNextValid);
            int best = -1;
            // 找接下来该执行的任务，即剩余执行次数最多的事务
            for (int j = 0; j < count; ++j)
                if (rest.get(j) != 0 && nextValid.get(j) <= time)
                    if (best == -1 || rest.get(j) > rest.get(best))
                        best = j;
            nextValid.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }
        return time;
    }
}