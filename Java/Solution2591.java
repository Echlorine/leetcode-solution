class Solution2591 {
    public int distMoney(int money, int children) {
        int res = 0;
        while (children > 0 && money - 8 >= children - 1) {
            money -= 8;
            children--;
            res++;
        }
        if (children == 0) {
            if (money == 0) return res;
            return res - 1;
        } else {
            if (money < children) return res - 1;
            return money == 4 && children == 1 ? res - 1 : res;
        }
    }
}