class Solution849 {
    public int maxDistToClosest(int[] seats) {
        int second = -1;
        int res = 0;
        for (int first = 0; first < seats.length; first++) {
            if (seats[first] == 1) {
                if (second >= 0) {
                    res = Math.max(res, (first - second) / 2);
                } else {
                    res = first;
                }
                second = first;
            }
        }
        return Math.max(res, seats.length - 1 - second);
    }
}