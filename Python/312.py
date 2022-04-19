class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        length = len(nums) + 2
        dp = [[0] * length for i in range(length)]
        # 边界条件
        for i in range(length):
            for j in range(i + 1):
                if j < length:
                    dp[i][j] = 0
        # 动态规划
        for i in range(length - 2, -1, -1):
            for j in range(i + 2, length):
                temp = 0
                # 状态转移
                for k in range(i + 1, j):
                    if i < 1 or i > len(nums):
                        left = 1
                    else:
                        left = nums[i - 1]
                    if j < 1 or j > len(nums):
                        right = 1
                    else:
                        right = nums[j - 1]
                    temp = max(temp, dp[i][k] + dp[k][j] + nums[k - 1] * left * right)
                dp[i][j] = temp
        return dp[0][length - 1]