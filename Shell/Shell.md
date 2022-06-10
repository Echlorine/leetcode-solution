# Shell
A brief introduction to shell problems in leetcode.  

此处是力扣上为数不多的`Shell`编程题目的答案。

各考题知识点梳理
题号|题目名称|考察知识点|说明|答案
:--:|:-----:|:--------:|:--|:-:
192|[统计词频](https://leetcode-cn.com/problems/word-frequency/)|sort, uniq, sed, awk|考察了管道的知识，还有文本处理以及排序的命令|[Shell](./192.sh)
193|[有效电话号码](https://leetcode-cn.com/problems/valid-phone-numbers/)|grep, 正则表达式|正则表达式早晚都要掌握|[Shell](./193.sh)
194|[转置文件](https://leetcode-cn.com/problems/transpose-file/)|xargs, awk|`xargs`这个神奇的命令|[Shell](./194.sh)
195|[第十行](https://leetcode-cn.com/problems/tenth-line/)|sed|~|[Shell](./195.sh)
  
更多Shell相关命令与工具可以看这篇[shell](https://www.runoob.com/linux/linux-shell.html)教程。  

下面简单说一下Linux下经典的文本处理工具:  
- grep 更适合单纯的**查找**或匹配文本
- sed 更适合**编辑**匹配到的文本
- awk 更适合**格式化文本**，对文本进行较复杂格式处理