class Solution1041 {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, d = 0;
        for (int t = 0 ; t < 4; t++) {
            for (int i = 0; i < instructions.length(); i++) {
                char c = instructions.charAt(i);
                if (c == 'G') {
                    if (d % 2 == 0) y += d - 1;
                    else x += d - 2;
                } else if (c == 'L') {
                    d = (d + 3) % 4;
                } else {
                    d = (d + 1) % 4;
                }
            }
            if (x == 0 && y == 0 && d == 0) return true;
        }
        return false;
    }
}