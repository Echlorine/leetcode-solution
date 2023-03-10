class Solution2335 {
    public int fillCups(int[] amount) {
        // 贪心原理：每一秒钟尽可能装 2 杯水
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)->o2.compareTo(o1));
        for (int i = 0; i < amount.length; i++) {
            queue.add(amount[i]);
        }
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            boolean flag = false;
            a--;
            b--;
            if (a >= 0) {
                queue.add(a);
                flag |= true;
            }
            if (b >= 0) {
                queue.add(b);
                flag |= true;
            }
            if (flag) res++;
        }
        return res + (queue.size() > 0 ? queue.peek() : 0);
    }
}

class Solution2335 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[0] + amount[1]) {
            return amount[2];
        }
        return (int) Math.ceil((amount[0] + amount[1] + amount[2]) / 2.0);
    }
}