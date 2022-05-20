class Solution6 {
    public String convert(String s, int numRows) {
        int len, dim, cup, y;
        String res ="";
        len = s.length();
        if (numRows == 1)
            return s;
        cup = numRows * 2 - 2;
        dim = len / (numRows * 2 - 2);
        if ((len - dim * cup) <= numRows)
            dim = dim * (numRows - 1) + 1;
        else
            dim = dim * (numRows - 1) + 1 + (len - dim * cup - numRows);
        char []sarray = s.toCharArray();
        char [][]out = new char[numRows][dim];
        for (int i=0; i<numRows; i++)
            for (int j=0; j<dim; j++)
                out[i][j] = '*';
        for (int i=0,j=0; i<dim; i++){
            if (j == len)
                break;
            if (i % (numRows - 1) == 0)
                for(int k=0; k<numRows; k++){
                    out[k][i] = sarray[j];
                    j++;
                    if (j == len)
                        break;
                }
            else{
                y = numRows - 1 - i % (numRows - 1);
                out[y][i] = sarray[j];
                j++;
                if (j == len)
                    break;
            }
        }
        for (int i=0; i<numRows; i++)
            for (int j=0; j<dim; j++){
                if (out[i][j] == '*')
                    continue;
                res = res + out[i][j];
            }
        return res;
    }
}