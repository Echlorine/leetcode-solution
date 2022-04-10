# leetcode-solution
A brief introduction to leetcode problems.  
Last Updated: 2022.04.10

**谨以此repo献给我的女朋友**，以及为了拿到心仪的offer一直不断拼搏的小伙伴。  
[面试索引](./Interview/Interview.md)根据面试考察的不同模块的知识进行了索引，让你准备更有针对性。  
`find_problem.sh`是一个小脚本，可以根据题号判断你是否做过这道题了。  

## Data Structures and Algorithms(持续更新)
* [DFS](./Data%20Structure%20and%20Algorithm/DFS/DFS.md): 深度优先遍历，适用于找到所有可能的解。可能会遇到超时的问题，这时候可以考虑动态规划。
* 背包问题
* 优先队列
  
## Shell  
力扣上`Shell`编程题不算多，可以点击[这里](./Shell/Shell.md)查看。应对笔试/面试，更多还是要学习相应数据结构与算法的知识。 
  
## 下面是力扣上每一道题及其考察的知识点(持续更新):  
题号|题目名称|考察知识点|说明|关联题型|答案
:--:|:-----:|:--------:|:---|:------|:-:
1|[两数之和](https://leetcode-cn.com/problems/two-sum/)|哈希表|Hash的思想：将键与值匹配，实现快速查找的效果|170|[Java](./Java/1.java)
2|[两数相加](https://leetcode-cn.com/problems/add-two-numbers/)|链表遍历|~|~|[Java](./Java/2.java)
3|[无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)|滑动窗口、**(前后)双指针**|~|76|[Java](./Java/2.java)
4|[寻找两个正序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)|二分查找|~|~|[Java](./Java/4.java)
5|[最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)|(字符串的)动态规划|这类动态规划题只能多练习掌握|10, 647|[Java](./Java/5.java)
6|[Z 字形变换](https://leetcode-cn.com/problems/zigzag-conversion/)|模拟|数学模拟，很朴素的思想|~|[Java](./Java/6.java)
7|[整数反转](https://leetcode-cn.com/problems/reverse-integer/)|模拟|~|~|[Python](./Python/7.py)
8|[字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)|**自动机**|很难想到的一个方法，编译原理里面的|~|[Java](./Java/8.java)
9|[回文数](https://leetcode-cn.com/problems/palindrome-number/)|模拟|~|~|[Python](./Python/9.py)
10|[正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/)|(字符串的)动态规划|只能多练找感觉|~|[Java](./Java/10.java)
11|[盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)|双指针模拟|~|~|[Java](./Java/11.java)
12|[整数转罗马数字](https://leetcode-cn.com/problems/integer-to-roman/)|模拟|~|13|[Java](./Java/12.java)
13|[罗马数字转整数](https://leetcode-cn.com/problems/roman-to-integer/)|模拟|~|12|[Python](./Python/13.py)
14|[最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix/)|**分治**，横向扫描、纵向扫描|掌握分治的思想|~|[Python](./Python/14.py)
15|[三数之和](https://leetcode-cn.com/problems/3sum/)|双指针|利用排序和双指针减少一次遍历|16, 18|[Java](./Java/15.java) [Python](./Python/15.py)
16|[最接近的三数之和](https://leetcode-cn.com/problems/3sum-closest/)|双指针|~|15, 18|[Java](./Java/16.java)
17|[电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/)|DFS|回溯方法很适合遍历找到所有解|46|[Java](./Java/17.java)
18|[四数之和](https://leetcode-cn.com/problems/4sum/)|双指针|~|15, 16|[Java](./Java/18.java)
19|[删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)|(前后)双指针|前后双指针的一个很巧妙的应用|~|[Java](./Java/19.java)
20|[有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)|栈|括号匹配的一个很经典的例子，用栈来实现|22, 32|[Python](./Python/20.py)
21|[合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)|递归、迭代|这道题的迭代也很经典|23|[Python](./Python/21.py)
22|[括号生成](https://leetcode-cn.com/problems/generate-parentheses/)|DFS|~|20, 32|[Java](./Java/22.java)
23|[合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)|分治、优先队列|**优先队列笔试挺喜欢考的**|21|[Java](./Java/23.java)
26|[删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)|(快慢)双指针|~|27, 88, 141|[Python](./Python/26.py)
27|[移除元素](https://leetcode-cn.com/problems/remove-element/)|(快慢)双指针|~|26, 88, 141|[Python](./Python/27.py)
28|[实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)|KMP算法|KMP算法是字符串匹配的经典算法，Python的find函数背后就是KMP|~|[Python](./Python/28.py)
29|[两数相除](https://leetcode-cn.com/problems/divide-two-integers/)|二分法|~|~|[Java](./Java/29.java)
31|[下一个排列](https://leetcode-cn.com/problems/next-permutation/)|扫描|思路不太容易想，但看了题解又觉得思想很朴素|~|[Java](./Java/31.java)
32|[最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)|动态规划|好几个括号题，但是思路都不一样|20, 22|[Java](./Java/32.java)
33|[搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)|二分查找|二分查找适合有序表的查找|34, 35|[Java](./Java/33.java)
34|[在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)|二分查找|~|33, 35|[Java](./Java/34.java)
35|[搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)|二分查找|一道不错的训练二分查找的题目|33, 34|[Python](./Python/35.py)
39|[组合总和](https://leetcode-cn.com/problems/combination-sum/)|DFS|~|~|[Java](./Java/39.java)
42|[接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)|动态规划，双指针|模拟也能解决问题|~|[Java](./Java/42.java)
46|[全排列](https://leetcode-cn.com/problems/permutations/)|DFS|~|17, 78, 79|[Java](./Java/46.java) [Python](./Python/46.py)
48|[旋转图像](https://leetcode-cn.com/problems/rotate-image/)|模拟|有技巧的模拟|~|[Java](./Java/48.java)
49|[字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)|Hash|此题需要对哈希以及哈希函数有更深的了解|1|[Java](./Java/49.java)
53|[最大子数组和](https://leetcode-cn.com/problems/maximum-subarray/)|动态规划|这道题也可以利用线段树来做|~|[Python](./Python/53.py)
55|[跳跃游戏](https://leetcode-cn.com/problems/jump-game/)|贪心，动态规划|~|~|[Python](./Java/55.java)
56|[合并区间](https://leetcode-cn.com/problems/merge-intervals/)|快速排序|~|~|[Java](./Java/56.java)
58|[最后一个单词的长度](https://leetcode-cn.com/problems/length-of-last-word/)|遍历|此题没什么难度|~|[Python](./Python/58.py)
62|[不同路径](https://leetcode-cn.com/problems/unique-paths/)|DFS，动态规划|DFS会超时，用动态规划|63, 64|[Java](./Java/62.java)
63|[不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)|DFS，动态规划|DFS会超时，用动态规划|62, 64|[Java](./Java/63.java)
64|[最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)|动态规划|~|62, 63|[Java](./Java/64.java)
66|[加一](https://leetcode-cn.com/problems/plus-one/)|模拟|~|~|[Python](./Python/66.py)
67|[二进制求和](https://leetcode-cn.com/problems/add-binary/)|位运算，模拟|模拟补位这个思想特挺好想的，位运算需要一定技巧，最好也掌握|137, 260, 421, 187, 318|[Python](./Python/67.py)
69|[x 的平方根](https://leetcode-cn.com/problems/sqrtx/)|模拟|牛顿迭代法是一个不错的方法，C语言课堂上也是这么教的|~|[Python](./Python/69.py)
70|[爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)|动态规划，递归|经典的递归题目，直接递归重复计算太多超时|~|[Python](./Python/70.py)
72|[编辑距离](https://leetcode-cn.com/problems/edit-distance/)|动态规划|挺不好理解的|~|[Java](./Java/72.java)
75|[颜色分类](https://leetcode-cn.com/problems/sort-colors/)|快速排序，模拟|用指针进行模拟更简单一些|~|[Java](./Java/75.java)
76|[最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)|滑动窗口|~|3|[Java](./Java/76.java)
78|[子集](https://leetcode-cn.com/problems/subsets/)|DFS|和46题一样，是一道DFS的经典题|46, 79|[Java](./Java/78.java)
79|[单词搜索](https://leetcode-cn.com/problems/word-search/)|DFS|~|46, 78|[Java](./Java/79.java)
84|[柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)|单调栈|思路比较容易想，但是**单调栈**这种数据结构不一定会应用|85|[Java](./Java/84.java)
85|[最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/)|单调栈|本质和84题居然相同，思路不太容易想|84|[Java](./Java/85.java)
88|[合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)|双指针|~|26, 27|[Python](./Python/88.py)
93|[复原 IP 地址](https://leetcode-cn.com/problems/restore-ip-addresses/)|回溯|利用IP特征，3层for循环是一个很朴素的思路|~|[Java](./Java/93.java)
94|[二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)|二叉树的遍历|二叉树的先根、中根、后根遍历本质都是DFS|98, 101|[Java](./Java/94.java)
96|[不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/)|动态规划，卡塔兰数|题目本质为知道中根遍历的结果，一共有多少种可能的二叉树。[卡塔兰数](https://baike.baidu.com/item/catalan/7605685)的应用|~|[Java](./Java/96.java)
98|[验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/solution/)|中根遍历|二叉搜索树的中根遍历结果是**递增**的|94, 98|[Java](./Java/98.java)
101|[对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)|二叉树的遍历|二叉树遍历的主要方法：直接**递归**、用**队列**模拟递归|94, 98|[Java](./Java/101.java)
102|[二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)|二叉树的层次遍历|层次遍历的本质是**BFS**|~|[Java](./Java/102.java)
104|[二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)|递归，DFS，BFS|还是喜欢递归的思路|~|[Java](./Java/104.java)
105|[从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)|利用先根遍历和中根遍历|配上Hash可以省去查找的时间|~|[Java](./Java/105.java)
114|[二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/)|先根遍历|这道题的思路有很多，个人还是喜欢递归，毕竟树的问题，一般都用递归解决|~|[Java](./Java/114.java)
118|[杨辉三角](https://leetcode-cn.com/problems/pascals-triangle/)|模拟|根据规律计算出来即可|~|[Java](./Java/118.java)
121|[买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)|~|思路和`53`题还挺像的|53|[Java](./Java/121.java)
124|[二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)|递归|这道题比较巧妙的地方在于每次递归的返回值和我们最终的结果有联系，但是不是同一个东西|~|[Java](./Java/124.java)
128|[最长连续序列](https://leetcode-cn.com/problems/longest-consecutive-sequence/)|Hash，[并查集](https://zhuanlan.zhihu.com/p/468711675)|查找型问题，利用Hash可以降低时间复杂度|1|[Java](./Java/128.java)
136|[只出现一次的数字](https://leetcode-cn.com/problems/single-number/)|位运算|异或运算满足交换律和结合律，异或运算也是一种常见的哈希函数|49|[Java](./Java/136.java)
139|[单词拆分](https://leetcode-cn.com/problems/word-break/)|动态规划|看到题目就会想到用动态规划来实现，不过状态转移方程不太好想|~|[Java](./Java/139.java)
141|[环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)|(快慢)双指针|这道题也可以当成查找已经访问的结点，用Hash做|26, 27, 88|[Java](./Java/141.java)
142|[环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)|(快慢)双指针|此处有重要的数学结论：环内相遇点到入环点的距离等于起点到入环点的距离|141, 287|[Java](./Java/142.java)
146|[LRU 缓存](https://leetcode-cn.com/problems/lru-cache/)|Hash，链表|要求查找和更新操作都要常数时间复杂度。因此需要兼具`Hash`和`链表`的特征|~|[Java](./Java/146.java)
148|[排序链表](https://leetcode-cn.com/problems/sort-list/)|归并排序|时间复杂度$O(n$$\log$$n)$|~|[Java](./Java/148.java)
152|[乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/)|动态规划|一下子维护了两个dp数组|53|[Java](./Java/152.java)
155|[最小栈](https://leetcode-cn.com/problems/min-stack/)|辅助栈|官方题解是通过辅助栈来实现一个最小栈的结构，额外空间复杂度大，而且有点取巧的感觉，建议用所给代码解法解决，空间复杂度为常数|~|[Java](./Java/155.java)
160|[相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)|Hash，数学|这道题的数学没见过类似题型的话，不太好想|~|[Java](./Java/160.java)
168|[Excel表列名称](https://leetcode-cn.com/problems/excel-sheet-column-title/)|模拟|10进制与26进制的转换，注意细节就好|~|[Java](./Java/168.java)
170|[两数之和 III - 数据结构设计](https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/)|Hash|~|1|[Java](./Java/170.java)
198|[打家劫舍](https://leetcode-cn.com/problems/house-robber/)|动态规划|利用**滚动数组**可以降低空间复杂度|~|[Java](./Java/198.java)
200|[岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)|DFS，BFS|并查集也可以解决这道题目，可以好好研究研究|128|[Java](./Java/200.java)
202|[快乐数](https://leetcode-cn.com/problems/happy-number/)|Hash，(快慢)双指针|掌握Hash和快慢双指针的思想。找规律也能很快做出来，甚至可以直接利用计算10次之后看结果是否为1进行判断|~|[Java](./Java/202.java)
206|[反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)|递归、迭代|~|~|[Java](./Java/206.java)
207|[课程表](https://leetcode-cn.com/problems/course-schedule/)|拓扑排序|图的相关知识，必须要会|网易笔试题考过|[Java](./Java/207.java)
208|[实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)|前缀树|学习前缀树这个模型，可能会对其他字符串类型的题提供解决思路|~|[Java](./Java/208.java)
221|[最大正方形](https://leetcode-cn.com/problems/maximal-square/)|动态规划|重点还是找到状态以及建立状态转移方程|1277|[Java](./Java/221.java)
226|[翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)|递归|遇到二叉树最先想到的就应该是递归|101|[Java](./Java/226.java)
234|[回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)|递归、快慢指针|这道题的递归方法可以更好的了解递归的作用机理|206|[Java](./Java/234.java)
236|[二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)|递归、哈希|对于有一一对应关系的数据存在，就应该想到哈希表|~|[Java](./Java/236.java)
238|[除自身以外数组的乘积](https://leetcode-cn.com/problems/product-of-array-except-self/)|左右乘积列表|学习一下这个思想|~|[Java](./Java/238.java)
239|[滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)|优先队列|~|253|[Java](./Java/239.java)
240|[搜索二维矩阵 II](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)|二分查找、Z 字形查找|Z 字形查找比二分查找更充分的利用矩阵的特点|~|[Java](./Java/240.java)
252|[会议室](https://leetcode-cn.com/problems/meeting-rooms/)|快速优先排序|快排是时间复杂度较低的排序算法|253|[Java](./Java/252.java)
253|[会议室 II](https://leetcode-cn.com/problems/meeting-rooms-ii/)|优先队列|`Java`中`PriorityQueue`是利用二叉堆实现的[优先队列](https://blog.csdn.net/lcore/article/details/9100073)|~|[Java](./Java/253.java)
279|[完全平方数](https://leetcode-cn.com/problems/perfect-squares/)|动态规划|这题属于完全背包问题|322,2212|[Java](./Java/279.java)
283|[移动零](https://leetcode-cn.com/problems/move-zeroes/)|双指针|此题有简易解法|~|[Java](./Java/283.java)
287|[寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number/)|二分查找，快慢指针|二分查找主要是问题的转化，知道自己需要找什么；快慢指针难点在于将数组转化为链表结构|142|[Java](./Java/287.java)
297|[二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)|二叉树的遍历|序列化与反序列化的关键在于空结点的存储|~|[Java](./Java/297.java)
300|[最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)|动态规划，贪心|~|~|[Java](./Java/300.java)
309|[最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)|动态规划|这道题的状态也需要好好构思一下|121, 122, 123, 188, 714|[Java](./Java/309.java)
312|[戳气球](https://leetcode-cn.com/problems/burst-balloons/)|动态规划|题目难点在于状态的建立和转移|~|[Java](./Java/312.java)
322|[零钱兑换](https://leetcode-cn.com/problems/coin-change/)|动态规划|完全背包问题|279|[Java](./Java/322.java)
337|[打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)|动态规划|树类型的动态规划和后序遍历结合起来用|~|[Java](./Java/337.java)
338|[比特位计数](https://leetcode-cn.com/problems/counting-bits/)|动态规划|~|~|[Java](./Java/338.java)
347|[前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)|优先队列|要求时间复杂度优于$O(n$$\log$$n)$，不能简单进行`sort()`|253|[Java](./Java/347.java)
406|[根据身高重建队列](https://leetcode-cn.com/problems/queue-reconstruction-by-height/)|排序|难点在于问题的转化|~|[Java](./Java/406.java)
437|[路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/)|前缀和|利用树的递归遍历是一个首选思路|560|[Java](./Java/437.java)
448|[找到所有数组中消失的数字](https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/)|~|~|155|[Java](./Java/448.java)
461|[汉明距离](https://leetcode-cn.com/problems/hamming-distance/)|位运算|题目本质就是统计一个数的二进制表示其中 1 的数目|338|[Java](./Java/461.java)
560|[和为 K 的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)|前缀和|~|437|[Java](./Java/560.java)
581|[最短无序连续子数组](https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/)|插入排序，双指针|无序数组中的最小值和最大值应该在的位置之间的长度即为答案|~|[Java](./Java/581.java)
617|[合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/)|递归|~|226|[Java](./Java/617.java)
647|[回文子串](https://leetcode-cn.com/problems/palindromic-substrings/)|中心扩展法|Manacher 算法不要求掌握|5|[Java](./Java/647.java)
739|[每日温度](https://leetcode-cn.com/problems/daily-temperatures/)|单调栈|如果需要找到左边或者右边第一个比当前位置的数大或者小，则可以考虑使用单调栈|84, 85|[Java](./Java/739.java)
1603|[设计停车系统](https://leetcode-cn.com/problems/design-parking-system/)|模拟|很简单的一道题|~|[Java](./Java/1603.java)