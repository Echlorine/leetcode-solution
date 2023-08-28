class Solution2517 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = price[price.length - 1] - price[0];
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(price, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    public boolean check(int[] price, int k, int tastiness) {
        int pre = price[0];
        int num = 1;
        for (int i = 1; i < price.length; i++) {
            if (price[i] - pre >= tastiness) {
                pre = price[i];
                num++;
            }
        }
        return num >= k;
    }
}

class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = price[price.length - 1] - price[0];
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(price, k, mid)) {
                left = mid + 1;
                res = Math.max(res, mid);
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
    
    public boolean check(int[] price, int k, int tastiness) {
        int pre = price[0];
        int num = 1;
        for (int i = 1; i < price.length; i++) {
            if (price[i] - pre >= tastiness) {
                pre = price[i];
                num++;
            }
        }
        return num >= k;
    }
}