class Solution630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> (b - a));
        int sum = 0;
        for (int[] course : courses) {
            if (sum + course[0] <= course[1]) {
                sum += course[0];
                queue.offer(course[0]);
            } else if (!queue.isEmpty() && queue.peek() > course[0]){
                sum -= queue.poll() - course[0];
                queue.offer(course[0]);
            }
        }
        return queue.size();
    }
}