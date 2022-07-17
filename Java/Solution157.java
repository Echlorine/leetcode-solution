/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution157 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int res = 0, temp = read4(buf4);
        while (temp != 0) {
            for (int i = 0; i < temp && res < n; i++) {
                buf[res++] = buf4[i];
            }
            temp = read4(buf4);
        }
        return res;
    }
}

class Reader4 {
    /**
     * 这一部分纯粹是为了在本地IDE不报错才加上的，无实际意义
     * @param buf4
     * @return
     */
    int read4(char[] buf4) {
        return 0;
    }
}