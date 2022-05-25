class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int fnum = 0, tnum = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) fnum++;
            else if (bills[i] == 10) {
                tnum++;
                if (fnum >= 1) fnum--;
                else return false;
            }
            else if (bills[i] == 20) {
                if (tnum >= 1) {
                    tnum--;
                    if (fnum >= 1) fnum--;
                    else return false;
                }
                else {
                    if (fnum >= 3) fnum -= 3;
                    else return false;
                }
            }
        }
        return true;
    }
}