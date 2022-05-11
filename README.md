# leetcode-solution
A brief introduction to leetcode problems.  
Last Updated: 2022.05.11

**谨以此repo献给我的女朋友**，以及为了拿到心仪的offer一直不断拼搏的小伙伴。  
[面试索引](./Interview/Interview.md)根据面试考察的不同模块的知识进行了索引，让你准备更有针对性。  
`find_problem.sh`是一个小脚本，可以根据题号判断你是否做过这道题了。  

## Data Structures and Algorithms(持续更新)
* [DFS](./Data%20Structure%20and%20Algorithm/DFS/DFS与回溯.md): 深度优先遍历，适用于找到所有可能的解。可能会遇到超时的问题，这时候可以考虑动态规划。
* [DP](./Data%20Structure%20and%20Algorithm/Dynamic_programming.md): 重点在于状态的建模以及状态转移方程的建立
* [Sort](./Data%20Structure%20and%20Algorithm/Sort/Sort.md): 总结了常见的排序算法
* [Disjoint_set](./Data%20Structure%20and%20Algorithm/Disjoint_set.md): 并查集，用于处理一些不相交集合的合并及查询问题
  
## Shell  
力扣上`Shell`编程题不算多，可以点击[这里](./Shell/Shell.md)查看。应对笔试/面试，更多还是要学习相应数据结构与算法的知识。 
  
