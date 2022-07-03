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