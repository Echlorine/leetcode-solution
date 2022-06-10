def mySqrt(self, x: int) -> int:
    res = x
    if res == 0:
        return 0
    while True:
        if res ** 2 > x:
            res /= 2
        else:
            break
    for i in range(int(res), int(res * 2) + 1):
        if i ** 2 <= x and (i + 1) ** 2 > x:
            return i