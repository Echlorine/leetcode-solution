# 单串DP问题
## LIS问题
题目名称|说明|答案
:------|:---|:--:
[300. 最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/)|有两种动态规划的思路，两种都要掌握|[Java](../Java/Solution300.java)
[354. 俄罗斯套娃信封问题](https://leetcode.cn/problems/russian-doll-envelopes/)|本质和[300. 最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/)相同，不过是一个二维的问题|[Java](../Java/Solution354.java)
[673. 最长递增子序列的个数](https://leetcode.cn/problems/number-of-longest-increasing-subsequence/)|本质和[300. 最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/)相同，用了两个dp数组来维护状态|[Java](../Java/Solution673.java)
[873. 最长的斐波那契子序列的长度](https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/)|同时编写哈希函数避免哈希冲突，加快查找|[Java](../Java/Solution873.java)
[1027. 最长等差数列](https://leetcode.cn/problems/longest-arithmetic-subsequence/)|与[873. 最长的斐波那契子序列的长度](https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/)类似，但是会有哈希冲突，需要不一样的状态表现方式|[Java](../Java/Solution1027.java)

## 子数组的最大和
题目名称|说明|答案
:------|:---|:--:
[53. 最大子数组和](https://leetcode.cn/problems/maximum-subarray/submissions/)|~|[Java](../Java/Solution53.java) [Python](../Python/53.py)
[152. 乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray/)|用了两个dp数组分类讨论来表示状态|[Java](../Java/Solution152.java)
[918. 环形子数组的最大和](https://leetcode.cn/problems/maximum-sum-circular-subarray/)|难在环形数组的处理|[Java](../Java/Solution918.java)
[面试题 17.24. 最大子矩阵](https://leetcode.cn/problems/max-submatrix-lcci/)|二维最大连续子序和|[Java](../Java/Interview1724.java)

## 不相邻子序列的最大和
题目名称|说明|答案
:------|:---|:--:
[198. 打家劫舍](https://leetcode.cn/problems/house-robber/)|~|[Java](../Java/Solution198.java)
[213. 打家劫舍 II](https://leetcode.cn/problems/house-robber-ii/)|本质同[198. 打家劫舍](https://leetcode.cn/problems/house-robber/)相同，分为两种情况讨论即可|[Java](../Java/Solution213.java)
[740. 删除并获得点数](https://leetcode.cn/problems/delete-and-earn/)|本质同[198. 打家劫舍](https://leetcode.cn/problems/house-robber/)相同，需要进行问题转化|[Java](../Java/Solution740.java)
[1388. 3n 块披萨](https://leetcode.cn/problems/pizza-with-3n-slices/)|本质同[213. 打家劫舍 II](https://leetcode.cn/problems/house-robber-ii/)，难在将问题等价的转化|[Java](../Java/Solution1388.java)

## 买卖股票的最佳时机
题目名称|说明|答案
:------|:---|:--:
[121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/)|~|[Java](../Java/Solution121.java)
[122. 买卖股票的最佳时机 II](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/)|具有两个状态|[Java](../Java/Solution122.java)
[123. 买卖股票的最佳时机 III](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/)|通解是利用多状态动态规划，也可以分为2部分，每部分都用[121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/)的方法|[Java](../Java/Solution123.java)
[188. 买卖股票的最佳时机 IV](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/)|[123. 买卖股票的最佳时机 III](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/)的通解|[Java](../Java/Solution188.java)
[309. 最佳买卖股票时机含冷冻期](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/)|本质同[122. 买卖股票的最佳时机 II](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/)|[Java](../Java/Solution309.java)
[714. 买卖股票的最佳时机含手续费](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)|本质同[122. 买卖股票的最佳时机 II](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/)|[Java](../Java/Solution714.java)

## 其它
题目名称|说明|答案
:------|:---|:--:
[32. 最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses/)|~|[Java](../Java/Solution32.java)
[91. 解码方法](https://leetcode.cn/problems/decode-ways/)|分情况讨论状态转移|[Java](../Java/Solution91.java)
[132. 分割回文串 II](https://leetcode.cn/problems/palindrome-partitioning-ii/)|~|[Java](../Java/Solution132.java)
[338. 比特位计数](https://leetcode.cn/problems/counting-bits/)|~|[Java](../Java/Solution338.java) 
[413. 等差数列划分](https://leetcode.cn/problems/arithmetic-slices/)|由于要求连续子数组，使得状态转移简单一些|[Java](../Java/Solution413.java)

# 具有多种状态的DP问题
题目名称|说明|答案
:------|:---|:--:
[152. 乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray/)|~|[Java](../Java/Solution152.java)
[122. 买卖股票的最佳时机 II](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/)|~|[Java](../Java/Solution122.java)
[123. 买卖股票的最佳时机 III](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/)|分为了5种状态|[Java](../Java/Solution123.java)
[188. 买卖股票的最佳时机 IV](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/)|[123. 买卖股票的最佳时机 III](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/)的通解|[Java](../Java/Solution188.java)
[256. 粉刷房子](https://leetcode.cn/problems/paint-house/)|~|[Java](../Java/Solution256.java)
[265. 粉刷房子 II](https://leetcode.cn/problems/paint-house-ii/)|与[256. 粉刷房子](https://leetcode.cn/problems/paint-house/)相同|[Java](../Java/Solution265.java)
[309. 最佳买卖股票时机含冷冻期](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/)|本质与[122. 买卖股票的最佳时机 II](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/)相同|[Java](../Java/Solution309.java)
[403. 青蛙过河](https://leetcode.cn/problems/frog-jump/)|~|[Java](../Java/Solution403.java)
[410. 分割数组的最大值](https://leetcode.cn/problems/split-array-largest-sum/submissions/)|与[813. 最大平均值和的分组](https://leetcode.cn/problems/largest-sum-of-averages/)相同|[Java](./Java/410.java)
[673. 最长递增子序列的个数](https://leetcode.cn/problems/number-of-longest-increasing-subsequence/)|本质和[300. 最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/)相同，用了两个dp数组来维护状态|[Java](../Java/Solution673.java)
[714. 买卖股票的最佳时机含手续费](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)|本质同[122. 买卖股票的最佳时机 II](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/)|[Java](../Java/Solution714.java)
[813. 最大平均值和的分组](https://leetcode.cn/problems/largest-sum-of-averages/)|理解状态如何转移|[Java](../Java/Solution813.java)
[975. 奇偶跳](https://leetcode.cn/problems/odd-even-jump/)|就状态转移而言，这道题不难，难点在于利用单调栈简化表示|[Java](../Java/Solution975.java)
[1473. 粉刷房子 III](https://leetcode.cn/problems/paint-house-iii/)|多状态动态规划，状态比较好区分，就是稍微麻烦一点|[Java](../Java/Solution1473.java)
[1478. 安排邮筒](https://leetcode.cn/problems/allocate-mailboxes/)|需要进行数学分析|[Java](../Java/Solution1478.java)

# 双串问题
## 双串LCS问题
题目名称|说明|答案
:------|:---|:--:
[115. 不同的子序列](https://leetcode.cn/problems/distinct-subsequences/)|~|[Java](../Java/Solution115.java)
[583. 两个字符串的删除操作](https://leetcode.cn/problems/delete-operation-for-two-strings/)|本质是最长公共子序列，也可以利用编辑距离来做|[Java](../Java/Solution583.java)
[712. 两个字符串的最小ASCII删除和](https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/)|~|[Java](../Java/Solution712.java)
[718. 最长重复子数组](https://leetcode.cn/problems/maximum-length-of-repeated-subarray/)|双串问题可以考虑动态规划|[Java](../Java/Solution718.java)
[1143. 最长公共子序列](https://leetcode.cn/problems/longest-common-subsequence/)|经典的双串动态规划|[Java](../Java/Solution1143.java)

## 字符串匹配问题
题目名称|说明|答案
:------|:---|:--:
[10. 正则表达式匹配](https://leetcode.cn/problems/regular-expression-matching/)|~|[Java](../Java/Solution10.java)
[44. 通配符匹配](https://leetcode.cn/problems/wildcard-matching/)|~|[Java](../Java/Solution44.java)
[72. 编辑距离](https://leetcode.cn/problems/edit-distance/)|~|[Java](../Java/Solution72.java)

# 其它
[221. 最大正方形](https://leetcode.cn/problems/maximal-square/)|~|[Java](../Java/Solution221.java)
[312. 戳气球](https://leetcode.cn/problems/burst-balloons/)|状态转移的理解|[Java](../Java/Solution312.java)
[801. 使序列递增的最小交换次数](https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/)|状态转移不太好想|[Java](../Java/Solution801.java)

# 状态压缩DP
力扣相关问题:  
题目名称|说明|答案
:------|:---|:--:
[473. 火柴拼正方形](https://leetcode.cn/problems/matchsticks-to-square/)|~|~
[698. 划分为k个相等的子集](https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/)|~|~

# 树形的DP
题目名称|说明|答案
:------|:---|:--:
[250. 统计同值子树](https://leetcode.cn/problems/count-univalue-subtrees/)|~|[Java](../Java/Solution250.java)
[298. 二叉树最长连续序列](https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence/)|~|[Java](../Java/Solution298.java)
[337. 打家劫舍 III](https://leetcode.cn/problems/house-robber-iii/)|~|[Java](../Java/Solution337.java)
[549. 二叉树中最长的连续序列](https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence-ii/)|结合[298. 二叉树最长连续序列](https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence/)看|[Java](../Java/Solution549.java)
[687. 最长同值路径](https://leetcode.cn/problems/longest-univalue-path/)|结合[298. 二叉树最长连续序列](https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence/)看|[Java](./Java/Solution687.java)
[1372. 二叉树中的最长交错路径](https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/)|~|[Java](../Java/Solution1372.java)

# 记忆化搜索DP
题目名称|说明|答案
:------|:---|:--:
[87. 扰乱字符串](https://leetcode.cn/problems/scramble-string/)|递归搜索记录搜索值，思考如何将问题划分为更小的子问题的|[Java](../Java/Solution87.java)

# [背包问题](https://baike.baidu.com/item/%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98/2416931)
背包问题最基础的就是01背包了，一定要理解和掌握。  
## [0-1背包](https://baike.baidu.com/item/01%E8%83%8C%E5%8C%85/4301245)
力扣相关问题:  
题目名称|说明|答案
:------|:---|:--:
[416. 分割等和子集](https://leetcode.cn/problems/partition-equal-subset-sum/)|~|[Java](../Java/Solution416.java)
[494. 目标和](https://leetcode.cn/problems/target-sum/)|~|[Java](../Java/Solution494.java)
[879. 盈利计划](https://leetcode.cn/problems/profitable-schemes/)|~
[1049. 最后一块石头的重量 II](https://leetcode.cn/problems/last-stone-weight-ii/)|~
[1230. 抛掷硬币](https://leetcode.cn/problems/toss-strange-coins/)|~|[Java](../Java/Solution1230.java)
[2212. 射箭比赛中的最大得分](https://leetcode.cn/problems/maximum-points-in-an-archery-competition/solution/)|~

## [完全背包](https://baike.baidu.com/item/%E5%AE%8C%E5%85%A8%E8%83%8C%E5%8C%85/7066689)
力扣相关问题:  
题目名称|说明|答案
:------|:---|:--:
[279. 完全平方数](https://leetcode.cn/problems/perfect-squares/)|~|[Java](../Java/Solution279.java)
[322. 零钱兑换](https://leetcode.cn/problems/coin-change/)|~|[Java](../Java/Solution322.java)
[518. 零钱兑换 II](https://leetcode.cn/problems/coin-change-2/)|~|[Java](../Java/Solution518.java)
[1449. 数位成本和为目标值的最大数字](https://leetcode.cn/problems/form-largest-integer-with-digits-that-add-up-to-target/)|~