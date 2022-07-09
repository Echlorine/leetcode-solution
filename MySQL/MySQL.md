# 入门级例题

题目名称|答案|考察知识点|涉及的sql语句
:-------|:-:|:---------|:-
[595. 大的国家](https://leetcode.cn/problems/big-countries/)|[sql](595.sql)|~|select语句，where子句
[1757. 可回收且低脂的产品](https://leetcode.cn/problems/recyclable-and-low-fat-products/)|[sql](1757.sql)|~|select语句，where子句，and运算符
[584. 寻找用户推荐人](https://leetcode.cn/problems/find-customer-referee/)|[sql](584.sql)|sql的null值判断|select语句，where子句，or运算符
[183. 从不订购的客户](https://leetcode.cn/problems/customers-who-never-order/)|[sql](183.sql)|子查询|select语句，where子句，in操作符
[1873. 计算特殊奖金](https://leetcode.cn/problems/calculate-special-bonus/)|[sql](1873.sql)|~|select语句，where子句，sql 通配符，if表达式，order by 关键字
[627. 变更性别](https://leetcode.cn/problems/swap-salary/)|[sql](627.sql)|sql条件判断|update语句，if表达式，case when表达式
[196. 删除重复的电子邮箱](https://leetcode.cn/problems/delete-duplicate-emails/)|[sql](196.sql)|~|delete语句，自连接
[1667. 修复表中的名字](https://leetcode.cn/problems/fix-names-in-a-table/)|[sql](1667.sql)|~|select语句，字符串函数concat(), left(), substring(), lower(), upper()，order by 关键字
[1484. 按日期分组销售产品](https://leetcode.cn/problems/group-sold-products-by-the-date/)|[sql](1484.sql)|~|select语句，group by 语句，count()函数，group_concat()函数，order by 关键字
[1527. 患某种疾病的患者](https://leetcode.cn/problems/patients-with-a-condition/)|[sql](1527.sql)|~|select语句，like 操作符，sql 通配符，regexp运算符，正则表达式
[1965. 丢失信息的雇员](https://leetcode.cn/problems/employees-with-missing-information/)|[sql](1965.sql)|~|select语句，union 操作符，group by 语句，having 子句，order by 关键字
[1795. 每个产品在不同商店的价格](https://leetcode.cn/problems/rearrange-products-table/)|[sql](1795.sql)|横表转竖表|select语句，union 操作符
[608. 树节点](https://leetcode.cn/problems/tree-node/)|[sql](608.sql)|二叉树|select语句，if表达式，in操作符
[176. 第二高的薪水](https://leetcode.cn/problems/second-highest-salary/)|[sql](176.sql)|sql排序，sql去重|select语句，limit子句，distinct 关键字，group by 语句，order by 关键字
[175. 组合两个表](https://leetcode.cn/problems/combine-two-tables/)|[sql](175.sql)|sql表的连接|select语句，left join 关键字
[1581. 进店却未进行过交易的顾客](https://leetcode.cn/problems/customer-who-visited-but-did-not-make-any-transactions/)|[sql](1581.sql)|子查询，表的连接|select语句，group by 语句，count()函数，left join 关键字
[1148. 文章浏览 I](https://leetcode.cn/problems/article-views-i/)|[sql](1148.sql)|sql查询去重，sql排序|select语句，group by 语句，order by 关键字，distinct 关键字
[197. 上升的温度](https://leetcode.cn/problems/rising-temperature/)|[sql](197.sql)|sql表的连接|select语句，join 关键字，Date函数 datediff()
[607. 销售员](https://leetcode.cn/problems/sales-person/)|[sql](607.sql)|sql表的连接|select语句，join 关键字，in操作符
[1141. 查询近30天活跃用户数](https://leetcode.cn/problems/user-activity-for-the-past-30-days-i/)|[sql](1141.sql)|sql计数，sql去重|select语句，count()函数，Date函数 datediff()，group by 语句
[1693. 每天的领导和合伙人](https://leetcode.cn/problems/daily-leads-and-partners/)|[sql](1693.sql)|sql计数，sql去重|select语句，count()函数，distinct 关键字，group by 语句
[1729. 求关注者的数量](https://leetcode.cn/problems/find-followers-count/)|[sql](1729.sql)|sql计数|select语句，count()函数，group by 语句，order by 关键字
[586. 订单最多的客户](https://leetcode.cn/problems/customer-placing-the-largest-number-of-orders/)|[sql](586.sql)|sql计数，sql排序，sql返回行数限制|select语句，count()函数，group by 语句，having 子句，order by 关键字，limit子句
[511. 游戏玩法分析 I](https://leetcode.cn/problems/game-play-analysis-i/)|[sql](511.sql)|sql找最小值|select语句，min()函数，group by 语句
[1890. 2020年最后一次登录](https://leetcode.cn/problems/the-latest-login-in-2020/)|[sql](1890.sql)|sql日期处理，sql找最大值|select语句，max()函数，Date函数 datediff()，year()，group by 语句
[1741. 查找每个员工花费的总时间](https://leetcode.cn/problems/find-total-time-spent-by-each-employee/)|[sql](1741.sql)|sql求和|select语句，sum()函数，group by 语句
[1393. 股票的资本损益](https://leetcode.cn/problems/capital-gainloss/)|[sql](1393.sql)|sql求和，sql条件判断|select语句，sum()函数，if表达式，case when表达式，group by 语句
[1407. 排名靠前的旅行者](https://leetcode.cn/problems/top-travellers/)|[sql](1407.sql)|sql表的连接，sql求和，null值判断，条件判断，sql排序|select语句，if表达式，sum()函数，left join 关键字，group by 语句，order by 关键字
[1158. 市场分析 I](https://leetcode.cn/problems/market-analysis-i/)|[sql](1158.sql)|sql表的连接，sql计数，null值判断|select语句，if表达式，count()函数，left join 关键字，group by 语句
[182. 查找重复的电子邮箱](https://leetcode.cn/problems/duplicate-emails/)|[sql](182.sql)|sql数据筛选，sql计数|select语句，group by 语句，having 子句
[1050. 合作过至少三次的演员和导演](https://leetcode.cn/problems/actors-and-directors-who-cooperated-at-least-three-times/)|[sql](1050.sql)|sql分组，sql计数|select语句，group by 语句，having 子句，count()函数
[1587. 银行账户概要 II](https://leetcode.cn/problems/bank-account-summary-ii/)|[sql](1587.sql)|sql表的连接，sql求和，sql分组及筛选|select语句，sum()函数，join 关键字，group by 语句，having 子句
[1084. 销售分析III](https://leetcode.cn/problems/sales-analysis-iii/)|[sql](1084.sql)|sql表的连接，sql日期比较，sql分组及筛选|select语句，max()函数，min()函数，Date函数 datediff()，join 关键字，group by 语句，having 子句
[181. 超过经理收入的员工](https://leetcode.cn/problems/employees-earning-more-than-their-managers/)|[sql](181.sql)|sql表的连接|select语句，where子句，join 关键字

# 进阶级例题

题目名称|答案|考察知识点
:-------|:-:|:---------
[177. 第N高的薪水](https://leetcode.cn/problems/nth-highest-salary/)|[sql](177.sql)|sql排序，sql查询结果筛选
[178. 分数排名](https://leetcode.cn/problems/rank-scores/)|[sql](178.sql)|sql排序函数
[180. 连续出现的数字](https://leetcode.cn/problems/consecutive-numbers/)|[sql](180.sql)|sql多表连接
[184. 部门工资最高的员工](https://leetcode.cn/problems/department-highest-salary/)|[sql](184.sql)|sql表连接，sql子查询，sql in 操作符
[185. 部门工资前三高的所有员工](https://leetcode.cn/problems/department-top-three-salaries/)|[sql](185.sql)|sql表连接，sql子查询
[1173. 即时食物配送 I](https://leetcode.cn/problems/immediate-food-delivery-i/)|[sql](1173.sql)|sql保留小数位数，sql计数
[1193. 每月交易 I](https://leetcode.cn/problems/monthly-transactions-i/)|[sql](1193.sql)|sql日期格式化函数DATE_FORMAT(date,format)，in 操作符，sql计数，sql求和，if表达式
[1211. 查询结果的质量和占比](https://leetcode.cn/problems/queries-quality-and-percentage/)|[sql](1211.sql)|sql求和，sql保留小数位数，AVG() 函数
[1251. 平均售价](https://leetcode.cn/problems/average-selling-price/)|[sql](1251.sql)|sql计数，sql求和，sql保留小数位数
[1445. 苹果和桔子](https://leetcode.cn/problems/apples-oranges/)|[sql](1445.sql)|sql表连接
[1571. 仓库经理](https://leetcode.cn/problems/warehouse-manager/)|[sql](1571.sql)|sql求和，sql表连接
[1633. 各赛事的用户注册率](https://leetcode.cn/problems/percentage-of-users-attended-a-contest/)|[sql](1633.sql)|sql保留小数位数
[1699. 两人之间的通话次数](https://leetcode.cn/problems/number-of-calls-between-two-persons/)|[sql](1699.sql)|sql计数，sql求和，sql 函数 least(), greatest()

# MySQL函数
## MySQL四大排序函数
0. 初始表内容
```shell
mysql> SELECT * FROM study;
+----+--------+
| id | scores |
+----+--------+
|  1 |     68 |
|  2 |     98 |
|  3 |     78 |
|  4 |     98 |
|  5 |     87 |
|  6 |     73 |
|  7 |     84 |
+----+--------+
```
1. ROW_NUMBER(): 序号**连续、不重复**，即使遇到表中的两个一样的数值亦是如此，同时需要注意：在使用`row_number()`实现分页时`over`子句中的`order by`要与SQL排序记录中的`order by`保持一致，否则得到的序号可能不是连续的
```shell
mysql> SELECT id, scores, ROW_NUMBER() OVER(order by scores desc) as `rank` from study;
+----+--------+------+
| id | scores | rank |
+----+--------+------+
|  2 |     98 |    1 |
|  4 |     98 |    2 |
|  5 |     87 |    3 |
|  7 |     84 |    4 |
|  3 |     78 |    5 |
|  6 |     73 |    6 |
|  1 |     68 |    7 |
+----+--------+------+

mysql> SELECT id, scores, ROW_NUMBER() OVER(order by scores desc) as `rank` from study order by id;
+----+--------+------+
| id | scores | rank |
+----+--------+------+
|  1 |     68 |    7 |
|  2 |     98 |    1 |
|  3 |     78 |    5 |
|  4 |     98 |    2 |
|  5 |     87 |    3 |
|  6 |     73 |    6 |
|  7 |     84 |    4 |
+----+--------+------+
```

2. RANK(): 值相同的归为一组且**每组序号一样**，排序**不会连续执行**
```shell
mysql> SELECT id, scores, RANK() OVER(order by scores desc) as `rank` from study;
+----+--------+------+
| id | scores | rank |
+----+--------+------+
|  2 |     98 |    1 |
|  4 |     98 |    1 |
|  5 |     87 |    3 |
|  7 |     84 |    4 |
|  3 |     78 |    5 |
|  6 |     73 |    6 |
|  1 |     68 |    7 |
+----+--------+------+
```
3. DENSE_RANK(): 排序是**连续的**，也会把相同的值分为一组且**每组排序号一样**
```shell
mysql> SELECT id, scores, DENSE_RANK() OVER(order by scores desc) as `rank` from study;
+----+--------+------+
| id | scores | rank |
+----+--------+------+
|  2 |     98 |    1 |
|  4 |     98 |    1 |
|  5 |     87 |    2 |
|  7 |     84 |    3 |
|  3 |     78 |    4 |
|  6 |     73 |    5 |
|  1 |     68 |    6 |
+----+--------+------+
```
4. NTILE(group_num): 将所有记录分成`group_num`个组，**每组序号一样**
```shell
mysql> SELECT id, scores, NTILE(2) OVER(order by scores desc) as `rank` from study;
+----+--------+------+
| id | scores | rank |
+----+--------+------+
|  2 |     98 |    1 |
|  4 |     98 |    1 |
|  5 |     87 |    1 |
|  7 |     84 |    1 |
|  3 |     78 |    2 |
|  6 |     73 |    2 |
|  1 |     68 |    2 |
+----+--------+------+
```