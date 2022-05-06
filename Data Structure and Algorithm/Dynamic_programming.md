# 经典的DP问题
## LIS问题
题目名称|说明|答案
:--|:-|:-:
[300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)|有两种动态规划的思路，两种都要掌握|[Java](../Java/300.java)
[354. 俄罗斯套娃信封问题](https://leetcode-cn.com/problems/russian-doll-envelopes/)|本质和[300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)相同，不过是一个二维的问题|[Java](../Java/354.java)
[673. 最长递增子序列的个数](https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/)|本质和[300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)相同，用了两个dp数组来维护状态|[Java](../Java/673.java)
[873. 最长的斐波那契子序列的长度](https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/)|同时编写哈希函数避免哈希冲突，加快查找|[Java](../Java/873.java)
[1027. 最长等差数列](https://leetcode-cn.com/problems/longest-arithmetic-subsequence/)|与[873. 最长的斐波那契子序列的长度](https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/)类似，但是会有哈希冲突，需要不一样的状态表现方式|[Java](../Java/1027.java)

## 子数组的最大和
题目名称|说明|答案
:--|:-|:-:
[53. 最大子数组和](https://leetcode-cn.com/problems/maximum-subarray/submissions/)|~|[Java](../Java/53.java) [Python](../Python/53.py)
[152. 乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/)|用了两个dp数组分类讨论来表示状态|[Java](../Java/152.java)
[918. 环形子数组的最大和](https://leetcode-cn.com/problems/maximum-sum-circular-subarray/)|难在环形数组的处理|[Java](../Java/918.java)
[面试题 17.24. 最大子矩阵](https://leetcode-cn.com/problems/max-submatrix-lcci/)|二维最大连续子序和|[Java](../Java/Interview1724.java)

## 不相邻子序列的最大和
题目名称|说明|答案
:--|:-|:-:
[198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)|~|[Java](../Java/198.java)
[213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/)|本质同[198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)相同，分为两种情况讨论即可|[Java](../Java/213.java)
[740. 删除并获得点数](https://leetcode-cn.com/problems/delete-and-earn/)|本质同[198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)相同，需要进行问题转化|[Java](../Java/740.java)
[1388. 3n 块披萨](https://leetcode-cn.com/problems/pizza-with-3n-slices/)|本质同[213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/)，难在将问题等价的转化|[Java](../Java/1388.java)

## 买卖股票的最佳时机
题目名称|说明|答案
:--|:-|:-:
[121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)|~|[Java](../Java/121.java)
[122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)|~|[Java](../Java/122.java)
[123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)|通解是利用多状态动态规划，也可以分为2部分，每部分都用[121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)的方法|[Java](../Java/123.java)
[188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)|[123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)的通解|[Java](../Java/188.java)
[309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)|本质与[122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)相同|[Java](../Java/309.java)

## 其它
题目名称|说明|答案
:--|:-|:-:
[221. 最大正方形](https://leetcode-cn.com/problems/maximal-square/)|~|[Java](../Java/221.java)
[312. 戳气球](https://leetcode-cn.com/problems/burst-balloons/)|~|[Java](../Java/312.java)
[337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)|~|[Java](../Java/337.java)

# 具有多种状态的DP问题
题目名称|说明|答案
:--|:-|:-:
[152. 乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/)|~|[Java](../Java/152.java)
[122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)|~|[Java](../Java/122.java)
[123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)|分为了5种状态|[Java](../Java/123.java)
[188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)|[123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)的通解|[Java](../Java/188.java)
[256. 粉刷房子](https://leetcode-cn.com/problems/paint-house/)|~|[Java](../Java/256.java)
[265. 粉刷房子 II](https://leetcode-cn.com/problems/paint-house-ii/)|与[256. 粉刷房子](https://leetcode-cn.com/problems/paint-house/)相同|[Java](../Java/265.java)
[309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)|本质与[122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)相同|[Java](../Java/309.java)
[337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)|~|[Java](../Java/337.java)
[673. 最长递增子序列的个数](https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/)|本质和[300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)相同，用了两个dp数组来维护状态|[Java](../Java/673.java)
[813. 最大平均值和的分组](https://leetcode-cn.com/problems/largest-sum-of-averages/)|理解状态如何转移|[Java](../Java/813.java)

# String类型的DP问题
题目名称|说明|答案
:--|:-|:-:
[10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/)|~|[Java](../Java/10.java)
[72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)|~|[Java](../Java/72.java)

# [背包问题](https://baike.baidu.com/item/%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98/2416931)
背包问题最基础的就是01背包了，一定要理解和掌握。  
## [0-1背包](https://baike.baidu.com/item/01%E8%83%8C%E5%8C%85/4301245)
力扣相关问题:  
题目名称|说明|答案
:--|:-|:-:
[416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)|~|[Java](../Java/416.java)
[494. 目标和](https://leetcode-cn.com/problems/target-sum/)|~|[Java](../Java/494.java)
[879. 盈利计划](https://leetcode-cn.com/problems/profitable-schemes/)|~
[1049. 最后一块石头的重量 II](https://leetcode-cn.com/problems/last-stone-weight-ii/)|~
[1230. 抛掷硬币](https://leetcode-cn.com/problems/toss-strange-coins/)|~|[Java](../Java/1230.java)
[2212. 射箭比赛中的最大得分](https://leetcode-cn.com/problems/maximum-points-in-an-archery-competition/solution/)|~

## [完全背包](https://baike.baidu.com/item/%E5%AE%8C%E5%85%A8%E8%83%8C%E5%8C%85/7066689)
力扣相关问题:  
题目名称|说明|答案
:--|:-|:-:
[279. 完全平方数](https://leetcode-cn.com/problems/perfect-squares/)|~|[Java](../Java/279.java)
[322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)|~|[Java](../Java/322.java)
[518. 零钱兑换 II](https://leetcode-cn.com/problems/coin-change-2/)|~|[Java](../Java/518.java)
[1449. 数位成本和为目标值的最大数字](https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target/)|~

# 状态压缩DP
力扣相关问题:  
题目名称|说明|答案
:--|:-|:-:
[473. 火柴拼正方形](https://leetcode-cn.com/problems/matchsticks-to-square/)|~|~
[698. 划分为k个相等的子集](https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/)|~|~