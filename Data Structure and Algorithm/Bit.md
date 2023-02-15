### 位运算规则

| 符号 | 描述 | 运算规则                                                     |
| :--- | :--- | :----------------------------------------------------------- |
| &    | 与   | 两个位都为1时，结果才为1                                     |
| \|   | 或   | 两个位都为0时，结果才为0                                     |
| ^    | 异或 | 两个位相同为0，相异为1；<font color="blue">异或运算满足交换律、结合律</font> |
| ~    | 取反 | 0变1，1变0；<font color="blue">`~`运算符的优先级比算术运算符、关系运算符、逻辑运算符和其他运算符都高</font> |
| <<   | 左移 | 各二进位全部左移若干位，高位丢弃，低位补0                    |
| >>   | 右移 | 各二进位全部右移若干位，对无符号数，高位补0，有符号数，各编译器处理方法不一样，有的补符号位（算术右移），有的补0（逻辑右移） |

与运算的用途：

- 清零
- 取一个数的指定位
- 判断奇偶

或运算的用途：

- 将一个数的某些位设置为1

异或运算的用途：

- 翻转指定位
- 与0相异或值不变，与自身异或值为0
- 交换两个数

非运算的用途：

- 使一个数的最低位为0

### 位运算习题
题目名称|考察知识点|答案
:------|:---------|:-:
[136. 只出现一次的数字](https://leetcode.cn/problems/single-number/)|异或运算的性质|[Java](../Java/Solution136.java)
[137. 只出现一次的数字 II](https://leetcode.cn/problems/single-number-ii/)|位运算确定每一位数值为0还是1|[Java](../Java/Solution137.java)
[190. 颠倒二进制位](https://leetcode.cn/problems/reverse-bits/)|位运算分治|[Java](../Java/Solution190.java)
[191. 位1的个数](https://leetcode.cn/problems/number-of-1-bits/)|位运算|[Java](../Java/Solution191.java)
[672. 灯泡开关 Ⅱ](https://leetcode.cn/problems/bulb-switcher-ii/)|位运算，本质是穷举|[Java](../Java/Solution672.java)
