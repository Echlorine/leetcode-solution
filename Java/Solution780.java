class Solution780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        int sorx = Math.min(sx, sy);
        int sory = Math.max(sx, sy);
        int dstx = Math.min(tx, ty);
        int dsty = Math.max(tx, ty);
        if (dstx == sorx && dsty == sory) return tx == sx && ty == sy;
        int temp = dsty % dstx;
        dsty = dstx + temp;
        while (dsty < sory) {
            if (dsty + temp > ty) break;
            else dsty += dstx;
        }
        while (dstx >= sorx && dsty >= sory) {
            if (dstx == sorx && dsty == sory) return true;
            temp = dsty - dstx;
            dsty = Math.max(dstx, temp);
            dstx = Math.min(dstx, temp);
        }
        return false;
    }
}