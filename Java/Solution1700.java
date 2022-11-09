class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] hash = new int[2];
        Queue<Integer> queue = new LinkedList<>();
        for (int i  = 0; i < students.length; i++) {
            if (students[i] == 0) hash[0]++;
            else hash[1]++;
            queue.add(students[i]);
        }
        for (int sandwiche : sandwiches) {
            while (queue.peek() != sandwiche && hash[sandwiche] != 0) {
                queue.add(queue.poll());
            }
            if (queue.peek() == sandwiche) {
                queue.poll();
                hash[sandwiche]--;
            } else if (hash[sandwiche] == 0) {
                break;
            }
        }
        return hash[0] + hash[1];
    }
}