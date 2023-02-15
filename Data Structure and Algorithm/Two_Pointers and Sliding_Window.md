# 双指针

## 快慢双指针
例题:
题目名称|说明|答案
:------|:---|:--:
[26. 删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/)|~|[Java](../Java/Solution26.java) [Python](../Python/26.py)
[27. 移除元素](https://leetcode.cn/problems/remove-element/)|~|[Java](../Java/Solution27.java) [Python](../Python/27.py)
[80. 删除有序数组中的重复项 II](https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/)|~|[Java](../Java/Solution80.java)
[283. 移动零](https://leetcode.cn/problems/move-zeroes/)|~|[Java](../Java/Solution283.java)
[674. 最长连续递增序列](https://leetcode.cn/problems/longest-continuous-increasing-subsequence/)|本题利用了贪心的思想，体现在以某一个元素开头的子序列尽可能长|[Java](../Java/Solution674.java)

## 左右双指针
多用于回文串相关的题，每次判断左指针和右指针是否相等或进行其他操作。

例题:
题目名称|说明|答案
:------|:---|:--:
[75. 颜色分类](https://leetcode.cn/problems/sort-colors/)|双指针模拟|[Java](../Java/Solution75.java)
[125. 验证回文串](https://leetcode.cn/problems/valid-palindrome/)|掌握转换大小写字符的API|[Java](../Java/Solution125.java)
[151. 颠倒字符串中的单词](https://leetcode.cn/problems/reverse-words-in-a-string/)|熟悉字符串的相关API|[Java](../Java/Solution151.java)
[186. 翻转字符串里的单词 II](https://leetcode.cn/problems/reverse-words-in-a-string-ii/)|~|[Java](../Java/Solution186.java)
[246. 中心对称数](https://leetcode.cn/problems/strobogrammatic-number/)|注意特殊情况处理|[Java](../Java/Solution246.java)
[344. 反转字符串](https://leetcode.cn/problems/reverse-string/)|~|[Java](../Java/Solution344.java)
[345. 反转字符串中的元音字母](https://leetcode.cn/problems/reverse-vowels-of-a-string/)|结合哈希表判断|[Java](../Java/Sloution345.java)
[541. 反转字符串 II](https://leetcode.cn/problems/reverse-string-ii/)|~|[Java](../Java/Solution541.java)
[557. 反转字符串中的单词 III](https://leetcode.cn/problems/reverse-words-in-a-string-iii/)|~|[Java](../Java/Solution557.java)
[633. 平方数之和](https://leetcode.cn/problems/sum-of-square-numbers/)|注意越界|[Java](../Java/Solution633.java)
[680. 验证回文字符串 Ⅱ](https://leetcode.cn/problems/valid-palindrome-ii/)|本质同[125. 验证回文串](https://leetcode.cn/problems/valid-palindrome/)|[Java](../Java/Solution680.java)
[917. 仅仅反转字母](https://leetcode.cn/problems/reverse-only-letters/)|~|[Java](../Java/Solution917.java)
[1332. 删除回文子序列](https://leetcode.cn/problems/remove-palindromic-subsequences/)|理解了题意，将问题转化就很好做|[Java](../Java/Solution1332.java)

## 其他

[349. 两个数组的交集](https://leetcode.cn/problems/intersection-of-two-arrays/)|可利用哈希表进行空间换时间|[Java](../Java/Solution349.java)
[350. 两个数组的交集 II](https://leetcode.cn/problems/intersection-of-two-arrays-ii/)|~|[Java](../Java/Solution350.java)
[1229. 安排会议日程](https://leetcode.cn/problems/meeting-scheduler/)|~|[Java](../Java/Solution1229.java)

# 滑动窗口
滑动窗口的题目经常和前缀和结合起来使用。

1. 入门级例题:  

题目名称|说明|答案
:------|:---|:--:
[209. 长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum/)|经典的滑动窗口的题目|[Java](../Java/Solution209.java)
[219. 存在重复元素 II](https://leetcode.cn/problems/contains-duplicate-ii/)|利用哈希表存储下标最大值也是一个好方法|[Java](../Java/Solution219.java)
[643. 子数组最大平均数 I](https://leetcode.cn/problems/maximum-average-subarray-i/)|每一次求和时，利用滑动窗口，更新降低时间复杂度|[Java](../Java/Solution643.java)
[1052. 爱生气的书店老板](https://leetcode.cn/problems/grumpy-bookstore-owner/)|本质同[643. 子数组最大平均数 I](https://leetcode.cn/problems/maximum-average-subarray-i/)|[Java](../Java/Solution1052.java)
[1423. 可获得的最大点数](https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/)|反向思考问题更简单|[Java](../Java/Solution1423.java)
[1456. 定长子串中元音的最大数目](https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/)|和[1052. 爱生气的书店老板](https://leetcode.cn/problems/grumpy-bookstore-owner/)类似|[Java](../Java/Solution1456.java)
[1658. 将 x 减到 0 的最小操作数](https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/)|同时处理前缀和及后缀和并用哈希表存储可降低时间复杂度|[Java](../Java/Solution1658.java)

2. 进阶级例题:  

题目名称|说明|答案
:------|:---|:--:
[76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/)|~|[Java](../Java/Solution76.java)
[424. 替换后的最长重复字符](https://leetcode.cn/problems/longest-repeating-character-replacement/)|~|[Java](../Java/Solution424.java)
[438. 找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/)|本题的计数技巧很经典|[Java](../Java/Solution438.java)
[487. 最大连续1的个数 II](https://leetcode.cn/problems/max-consecutive-ones-ii/)|结合[424. 替换后的最长重复字符](https://leetcode.cn/problems/longest-repeating-character-replacement/)一起看|[Java](../Java/Solution487.java)
[567. 字符串的排列](https://leetcode.cn/problems/permutation-in-string/)|***********|[Java](../Java/Solution567.java)
[978. 最长湍流子数组](https://leetcode.cn/problems/longest-turbulent-subarray/)|注意相等的时候左右边界同时移动|[Java](../Java/Solution978.java)
[1004. 最大连续1的个数 III](https://leetcode.cn/problems/max-consecutive-ones-iii/)|~|[Java](../Java/Solution1004.java)
[1208. 尽可能使字符串相等](https://leetcode.cn/problems/get-equal-substrings-within-budget/)|~|[Java](../Java/Solution1208.java)
[1234. 替换子串得到平衡字符串](https://leetcode.cn/problems/replace-the-substring-for-balanced-string/)|字符统计、滑动窗口|[Java](../Java/Solution1234.java)
[1493. 删掉一个元素以后全为 1 的最长子数组](https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/)|本质与[487. 最大连续1的个数 II](https://leetcode.cn/problems/max-consecutive-ones-ii/)相同|[Java](../Java/Solution1493.java)
[1695. 删除子数组的最大得分](https://leetcode.cn/problems/maximum-erasure-value/)|配合哈希表处理右滑边界|[Java](../Java/Solution1695.java)

```
//模板
/* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (char c : t.toCharArray()) 
        need.put(c,need.getOrDefault(c,0)+1);
	int left = 0, right = 0;
	int valid = 0; 
	while (right < s.size()) {
    	// c 是将移入窗口的字符
   	 	char c = s.charAt(right);
    	// 右移窗口
    	right++;
    	// 进行窗口内数据的一系列更新
    	...

    	/*** debug 输出的位置 ***/
    	System.out.println("window: ["+left+","+ right+")");
    	/********************/
    
    	// 判断左侧窗口是否要收缩
    	while (window needs shrink) {
        	// d 是将移出窗口的字符
        	char d = s[left];
        	// 左移窗口
        	left++;
        	// 进行窗口内数据的一系列更新
        	...
    	}
	}
}
//题解
class Solution {
    public String minWindow(String s, String t) {
        //1.维护两个map记录窗口中的符合条件的字符以及need的字符
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();//need中存储的是需要的字符以及需要的对应的数量
        for(char c : t.toCharArray())
            need.put(c,need.getOrDefault(c,0)+1);
        int left = 0,right = 0;//双指针
        int count = 0;//count记录当前窗口中符合need要求的字符的数量,当count == need.size()时即可shrik窗口
        int start = 0;//start表示符合最优解的substring的起始位序
        int len = Integer.MAX_VALUE;//len用来记录最终窗口的长度，并且以len作比较，淘汰选出最小的substring的len

        //一次遍历找“可行解”
        while(right < s.length()){
            //更新窗口
            char c = s.charAt(right);
            right++;//窗口扩大
            // window.put(c,window.getOrDefault(c,0)+1);其实并不需要将s中所有的都加入windowsmap，只需要将need中的加入即可
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c))){
                    count++;
                }
            }
            //System.out.println****Debug位置
            //shrink左边界，找符合条件的最优解
            while(count == need.size()){
                if(right - left < len){//不断“打擂”找满足条件的len最短值,并记录最短的子串的起始位序start
                    len = right - left;
                    start = left;
                }
                //更新窗口——这段代码逻辑几乎完全同上面的更新窗口
                char d = s.charAt(left);
                left++;//窗口缩小
                if(need.containsKey(d)){
                    //window.put(d,window.get(d)-1);——bug：若一进去就将window对应的键值缩小，就永远不会满足下面的if，while也会一直执行，知道left越界，因此，尽管和上面对窗口的处理几乎一样，但是这个处理的顺序还是很关键的！要细心！
                    if(need.get(d).equals(window.get(d))){
                        count--;
                    }
                    window.put(d,window.get(d)-1);
                    
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
    
}
```