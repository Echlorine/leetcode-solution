# 概述
贪心算法不是对所有问题都能得到整体最优解。能使用贪心算法解决的问题具有「贪心选择性质」。「贪心选择性质」严格意义上需要数学证明。能使用贪心算法解决的问题必须具备「无后效性」，即某个状态以前的过程不会影响以后的状态，只与当前状态有关。

1. 入门级例题:  

题目名称|说明|答案
:------|:---|:--:
[122. 买卖股票的最佳时机 II](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/)|贪心体现在只要下一天价格比上一天高，那就是利润|[Java](../Java/Solution122.java)
[392. 判断子序列](https://leetcode.cn/problems/is-subsequence/)|贪心的思想体现在每次选择左边匹配的字符|[Java](../Java/Solution392.java)
[455. 分发饼干](https://leetcode.cn/problems/assign-cookies/)|~|[Java](../Java/Solution455.java)
[561. 数组拆分 I](https://leetcode.cn/problems/array-partition-i/)|贪心在于每次选择的数尽可能接近|[Java](../Java/Solution561.java)
[860. 柠檬水找零](https://leetcode.cn/problems/lemonade-change/)|找零钱问题，贪心体现在让自己的5块钱数量尽可能多|[Java](../Java/Solution860.java)
[921. 使括号有效的最少添加](https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/)|贪心体现在对于每一个出现的右括号，前面必须保证有左括号与其匹配|[Java](../Java/Solution921.java)
[1217. 玩筹码](https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/)|贪心体现在尽可能多的移动偶数次|[Java](../Java/Solution1217.java)
[1400. 构造 K 个回文字符串](https://leetcode.cn/problems/construct-k-palindrome-strings/)|贪心体现在让奇数个字符分配到不同的回文串中|[Java](../Java/Solution1400.java)
[1605. 给定行和列的和求可行矩阵](https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/)|贪心体现在生成矩阵某一个位置的值的时候，让这个值尽可能大|[Java](../Java/Solution1605.java)
[1710. 卡车上的最大单元数](https://leetcode.cn/problems/maximum-units-on-a-truck/)|贪心体现在优先选择大箱子|[Java](../Java/Solution1710.java)
[2383. 赢得比赛需要的最少训练时长](https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/)|注意特殊情况|[Java](../Java/Solution2383.java)
[2384. 最大回文数字](https://leetcode.cn/problems/largest-palindromic-number/)|注意特殊情况的判断|[Java](../Java/Solution2384.java)

2. 进阶级例题:  

题目名称|说明|答案
:------|:---|:--:
[45. 跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/)|跳跃问题，每一步选择将来跳的远的格子|[Java](../Java/Solution45.java)
[55. 跳跃游戏](https://leetcode.cn/problems/jump-game/)|跳跃问题，此题贪心的是所能到达的最远距离|[Java](../Java/Solution55.java)
[68. 文本左右对齐](https://leetcode.cn/problems/text-justification/)|贪心体现在每一行的单词尽可能的多|[Java](../Java/Solution68.java)
[134. 加油站](https://leetcode.cn/problems/gas-station/)|贪心体现在每一次让车走的尽量远|[Java](../Java/Solution134.java)
[135. 分发糖果](https://leetcode.cn/problems/candy/)|在满足要求的情况下，每个孩子分到的糖果尽可能少|[Java](../Java/Solution135.java)
[300. 最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/)|区域选择问题|[Java](../Java/Solution300.java)
[402. 移掉 K 位数字](https://leetcode.cn/problems/remove-k-digits/)|每次删除较大的数|[Java](../Java/Solution402.java)
[435. 无重叠区间](https://leetcode.cn/problems/non-overlapping-intervals/)|与[300. 最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/)同为区域选择问题|[Java](../Java/Solution435.java)
[452. 用最少数量的箭引爆气球](https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/)|此题排序时需注意溢出|[Java](../Java/Solution452.java)
[738. 单调递增的数字](https://leetcode.cn/problems/monotone-increasing-digits/)|贪心体现在满足要求时让每一位的数字尽可能大|[Java](../Java/Solution738.java)
[763. 划分字母区间](https://leetcode.cn/problems/partition-labels/)|贪心每次所能到达的最远距离|[Java](../Java/Solution763.java)
[861. 翻转矩阵后的得分](https://leetcode.cn/problems/score-after-flipping-matrix/)|就行而言，1的位置尽可能靠左；就列而言，1的数量尽可能多|[Java](../Java/Solution861.java)

3. BOSS级例题:  

题目名称|说明|答案
:------|:---|:--:
[376. 摆动序列](https://leetcode.cn/problems/wiggle-subsequence/)|~|[Java](../Java/Solution376.java)
[673. 最长递增子序列的个数](https://leetcode.cn/problems/number-of-longest-increasing-subsequence/)
[354. 俄罗斯套娃信封问题](https://leetcode.cn/problems/russian-doll-envelopes/)