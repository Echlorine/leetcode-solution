class Interview0502 {
    public String printBin(double num) {
        double radix = num;
        for (int i = 0; i < 6; i++)
            radix *= 2;
        double floor = radix - Math.floor(radix);
        if (floor != 0) return"ERROR";
        return getBit((int) Math.floor(radix));
    }

    public String getBit(int num) {
        boolean flag = true;
        int suffix = 0;
        StringBuilder sb = new StringBuilder();
        while (num >= 1) {
            int res = num % 2;
            num /= 2;
            if (flag && res == 0) {
                suffix++;
                continue;
            }
            else sb.append(res);
            flag &= res == 0;
        }
        int zeros = 6- sb.length() - suffix;
        for (int i = 0; i < zeros; i++) {
            sb.append("0");
        }
        sb.append(".0");
        return sb.reverse().toString();
    }
}