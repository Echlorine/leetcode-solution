class Solution12 {
    public static String intToRoman(int num) {
        int[] numarray = new int[4]; //存储每一位数的数值
        String res= "";
        numarray[0] = num / 1000;
        numarray[1] = num / 100 % 10;
        numarray[2] = num / 10 % 10;
        numarray[3] = num % 10;
        // System.out.println(Arrays.toString(numarray));
        for (int i=0; i<numarray.length; i++){
            if(numarray[i]>0 && numarray[i] < 4){
                switch (i){
                    case 0: // 千位
                        for (int j=0; j<numarray[i]; j++)
                            res = res + "M";
                        break;
                    case 1: // 百位
                        for (int j=0; j<numarray[i]; j++)
                            res = res + "C";
                        break;
                    case 2: // 十位
                        for (int j=0; j<numarray[i]; j++)
                            res = res + "X";
                        break;
                    case 3: // 个位
                        for (int j=0; j<numarray[i]; j++)
                            res = res + "I";
                        break;
                }
            }
            if(numarray[i]>4 && numarray[i] < 9){
                switch (i){
                    case 1: // 百位
                        res = res + "D";
                        for (int j=0; j<numarray[i]-5; j++)
                            res = res + "C";
                        break;
                    case 2: // 十位
                        res = res + "L";
                        for (int j=0; j<numarray[i]-5; j++)
                            res = res + "X";
                        break;
                    case 3: // 个位
                        res = res + "V";
                        for (int j=0; j<numarray[i]-5; j++)
                            res = res + "I";
                        break;
                }
            }
            if(numarray[i]==4){
                switch (i){
                    case 1: // 百位
                        res = res + "CD";
                        break;
                    case 2: // 十位
                        res = res + "XL";
                        break;
                    case 3: // 个位
                        res = res + "IV";
                        break;
                }
            }
            if(numarray[i]==9){
                switch (i){
                    case 1: // 百位
                        res = res + "CM";
                        break;
                    case 2: // 十位
                        res = res + "XC";
                        break;
                    case 3: // 个位
                        res = res + "IX";
                        break;
                }
            }
        }
        return res;
    }
}