import math

class Solution:
    def numSquares(self, n: int) -> int:
        dp = [0 for i in range(n + 1)]
        # 边界条件
        dp[0] = 1
        # dp
        for i in range(1, n + 1):
            temp = int(math.sqrt(i))
            min_val = 10001
            # for k in range(temp, 0, -1):
            for k in range(1, temp + 1):
                min_val = min(min_val, dp[k * k] + dp[i - k * k])
            dp[i] = min_val
        return dp[n]