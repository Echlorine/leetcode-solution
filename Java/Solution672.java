class Solution672 {
    public int flipLights(int n, int presses) {
        int lights = Math.min(n, 6);
        int[] masks = new int[]{0b111111, 0b101010, 0b010101, 0b001001};
        int[] conditions = new int[1 << lights]; // 所有可能的情况
        for (int i = 0; i < (1 << 4); i++) {
            int count = Integer.bitCount(i);
            // 跳过不可能出现的情况
            if (count > presses || count % 2 != presses % 2) continue;
            
            // 确定每一个condition能否出现
            int temp = 0;
            int[] pressArr = new int[4]; // 每一个开关的最后状态
            for (int j = 0; j < 4; j++) {
                pressArr[j] = (i >> j) & 1;
                if (pressArr[j] == 1) {
                    temp ^= masks[j];
                }
            }
            conditions[temp & (conditions.length - 1)] = 1;
        }
        int res = 0;
        for (int condition : conditions) {
            if (condition == 1) res++;
        }
        return res;
    }
}