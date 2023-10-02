class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && placeFlowers(flowerbed, i)) {
                flowerbed[i] = 1;
                res++;
            }
        }
        return res >= n;
    }

    public boolean placeFlowers(int[] flowerbed, int i) {
        if (i -1 >= 0 && i + 1 < flowerbed.length) return flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0;
        else if (i - 1 < 0 && i + 1 < flowerbed.length) return flowerbed[i + 1] == 0;
        else if (i -1 >= 0 && i + 1 >= flowerbed.length) return flowerbed[i - 1] == 0;
        return flowerbed[i] == 0;
    }
}