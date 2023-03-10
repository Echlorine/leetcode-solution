class Solution1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        int mod = 1000000007;
        int res = 0;
        PriorityQueue<int[]> buy_log = new PriorityQueue<>((a1, a2) -> a2[0] - a1[0]); // 采购订单，由高到低
        PriorityQueue<int[]> sell_log = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]); // 销售订单，由低到高
        for (int[] order : orders) {
            if (order[2] == 0) { // 采购订单
                if (sell_log.size() == 0) {
                    buy_log.add(order);
                    continue;
                }
                while (sell_log.size() > 0 && order[0] >= sell_log.peek()[0]) {
                    if (order[1] > sell_log.peek()[1]) {
                        int[] sell_order = sell_log.poll();
                        order[1] -= sell_order[1];
                    } else {
                        int[] sell_order = sell_log.poll();
                        sell_order[1] -= order[1];
                        order[1] = 0;
                        sell_log.add(sell_order);
                        break;
                    }
                    if (sell_log.size() == 0) break;
                }
                if (order[1] > 0) buy_log.add(order);
            } else { // 销售订单
                if (buy_log.size() == 0) {
                    sell_log.add(order);
                    continue;
                }
                while (buy_log.size() > 0 && order[0] <= buy_log.peek()[0]) {
                    if (order[1] > buy_log.peek()[1]) {
                        int[] buy_order = buy_log.poll();
                        order[1] -= buy_order[1];
                    } else {
                        int[] buy_order = buy_log.poll();
                        buy_order[1] -= order[1];
                        order[1] = 0;
                        buy_log.add(buy_order);
                        break;
                    }
                    if (buy_log.size() == 0) break;
                }
                if (order[1] > 0) sell_log.add(order);
            }
        }
        while (buy_log.size() > 0) {
            int num = buy_log.poll()[1];
            res = (res + num) % mod;
        }
        while (sell_log.size() > 0) {
            int num  = sell_log.poll()[1];
            res = (res + num) % mod;
        }
        return res;
    }
}