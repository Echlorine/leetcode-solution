# 面试中曾经遇到过的算法题
如果一个问题暂时没有思路，可以先考虑暴力解法。

题目名称|考察知识点|说明|答案|出题公司
:------|:--------|:---|:---|:------:
[25. K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/)|递归|思路是模拟，实现用递归或者迭代|[Java](../Java/Solution25.java)|字节跳动
[42. 接雨水](https://leetcode.cn/problems/trapping-rain-water/)|动态规划，双指针|~|[Java](../Java/Solution42.java)|字节跳动
[81. 搜索旋转排序数组 II](https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/)|二分查找|~|[Java](../Java/Solution81.java)|美团
[224. 基本计算器](https://leetcode.cn/problems/basic-calculator/)|栈|~|[Java](../Java/Solution224.java)|字节跳动
[227. 基本计算器 II](https://leetcode.cn/problems/basic-calculator-ii/)|栈|用栈模拟运算符的优先级|[Java](../Java/Solution227.java)|字节跳动
[772. 基本计算器 III](https://leetcode.cn/problems/basic-calculator-iii/)|栈|逆波兰表达式|[Java](../Java/Solution772.java)|字节跳动
[887. 鸡蛋掉落](https://leetcode.cn/problems/super-egg-drop/)|动态规划|~|[Java](../Java/Solution887.java)|字节跳动，考察了该题的数学解法


# 数学例题(Java)
题目名称|说明|答案
:------|:---|:--:
[319. 灯泡开关](https://leetcode.cn/problems/bulb-switcher/)|自己试几次也能发现规律|[Java](../Java/Solution319.java)

# 经典算法例题(Java)
## 二分查找
算法模板`nums[left] <= target < nums[right]`: 
```
while (left < right - 1) {
    int mid = (left + right) / 2;
    if (nums[mid] > target) {
        right = mid;
    }
    else {
        left = mid;
    }
}
```
算法模板`nums[left] < target <= nums[right]`
```
while (left < right - 1) {
    int mid = (left + right) / 2;
    if (nums[mid] < target) {
        left = mid;
    }
    else {
        right = mid;
    }
}
```
算法模板`nums[mid] == target`: 
```
while (left <= right) {
    int mid = (left + right) / 2;
    if (nums[mid] == target) return mid;
    else if (nums[mid] > target) {
        right = mid - 1;
    }
    else {
        left = mid + 1;
    }
}

```

例题:
题目名称|说明|答案
:------|:---|:--:
[162. 寻找峰值](https://leetcode.cn/problems/find-peak-element/)|本质是二分查找，不过需要讨论的情况多了点|[Java](../Java/Solution162.java)
[540. 有序数组中的单一元素](https://leetcode.cn/problems/single-element-in-a-sorted-array/submissions/)|先通过分析确定待查找下标的性质，从而确定如何二分查找|[Java](../Java/Solution540.java)
[852. 山脉数组的峰顶索引](https://leetcode.cn/problems/peak-index-in-a-mountain-array/)|二分查找的简单应用|[Java](../Java/Solution852.java)

## 翻转链表
```

```