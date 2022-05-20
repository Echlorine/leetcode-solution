class Solution29 {
    public int divide(int dividend, int divisor) {
        int res=0, temp=0;
        double border1 = Math.pow(2, 31);
        if (dividend == 0)
            return res;
        if (dividend > 0 && divisor > 0){
            if (dividend < divisor)
                return res;
            for (res=0; res < border1-1; res++){
                temp += divisor;
                if (temp > dividend)
                    break;
            }
        }
        if (dividend < 0 && divisor < 0){
            if (dividend > divisor)
                return res;
            for (res=0; res < border1-1; res++){
                temp += divisor;
                if (temp < dividend)
                    break;
            }
        }
        if (dividend > 0 && divisor < 0){
            dividend = -dividend;
            if (dividend > divisor)
                return res;
            for (res=0; res < border1; res++){
                temp += divisor;
                if (temp < dividend)
                    break;
            }
            res = -res;
        }
        if (dividend < 0 && divisor > 0){
            if (dividend > -divisor)
                return res;
            for (res=0; res > -border1; res--){
                temp -= divisor;
                if (temp < dividend)
                    break;
            }
        }
        return res;
    }
}