## 力扣题库及其考察的知识点(持续更新):  
题目名称|考察知识点|说明|关联题型|答案
:------|:--------|:---|:-------|:-:
[1. 两数之和](https://leetcode-cn.com/problems/two-sum/)|哈希表|Hash的思想：将键与值匹配，实现快速查找的效果|170|[Java](./Java/1.java)
[2. 两数相加](https://leetcode-cn.com/problems/add-two-numbers/)|链表遍历|~|~|[Java](./Java/2.java)
[3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)|滑动窗口、**(前后)双指针**|~|76|[Java](./Java/2.java)
[4. 寻找两个正序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)|二分查找|~|~|[Java](./Java/4.java)
[5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)|(字符串的)动态规划|这类动态规划题只能多练习掌握|10, 647|[Java](./Java/5.java)
[6. Z 字形变换](https://leetcode-cn.com/problems/zigzag-conversion/)|模拟|数学模拟，很朴素的思想|~|[Java](./Java/6.java)
[7. 整数反转](https://leetcode-cn.com/problems/reverse-integer/)|模拟|~|~|[Python](./Python/7.py)
[8. 字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)|**自动机**|很难想到的一个方法，编译原理里面的|~|[Java](./Java/8.java)
[9. 回文数](https://leetcode-cn.com/problems/palindrome-number/)|模拟|~|~|[Python](./Python/9.py)
[10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/)|(字符串的)动态规划|只能多练找感觉|~|[Java](./Java/10.java)
[11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)|双指针模拟|~|~|[Java](./Java/11.java)
[12. 整数转罗马数字](https://leetcode-cn.com/problems/integer-to-roman/)|模拟|~|13|[Java](./Java/12.java)
[13. 罗马数字转整数](https://leetcode-cn.com/problems/roman-to-integer/)|模拟|~|12|[Python](./Python/13.py)
[14. 最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix/)|**分治**，横向扫描、纵向扫描|掌握分治的思想|~|[Python](./Python/14.py)
[15. 三数之和](https://leetcode-cn.com/problems/3sum/)|双指针|利用排序和双指针减少一次遍历|16, 18|[Java](./Java/15.java) [Python](./Python/15.py)
[16. 最接近的三数之和](https://leetcode-cn.com/problems/3sum-closest/)|双指针|~|15, 18|[Java](./Java/16.java)
[17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/)|回溯|回溯方法很适合遍历找到所有解|46|[Java](./Java/17.java)
[18. 四数之和](https://leetcode-cn.com/problems/4sum/)|双指针|~|15, 16|[Java](./Java/18.java)
[19. 删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)|(前后)双指针|前后双指针的一个很巧妙的应用|~|[Java](./Java/19.java)
[20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)|栈|括号匹配的一个很经典的例子，用栈来实现|22, 32|[Python](./Python/20.py)
[21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)|递归、迭代|这道题的迭代也很经典|23|[Java](./Java/21.java) [Python](./Python/21.py)
[22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)|回溯|~|20, 32|[Java](./Java/22.java)
[23. 合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)|分治、优先队列|**优先队列笔试挺喜欢考的**|21|[Java](./Java/23.java)
[24. 两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/)|迭代、递归|迭代更容易想到|~|[Java](./Java/24.java)
[25. K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/)|递归|思路是模拟，实现用递归或者迭代|24, 206|[Java](./Java/25.java)
[26. 删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)|(快慢)双指针|~|27, 88, 141|[Python](./Python/26.py)
[27. 移除元素](https://leetcode-cn.com/problems/remove-element/)|(快慢)双指针|~|26, 88, 141|[Python](./Python/27.py)
[28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)|KMP算法|KMP算法是字符串匹配的经典算法，Python的find函数背后就是KMP|~|[Python](./Python/28.py)
[29. 两数相除](https://leetcode-cn.com/problems/divide-two-integers/)|二分法|~|~|[Java](./Java/29.java)
[31. 下一个排列](https://leetcode-cn.com/problems/next-permutation/)|扫描|思路不太容易想，但看了题解又觉得思想很朴素|~|[Java](./Java/31.java)
[32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)|动态规划|好几个括号题，但是思路都不一样|20, 22|[Java](./Java/32.java)
[33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)|二分查找|二分查找适合有序表的查找|34, 35, 81|[Java](./Java/33.java)
[34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)|二分查找|~|33, 35|[Java](./Java/34.java)
[35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)|二分查找|一道不错的训练二分查找的题目|33, 34|[Python](./Python/35.py)
[36. 有效的数独](https://leetcode-cn.com/problems/valid-sudoku/)|~|难点在于数独行与列的表示|37|[Java](./Java/36.java)
[37. 解数独](https://leetcode-cn.com/problems/sudoku-solver/)|回溯|~|36|[Java](./Java/37.java)
[38. 外观数列](https://leetcode.cn/problems/count-and-say/)|模拟|答案二是面向测试用例编程|~|[Java](./Java/38.java)
[39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)|回溯|~|~|[Java](./Java/39.java)
[40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/)|回溯|需要剪枝|78|[Java](./Java/40.java)
[41. 缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive/)|~|~|287, 442, 448|[Java](./Java/41.java)
[42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)|动态规划，双指针|模拟也能解决问题|~|[Java](./Java/42.java)
[46. 全排列](https://leetcode-cn.com/problems/permutations/)|回溯|~|17, 77, 78|[Java](./Java/46.java) [Python](./Python/46.py)
[47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)|回溯|~|40, 46, 60|[Java](./Java/47.java)
[48. 旋转图像](https://leetcode-cn.com/problems/rotate-image/)|模拟|有技巧的模拟|~|[Java](./Java/48.java)
[49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)|计数，Hash|手动编写 Hash 函数的难点在于解决哈希冲突|1, 438|[Java](./Java/49.java)
[50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)|快速幂算法|分治思想，同时了解迭代思想背后的数学原理|~|[Java](./Java/50.java)
[51. N 皇后](https://leetcode-cn.com/problems/n-queens/)|回溯|学会使用位运算剪枝|52|[Java](./Java/51.java)
[52. N皇后 II](https://leetcode-cn.com/problems/n-queens-ii/)|回溯|~学会使用位运算剪|51|[Java](./Java/52.java)
[53. 最大子数组和](https://leetcode-cn.com/problems/maximum-subarray/)|动态规划|这道题也可以利用线段树来做|~|[Java](./Java/53.java) [Python](./Python/53.py)
[54. 螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/)|模拟|本质是遍历|~|[Java](./Java/54.java)
[55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)|贪心，动态规划|~|~|[Python](./Java/55.java)
[56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/)|快速排序|~|~|[Java](./Java/56.java)
[57. 插入区间](https://leetcode.cn/problems/insert-interval/)|模拟|~|56|[Java](./Java/57.java)
[58. 最后一个单词的长度](https://leetcode-cn.com/problems/length-of-last-word/)|遍历|此题没什么难度|~|[Python](./Python/58.py)
[59. 螺旋矩阵 II](https://leetcode.cn/problems/spiral-matrix-ii/)|模拟|~|54|[Java](./Java/59.java)
[60. 排列序列](https://leetcode.cn/problems/permutation-sequence/)|回溯|全排列的题目|46, 47|[Java](./Java/60.java)
[61. 旋转链表](https://leetcode-cn.com/problems/rotate-list/)|双指针|~|~|[Java](./Java/61.java)
[62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)|DFS，动态规划|DFS会超时，用动态规划|63, 64|[Java](./Java/62.java)
[63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)|DFS，动态规划|DFS会超时，用动态规划|62, 64|[Java](./Java/63.java)
[64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)|动态规划|~|62, 63|[Java](./Java/64.java)
[66. 加一](https://leetcode-cn.com/problems/plus-one/)|模拟|~|~|[Python](./Python/66.py)
[67. 二进制求和](https://leetcode-cn.com/problems/add-binary/)|位运算，模拟|模拟补位这个思想特挺好想的，位运算需要一定技巧，最好也掌握|137, 260, 421, 187, 318|[Python](./Python/67.py)
[69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/)|模拟|牛顿迭代法是一个不错的方法，C语言课堂上也是这么教的|~|[Python](./Python/69.py)
[70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)|动态规划，递归|经典的递归题目，直接递归重复计算太多超时|~|[Python](./Python/70.py)
[72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)|动态规划|挺不好理解的|~|[Java](./Java/72.java)
[73. 矩阵置零](https://leetcode.cn/problems/set-matrix-zeroes/)|模拟|利用数组自身的空间存储状态信息，节省空间|~|[Java](./Java/73.java)
[75. 颜色分类](https://leetcode-cn.com/problems/sort-colors/)|快速排序，模拟|用指针进行模拟更简单一些|~|[Java](./Java/75.java)
[76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)|滑动窗口|~|3|[Java](./Java/76.java)
[77. 组合](https://leetcode-cn.com/problems/combinations/)|回溯|有着不同的考虑问题的思路|78, 216|[Java](./Java/77.java)
[78. 子集](https://leetcode-cn.com/problems/subsets/)|回溯|和46题一样，是一道经典的回溯问题|46, 77|[Java](./Java/78.java)
[79. 单词搜索](https://leetcode-cn.com/problems/word-search/)|DFS|~|62, 63, 64, 200|[Java](./Java/79.java)
[81. 搜索旋转排序数组 II](https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/)|二分查找|~|33|[Java](./Java/81.java)
[82. 删除排序链表中的重复元素 II](https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/)|模拟|~|83|[Java](./Java/82.java)
[83. 删除排序链表中的重复元素](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/)|模拟|~|82|[Java](./Java/83.java)
[84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)|单调栈|思路比较容易想，但是**单调栈**这种数据结构不一定会应用|85|[Java](./Java/84.java)
[85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/)|单调栈|本质和84题居然相同，思路不太容易想|84|[Java](./Java/85.java)
[88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)|双指针|~|26, 27|[Python](./Python/88.py)
[89. 格雷编码](https://leetcode-cn.com/problems/gray-code/)|回溯，位运算|根据生成[公式](https://baike.baidu.com/item/%E6%A0%BC%E9%9B%B7%E7%A0%81#5)也可以直接生成|~|[Java](./Java/89.java)
[90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)|回溯|掌握二进制枚举这种思路|77, 78|[Java](./Java/90.java)
[92. 反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii/submissions/)|递归|~|25, 206|[Java](./Java/92.java)
[93. 复原 IP 地址](https://leetcode-cn.com/problems/restore-ip-addresses/)|回溯|利用IP特征，3层for循环是一个很朴素的思路|~|[Java](./Java/93.java)
[94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)|二叉树的遍历|二叉树的先根、中根、后根遍历本质都是DFS|98, 101|[Java](./Java/94.java)
[95. 不同的二叉搜索树 II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii/)|递归|树的问题，优先选择递归|~|[Java](./Java/95.java)
[96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/)|动态规划，卡塔兰数|题目本质为知道中根遍历的结果，一共有多少种可能的二叉树。[卡塔兰数](https://baike.baidu.com/item/catalan/7605685)的应用|~|[Java](./Java/96.java)
[98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/solution/)|中根遍历|二叉搜索树的中根遍历结果是**递增**的|94, 99|[Java](./Java/98.java)
[99. 恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree/)|中根遍历|找出交换的位置|94, 98|[Java](./Java/99.java)
[100. 相同的树](https://leetcode-cn.com/problems/same-tree/)|递归|也可以遍历|~|[Java](./Java/100.java)
[101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)|二叉树的遍历|二叉树遍历的主要方法：直接**递归**、用**队列**模拟递归|94, 98|[Java](./Java/101.java)
[102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)|二叉树的层次遍历|层次遍历的本质是**BFS**|~|[Java](./Java/102.java)
[104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)|递归，DFS，BFS|还是喜欢递归的思路|111, 257|[Java](./Java/104.java)
[105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)|利用先根遍历和中根遍历|配上Hash可以省去查找的时间|106, 1008, 1028|[Java](./Java/105.java)
[106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)|掌握后根遍历和中根遍历|~|105, 1008, 1028|[Java](./Java/106.java)
[108. 将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)|递归|高度平衡二叉搜索树|109|[Java](./Java/108.java)
[109. 有序链表转换二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/)|递归|高度平衡二叉搜索树，快速找链表的中间结点|108, 876|[ava](./Java/109.java)
[111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)|递归|可以采用DFS遍历并实时更新最短路径|104, 257|[Java](./Java/111.java)
[113. 路径总和 II](https://leetcode-cn.com/problems/path-sum-ii/)|DFS|树的遍历，递归思路|~|[Java](./Java/113.java)
[114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/)|先根遍历|这道题的思路有很多，个人还是喜欢递归，毕竟树的问题，一般都用递归解决|~|[Java](./Java/114.java)
[118. 杨辉三角](https://leetcode-cn.com/problems/pascals-triangle/)|模拟|根据规律计算出来即可|~|[Java](./Java/118.java)
[121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)|~|本质是动态规划|53, 122, 309|[Java](./Java/121.java)
[122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)|动态规划，贪心|多状态动态规划|309, 714|[Java](./Java/122.java)
[123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)|动态规划|通解是利用多状态动态规划，也可以分为2部分，每部分都用121的方法|121, 122, 309|[Java](./Java/123.java)
[124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)|递归|这道题比较巧妙的地方在于每次递归的返回值和我们最终的结果有联系，但是不是同一个东西|~|[Java](./Java/124.java)
[128. 最长连续序列](https://leetcode-cn.com/problems/longest-consecutive-sequence/)|Hash，[并查集](https://zhuanlan.zhihu.com/p/468711675)|查找型问题，利用Hash可以降低时间复杂度|1|[Java](./Java/128.java)
[129. 求根节点到叶节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)|树的遍历|DFS, BFS|~|[Java](./Java/129.java)
[130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)|DFS，BFS，并查集|本质是岛屿类问题，经典的DFS问题|695, 1020|[Java](./Java/130.java)
[131. 分割回文串](https://leetcode-cn.com/problems/palindrome-partitioning/)|回溯|~|~|[Java](./Java/131.java)
[133. 克隆图](https://leetcode-cn.com/problems/clone-graph/)|图的遍历|考察了图的表示以及遍历|~|[Java](./Java/133.java)
[136. 只出现一次的数字](https://leetcode-cn.com/problems/single-number/)|位运算|异或运算满足交换律和结合律，异或运算也是一种常见的哈希函数|49|[Java](./Java/136.java)
[139. 单词拆分](https://leetcode-cn.com/problems/word-break/)|动态规划|看到题目就会想到用动态规划来实现，不过状态转移方程不太好想|~|[Java](./Java/139.java)
[141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)|(快慢)双指针|这道题也可以当成查找已经访问的结点，用Hash做|26, 27, 88|[Java](./Java/141.java)
[142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)|(快慢)双指针|此处有重要的数学结论：环内相遇点到入环点的距离等于起点到入环点的距离|141, 287|[Java](./Java/142.java)
[143. 重排链表](https://leetcode-cn.com/problems/reorder-list/)|~|一道链表的综合题，解题思路较多|206, 876|[Java](./Java/143.java)
[144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)|遍历|二叉树的遍历|94, 145|[Java](./Java/144.java)
[145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)|遍历|二叉树的遍历|94, 144|[Java](./Java/145.java)
[146. LRU 缓存](https://leetcode-cn.com/problems/lru-cache/)|Hash，链表|要求查找和更新操作都要常数时间复杂度。因此需要兼具`Hash`和`链表`的特征|~|[Java](./Java/146.java)
[148. 排序链表](https://leetcode-cn.com/problems/sort-list/)|归并排序|时间复杂度$O({n\log_2n})$|~|[Java](./Java/148.java)
[152. 乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/)|动态规划|一下子维护了两个dp数组|53|[Java](./Java/152.java)
[155. 最小栈](https://leetcode-cn.com/problems/min-stack/)|辅助栈|官方题解是通过辅助栈来实现一个最小栈的结构，额外空间复杂度大，而且有点取巧的感觉，建议用所给代码解法解决，空间复杂度为常数|~|[Java](./Java/155.java)
[160. 相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)|Hash，数学|这道题的数学没见过类似题型的话，不太好想|~|[Java](./Java/160.java)
[163. 缺失的区间](https://leetcode-cn.com/problems/missing-ranges/)|遍历数组|模拟，注意边界即可|~|[Java](./Java/163.java)
[168. Excel表列名称](https://leetcode-cn.com/problems/excel-sheet-column-title/)|模拟|10进制与26进制的转换，注意细节就好|~|[Java](./Java/168.java)
[169. 多数元素](https://leetcode-cn.com/problems/majority-element/)|哈希表，**Boyer-Moore 投票算法**|~|~|[Java](./Java/169.java)
[170. 两数之和 III - 数据结构设计](https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/)|Hash|~|1|[Java](./Java/170.java)
[188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)|动态规划|~|123|[Java](../Java/188.java)
[198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)|动态规划|利用**滚动数组**可以降低空间复杂度|~|[Java](./Java/198.java)
[200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)|DFS，BFS，并查集|岛屿类问题|130, 695|[Java](./Java/200.java)
[202. 快乐数](https://leetcode-cn.com/problems/happy-number/)|Hash，(快慢)双指针|掌握Hash和快慢双指针的思想。找规律也能很快做出来，甚至可以直接利用计算10次之后看结果是否为1进行判断|~|[Java](./Java/202.java)
[206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)|递归、迭代|~|~|[Java](./Java/206.java)
[207. 课程表](https://leetcode-cn.com/problems/course-schedule/)|拓扑排序|图的相关知识，必须要会|210, 802|[Java](./Java/207.java)
[210. 课程表 II](https://leetcode-cn.com/problems/course-schedule-ii/)|拓扑排序|掌握正向的拓扑排序和逆向的拓扑排序|207, 802|[Java](./Java/210.java)
[208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)|前缀树|学习前缀树这个模型，可能会对其他字符串类型的题提供解决思路|~|[Java](./Java/208.java)
[213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/)|动态规划|分为两种情况讨论|198|[Java](./Java/213.java)
[215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)|选择排序|快速排序、堆排序|~|[Java](./Java/215.java)
[216. 组合总和 III](https://leetcode-cn.com/problems/combination-sum-iii/)|回溯|剪枝进一步优化时间|77|[Java](./Java/216.java)
[217. 存在重复元素](https://leetcode-cn.com/problems/contains-duplicate/)|哈希表|此题进一步优化，只要哈希表中存在当前值即可返回真|~|[Java](./Java/217.java)
[221. 最大正方形](https://leetcode-cn.com/problems/maximal-square/)|动态规划|重点还是找到状态以及建立状态转移方程|1277|[Java](./Java/221.java)
[226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)|递归|遇到二叉树最先想到的就应该是递归|101|[Java](./Java/226.java) [Python](./Python/226.py)
[234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)|递归、快慢指针|这道题的递归方法可以更好的了解递归的作用机理|206|[Java](./Java/234.java)
[236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)|递归、哈希|对于有一一对应关系的数据存在，就应该想到哈希表|~|[Java](./Java/236.java)
[238. 除自身以外数组的乘积](https://leetcode-cn.com/problems/product-of-array-except-self/)|左右乘积列表|学习一下这个思想|~|[Java](./Java/238.java)
[239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)|优先队列|~|253|[Java](./Java/239.java)
[240. 搜索二维矩阵 II](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)|二分查找、Z 字形查找|Z 字形查找比二分查找更充分的利用矩阵的特点|~|[Java](./Java/240.java)
[252. 会议室](https://leetcode-cn.com/problems/meeting-rooms/)|快速优先排序|快排是时间复杂度较低的排序算法|253|[Java](./Java/252.java)
[253. 会议室 II](https://leetcode-cn.com/problems/meeting-rooms-ii/)|优先队列|`Java`中`PriorityQueue`是利用二叉堆实现的[优先队列](https://blog.csdn.net/lcore/article/details/9100073)|~|[Java](./Java/253.java)
[256. 粉刷房子](https://leetcode-cn.com/problems/paint-house/)|动态规划|多状态动态规划|265|[Java](./Java/256.java)
[257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)|回溯|树的深度优先遍历|104, 111|[Java](./Java/257.java)
[265. 粉刷房子 II](https://leetcode-cn.com/problems/paint-house-ii/)|动态规划|~|256|[Java](./Java/265.java)
[278. 第一个错误的版本](https://leetcode-cn.com/problems/first-bad-version/)|二分查找|~|~|[Java](./Java/278.java)
[279. 完全平方数](https://leetcode-cn.com/problems/perfect-squares/)|动态规划|这题属于完全背包问题|322,2212|[Java](./Java/279.java) [Python](./Python/279.py)
[283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)|双指针|此题有简易解法|~|[Java](./Java/283.java)
[287. 寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number/)|二分查找，快慢指针|二分查找主要是问题的转化，知道自己需要找什么；快慢指针难点在于将数组转化为链表结构|142|[Java](./Java/287.java)
[297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)|二叉树的遍历|序列化与反序列化的关键在于空结点的存储|1028|[Java](./Java/297.java)
[300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)|动态规划，贪心|~|~|[Java](./Java/300.java)
[301. 删除无效的括号](https://leetcode-cn.com/problems/remove-invalid-parentheses/)|DFS, BFS|此题使用DFS难在问题的建模|20, 22|[Java](./Java/301.java)
[306. 累加数](https://leetcode-cn.com/problems/additive-number/)|回溯|难在问题的转化以及处理数据溢出|2|[Java](./Java/306.java)
[309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)|动态规划|这道题的状态也需要好好构思一下|121, 122, 123, 188, 714|[Java](./Java/309.java)
[312. 戳气球](https://leetcode-cn.com/problems/burst-balloons/)|动态规划|题目难点在于状态的建立和转移|~|[Java](./Java/312.java) [Python](./Python/312.py)
[322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)|动态规划|完全背包问题|279|[Java](./Java/322.java)
[323. 无向图中连通分量的数目](https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph/)|DFS|图的表示与遍历|207, 547|[Java](./Java/323.java)
[337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)|动态规划|树类型的动态规划和后序遍历结合起来用|~|[Java](./Java/337.java)
[338. 比特位计数](https://leetcode-cn.com/problems/counting-bits/)|动态规划|~|~|[Java](./Java/338.java) 
[347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)|优先队列|要求时间复杂度优于$O({n\log_2n})$，不能简单进行`sort()`|253|[Java](./Java/347.java)
[354. 俄罗斯套娃信封问题](https://leetcode-cn.com/problems/russian-doll-envelopes/)|动态规划|本质是LIS问题|300, 673, 406|[Java](./Java/354.java)
[357. 统计各位数字都不同的数字个数](https://leetcode-cn.com/problems/count-numbers-with-unique-digits/)|排列组合|这是一道数学问题|~|[Java](./Java/357.java)
[394. 字符串解码](https://leetcode-cn.com/problems/decode-string/)|栈|括号匹配的问题|20|[Java](./Java/394.java)
[403. 青蛙过河](https://leetcode-cn.com/problems/frog-jump/)|动态规划|~|~|[Java](./Java/403.java)
[406. 根据身高重建队列](https://leetcode-cn.com/problems/queue-reconstruction-by-height/)|排序|难点在于问题的转化|354|[Java](./Java/406.java)
[410. 分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum/submissions/)|动态规划|拆分连续数组的题目|813|[Java](./Java/410.java)
[416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)|动态规划|0-1背包问题|494, 1230|[Java](./Java/416.java)
[417. 太平洋大西洋水流问题](https://leetcode-cn.com/problems/pacific-atlantic-water-flow/)|回溯|本题通过反向搜索降低时间复杂度|~|[Java](./Java/417.java)
[437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/)|前缀和|利用树的递归遍历是一个首选思路|560|[Java](./Java/437.java)
[438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)|滑动窗口|~|49, 155, 448|[Java](./Java/438.java)
[448. 找到所有数组中消失的数字](https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/)|~|~|155|[Java](./Java/448.java) 
[461. 汉明距离](https://leetcode-cn.com/problems/hamming-distance/)|位运算|题目本质就是统计一个数的二进制表示其中 1 的数目|338|[Java](./Java/461.java)
[473. 火柴拼正方形](https://leetcode-cn.com/problems/matchsticks-to-square/)|回溯|~|~|[Java](./Java/473.java)
[494. 目标和](https://leetcode-cn.com/problems/target-sum/)|动态规划|0-1背包问题|416, 1230|[Java](./Java/494.java)
[518. 零钱兑换 II](https://leetcode-cn.com/problems/coin-change-2/)|动态规划|完全背包问题|~|[Java](./Java/518.java)
[529. 扫雷游戏](https://leetcode-cn.com/problems/minesweeper/)|回溯|本质是岛屿类问题，特殊之处在于一次有8个方向可以遍历|~|[Java](./Java/529.java)
[538. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)|中根遍历|转化问题，就很好解决|94|[Java](./Java/538.java)
[543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/)|DFS|~|~|[Java](./Java/543.java)
[547. 省份数量](https://leetcode-cn.com/problems/number-of-provinces/)|DFS，并查集|题目本质就是确定图的连通分量的数量|323|[Java](./Java/547.java)
[560. 和为 K 的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)|前缀和|~|437|[Java](./Java/560.java)
[581. 最短无序连续子数组](https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/)|插入排序，双指针|无序数组中的最小值和最大值应该在的位置之间的长度即为答案|~|[Java](./Java/581.java)
[589. N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)|树的前序遍历|掌握利用栈实现的思想|144|[Java](./Java/589.java)
[590. N 叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)|树的后序遍历|掌握利用栈实现的思想|145|[Java](./Java/590.java)
[617. 合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/)|递归|~|226|[Java](./Java/617.java)
[621. 任务调度器](https://leetcode-cn.com/problems/task-scheduler/)|模拟|~|~|[Java](./Java/621.java)
[647. 回文子串](https://leetcode-cn.com/problems/palindromic-substrings/)|中心扩展法|Manacher 算法不要求掌握|5|[Java](./Java/647.java)
[673. 最长递增子序列的个数](https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/)|动态规划|一下子维护两个dp数组|~|[Java](./Java/673.java)
[679. 24 点游戏](https://leetcode-cn.com/problems/24-game/)|回溯|这道题可以更好的理解回溯|~|[Java](./Java/679.java)
[684. 冗余连接](https://leetcode-cn.com/problems/redundant-connection/)|并查集|DFS也可以做|~|[Java](./Java/684.java)
[695. 岛屿的最大面积](https://leetcode-cn.com/problems/max-area-of-island/)|回溯|本质是岛屿类问题，经典的DFS问题|130, 200|[Java](./Java/695.java)
[698. 划分为k个相等的子集](https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/)|回溯|~|473|[Java](./Java/698.java)
[714. 买卖股票的最佳时机含手续费](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)|动态规划|具有两个状态的动态规划|122|[Java](./Java/714.java)
[739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/)|单调栈|如果需要找到左边或者右边第一个比当前位置的数大或者小，则可以考虑使用单调栈|84, 85|[Java](./Java/739.java)
[740. 删除并获得点数](https://leetcode-cn.com/problems/delete-and-earn/)|动态规划|问题的转化|198|[Java](./Java/740.java)
[784. 字母大小写全排列](https://leetcode-cn.com/problems/letter-case-permutation/)|回溯|~|~|[Java](./Java/784.java)
[785. 判断二分图](https://leetcode-cn.com/problems/is-graph-bipartite/)|DFS，并查集|~|802, 886|[Java](./Java/785.java)
[802. 找到最终的安全状态](https://leetcode-cn.com/problems/find-eventual-safe-states/)|DFS，拓扑排序|标准的深度优先遍历|207, 210, 785|[Java](./Java/802.java)
[804. 唯一摩尔斯密码词](https://leetcode-cn.com/problems/unique-morse-code-words/)|哈希表|`Java`中直接利用数组实现 hash 比`HashMap`速度快一点点|1|[Java](./Java/804.java)
[806. 写字符串需要的行数](https://leetcode-cn.com/problems/number-of-lines-to-write-string/)|模拟|~|~|[Java](./Java/806.java)
[813. 最大平均值和的分组](https://leetcode-cn.com/problems/largest-sum-of-averages/)|动态规划|理解状态如何转移|410|[Java](./Java/813.java)
[873. 最长的斐波那契子序列的长度](https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/)|动态规划，哈希|~|300|[Java](./Java/873.java)
[876. 链表的中间结点](https://leetcode-cn.com/problems/middle-of-the-linked-list/)|(快慢)双指针|~|26, 27, 141, 142, 287|[Java](./Java/876.java)
[886. 可能的二分法](https://leetcode-cn.com/problems/possible-bipartition/)|DFS，并查集|深度优先遍历，但遍历时需要记录其它信息|785|[Java](./Java/886.java)
[887. 鸡蛋掉落](https://leetcode.cn/problems/super-egg-drop/)|动态规划|思考方式很奇特的动态规划|~|[Java](./Java/887.java)
[918. 环形子数组的最大和](https://leetcode-cn.com/problems/maximum-sum-circular-subarray/)|动态规划|难在环形数组的处理，将环形数组分为两部分处理|53|[Java](./Java/918.java)
[1008. 前序遍历构造二叉搜索树](https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/)|递归|构建二叉树的题目|105, 106, 1028|[Java](./Java/1008.java)
[1020. 飞地的数量](https://leetcode-cn.com/problems/number-of-enclaves/)|DFS，BFS，并查集|本质是岛屿类问题，经典的DFS问题|130, 695|[Java](./Java/1020.java)
[1027. 最长等差数列](https://leetcode-cn.com/problems/longest-arithmetic-subsequence/)|动态规划|~|873|[Java](./Java/1027.java)
[1028. 从先序遍历还原二叉树](https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/)|根据遍历结果还原二叉树|~|105, 106, 297, 1008|[Java](./Java/1028.java)
[1034. 边界着色](https://leetcode-cn.com/problems/coloring-a-border/)|回溯|本质是岛屿类问题|130, 200, 1020|[Java](./Java/1034.java)
[1079. 活字印刷](https://leetcode-cn.com/problems/letter-tile-possibilities/)|回溯|本质是树结构|~|[Java](./Java/1079.java)
[1136. 平行课程](https://leetcode-cn.com/problems/parallel-courses/)|拓扑排序|运用了关键活动算法中求每一个事件的最早开始时间|207, 210, 802|[Java](./Java/1136.java)
[1230. 抛掷硬币](https://leetcode-cn.com/problems/toss-strange-coins/)|动态规划|0-1背包问题|416, 494|[Java](./Java/1230.java)
[1254. 统计封闭岛屿的数目](https://leetcode-cn.com/problems/number-of-closed-islands/)|回溯|岛屿问题的进阶，需要一些判断条件|200, 1020|[Java](./Java/1254.java)
[1388. 3n 块披萨](https://leetcode-cn.com/problems/pizza-with-3n-slices/)|动态规划|~|213|[Java](./Java/1388.java)
[1473. 粉刷房子 III](https://leetcode.cn/problems/paint-house-iii/)|动态规划|多状态动态规划|~|[Java](./Java/1473.java)
[1478. 安排邮筒](https://leetcode-cn.com/problems/allocate-mailboxes/)|动态规划|多维状态，同时需要进行数学分析|~|[Java](./Java/1478.java)
[1593. 拆分字符串使唯一子字符串的数目最大](https://leetcode-cn.com/problems/split-a-string-into-the-max-number-of-unique-substrings/)|回溯|~|~|[Java](./Java/1593.java)
[1603. 设计停车系统](https://leetcode-cn.com/problems/design-parking-system/)|模拟|很简单的一道题|~|[Java](./Java/1603.java)

## 剑指 Offer（第 2 版）题库及其考察的知识点(持续更新):  
题目名称|考察知识点|说明|关联题型|答案
:------|:--------|:---|:-------|:-:
[剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)|~|面试高频题|~|[Java](./Java/offer09.java)
[剑指 Offer 13. 机器人的运动范围](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)|回溯|迷宫类问题，需要根据题意在遍历时判断|~|[Java](./Java/offer13.java)
[剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)|递归，迭代|递归和迭代正好是相反的过程|~|[Java](./Java/offer10_I.java)

## 程序员面试金典（第 6 版）题库及其考察的知识点(持续更新):  
题目名称|考察知识点|说明|关联题型|答案
:------|:--------|:---|:-------|:-:
[面试题 17.24. 最大子矩阵](https://leetcode-cn.com/problems/max-submatrix-lcci/)|动态规划|最大连续子序和|~|[Java](./Java/Interview1724.java)