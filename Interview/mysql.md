# MySQL 连接
从命令行中连接mysql服务器: `mysql -h 地址 -P 端口 -u 用户名 -p 密码`  
退出 mysql> 命令提示窗口可以使用`exit`命令
```
echo@neko:~$ mysql [-h 127.0.0.1] [-P 3306] -u root -p******
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 157
Server version: 8.0.25 Source distribution

Copyright (c) 2000, 2021, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> exit
Bye
```

# 数据库操作
1. 查看当前数据库: `SELECT DATABASE();`
```
mysql> SELECT DATABASE();
+------------+
| DATABASE() |
+------------+
| NULL       |
+------------+
1 row in set (0.00 sec)
```

2. 显示当前时间、用户名、数据库版本: `SELECT now(), user(), version();`
```
mysql> SELECT now(), user(), version();
+---------------------+----------------+-----------+
| now()               | user()         | version() |
+---------------------+----------------+-----------+
| 2022-04-16 18:11:01 | root@localhost | 8.0.25    |
+---------------------+----------------+-----------+
1 row in set (0.00 sec)
```

3. 创建数据库: `CREATE DATABASE [IF NOT EXISTS] 数据库名`
```
mysql> CREATE DATABASE IF NOT EXISTS blogs;
Query OK, 1 row affected (0.01 sec)
```

4. 查看已有库: `SHOW DATABASES [LIKE 'PATTERN']`
```
mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| Disuz              |
| blogs              |
| information_schema |
| mysql              |
| performance_schema |
| runoob             |
| sys                |
+--------------------+
7 rows in set (0.00 sec)

mysql> SHOW DATABASES LIKE 'Disuz';
+------------------+
| Database (Disuz) |
+------------------+
| Disuz            |
+------------------+
1 row in set (0.00 sec)
```

5. 查看当前库信息: `SHOW CREATE DATABASE 数据库名`
```
mysql> SHOW CREATE DATABASE blogs;
+----------+---------------------------------------------------------------------------------------------------------------------------------+
| Database | Create Database                                                                                                                 |
+----------+---------------------------------------------------------------------------------------------------------------------------------+
| blogs    | CREATE DATABASE `blogs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */ |
+----------+---------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)
```

6. 删除库: `DROP DATABASE [IF EXISTS] 数据库名`
```
mysql> DROP DATABASE IF EXISTS runoob;
Query OK, 0 rows affected (0.01 sec)
```

# 表的操作
1. 创建表`CREATE [TEMPORARY] TABLE [IF NOT EXISTS] [库名.]表名 ( 表的结构定义 ) [表选项]`
创建MySQL数据表需要以下信息:
* 表名
* 表字段名
* 定义每个表字段: `字段名 数据类型 [NOT NULL | NULL] [DEFAULT default_value] [AUTO_INCREMENT] [UNIQUE [KEY] | [PRIMARY] KEY] [COMMENT 'string']`
```
mysql> use runoob;
Database changed
mysql> CREATE TABLE IF NOT EXISTS `runoob_tbl`(
    ->    `runoob_id` INT UNSIGNED AUTO_INCREMENT,
    ->    `runoob_title` VARCHAR(100) NOT NULL,
    ->    `runoob_author` VARCHAR(40) NOT NULL,
    ->    `submission_date` DATE,
    ->    PRIMARY KEY ( `runoob_id` )
    -> )ENGINE=InnoDB DEFAULT CHARSET=utf8;
Query OK, 0 rows affected, 1 warning (0.06 sec)
```

2. 查看表: `SHOW TABLES [LIKE 'pattern']`
```
mysql> SHOW TABLES FROM runoob;
+------------------+
| Tables_in_runoob |
+------------------+
| runoob_tbl       |
+------------------+
1 row in set (0.00 sec)

mysql> SHOW TABLES LIKE 'runoob_tbl';
+-------------------------------+
| Tables_in_runoob (runoob_tbl) |
+-------------------------------+
| runoob_tbl                    |
+-------------------------------+
1 row in set (0.01 sec)
```

3. 查看表结构
`SHOW CREATE TABLE 表名`, 展示信息更详细  
`DESC 表名 / DESCRIBE 表名 / EXPLAIN 表名`  
`SHOW COLUMNS FROM 表名 [LIKE 'PATTERN']`  
`SHOW TABLE STATUS [FROM db_name] [LIKE 'pattern']`
```
mysql> SHOW CREATE TABLE runoob_tbl;
+------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Table      | Create Table                                                                                                                                                                                                                                                               |
+------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| runoob_tbl | CREATE TABLE `runoob_tbl` (
  `runoob_id` int unsigned NOT NULL AUTO_INCREMENT,
  `runoob_title` varchar(100) NOT NULL,
  `runoob_author` varchar(40) NOT NULL,
  `submission_date` date DEFAULT NULL,
  PRIMARY KEY (`runoob_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 |
+------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)

mysql> DESC runoob_tbl;
+-----------------+--------------+------+-----+---------+----------------+
| Field           | Type         | Null | Key | Default | Extra          |
+-----------------+--------------+------+-----+---------+----------------+
| runoob_id       | int unsigned | NO   | PRI | NULL    | auto_increment |
| runoob_title    | varchar(100) | NO   |     | NULL    |                |
| runoob_author   | varchar(40)  | NO   |     | NULL    |                |
| submission_date | date         | YES  |     | NULL    |                |
+-----------------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

mysql> SHOW COLUMNS FROM runoob_tbl like 'runoob_id';
+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| runoob_id | int unsigned | NO   | PRI | NULL    | auto_increment |
+-----------+--------------+------+-----+---------+----------------+
1 row in set (0.00 sec)

mysql> SHOW TABLE STATUS FROM runoob LIKE 'runoob_tbl';
+------------+--------+---------+------------+------+----------------+-------------+-----------------+--------------+-----------+----------------+---------------------+-------------+------------+-----------------+----------+----------------+---------+
| Name       | Engine | Version | Row_format | Rows | Avg_row_length | Data_length | Max_data_length | Index_length | Data_free | Auto_increment | Create_time         | Update_time | Check_time | Collation       | Checksum | Create_options | Comment |
+------------+--------+---------+------------+------+----------------+-------------+-----------------+--------------+-----------+----------------+---------------------+-------------+------------+-----------------+----------+----------------+---------+
| runoob_tbl | InnoDB |      10 | Dynamic    |    0 |              0 |       16384 |               0 |            0 |         0 |              1 | 2022-04-16 19:12:57 | NULL        | NULL       | utf8_general_ci |     NULL |                |         |
+------------+--------+---------+------------+------+----------------+-------------+-----------------+--------------+-----------+----------------+---------------------+-------------+------------+-----------------+----------+----------------+---------+
1 row in set (0.00 sec)
```

4. 删除表: `DROP TABLE [IF EXISTS] 表名`
```
mysql> DROP TABLE IF EXISTS runoob_tbl;
Query OK, 0 rows affected (0.02 sec)
```

5. 清空表数据: `TRUNCATE [TABLE] 表名`
```
mysql> TRUNCATE runoob_tbl;
Query OK, 0 rows affected (0.04 sec)
```

# 数据操作(增, 查, 删, 改)
1. 增: `INSERT [INTO] 表名 [(字段列表)] VALUES (值列表)[, (值列表), ...]`, `INSERT [INTO] 表名 SET 字段名=值[, 字段名=值, ...]`
2. 查: `SELECT 字段列表 FROM 表名 [其他子句]`
3. 删: `DELETE FROM 表名 [删除条件子句]`
4. 改: `UPDATE 表名 SET 字段名=新值[, 字段名=新值] [更新条件]`
```
mysql> EXPLAIN test;
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| test_id    | int unsigned | NO   | PRI | NULL    | auto_increment |
| test_title | varchar(100) | NO   |     | NULL    |                |
| test_date  | date         | YES  |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)

mysql> select * from test;
Empty set (0.00 sec)

mysql> INSERT INTO test 
    -> (test_title, test_date)
    -> VALUES
    -> ("学习 MySQL", NOW());
Query OK, 1 row affected, 1 warning (0.00 sec)

mysql> select * from test;
+---------+--------------+------------+
| test_id | test_title   | test_date  |
+---------+--------------+------------+
|       1 | 学习 MySQL   | 2022-04-16 |
+---------+--------------+------------+
1 row in set (0.01 sec)

mysql> INSERT INTO test SET test_title="JAVA 教程", test_date=NOW();
Query OK, 1 row affected, 1 warning (0.00 sec)

mysql> select * from test;
+---------+--------------+------------+
| test_id | test_title   | test_date  |
+---------+--------------+------------+
|       1 | 学习 MySQL   | 2022-04-16 |
|       2 | JAVA 教程    | 2022-04-16 |
+---------+--------------+------------+
2 rows in set (0.00 sec)

mysql> DELETE FROM test;
Query OK, 2 rows affected (0.01 sec)

mysql> select * from test;
Empty set (0.00 sec)

```

# 字符集编码
1. 查看所有字符集编码项: `SHOW VARIABLES LIKE 'character_set_%';`
```
mysql> SHOW VARIABLES LIKE 'character_set_%';
+--------------------------+----------------------------------+
| Variable_name            | Value                            |
+--------------------------+----------------------------------+
| character_set_client     | utf8mb4                          |
| character_set_connection | utf8mb4                          |
| character_set_database   | utf8mb4                          |
| character_set_filesystem | binary                           |
| character_set_results    | utf8mb4                          |
| character_set_server     | utf8mb4                          |
| character_set_system     | utf8mb3                          |
| character_sets_dir       | /usr/local/mysql/share/charsets/ |
+--------------------------+----------------------------------+
8 rows in set (0.00 sec)
```

# 数据类型(列类型)
1. 数值类型

类型|大小|范围（有符号）|范围（无符号）|用途
:--|:---|:------------|:------------|:--
TINYINT|1 Bytes|(-128，127)|(0，255)|小整数值
SMALLINT|2 Bytes|(-32 768，32 767)|(0，65 535)|大整数值
MEDIUMINT|3 Bytes|(-8 388 608，8 388 607)|(0，16 777 215)|大整数值
INT或INTEGER|4 Bytes|(-2 147 483 648，2 147 483 647)|(0，4 294 967 295)|大整数值
BIGINT|8 Bytes|(-9,223,372,036,854,775,808，9 223 372 036 854 775 807)|(0，18 446 744 073 709 551 615)|极大整数值
FLOAT|4 Bytes|(-3.402 823 466 E+38，-1.175 494 351 E-38)，0，(1.175 494 351 E-38，3.402 823 466 351 E+38)|0，(1.175 494 351 E-38，3.402 823 466 E+38)|单精度 浮点数值
DOUBLE|8 Bytes|(-1.797 693 134 862 315 7 E+308，-2.225 073 858 507 201 4 E-308)，0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308)|0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308)|双精度 浮点数值
DECIMAL|对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2|依赖于M和D的值|依赖于M和D的值|小数值

2. 日期和时间类型

类型|大小|范围|格式|用途
:--|:-----------|:---|:--|:---
DATE|3 bytes|1000-01-01/9999-12-31|YYYY-MM-DD|日期值
TIME|3 bytes|'-838:59:59'/'838:59:59'|HH:MM:SS|时间值或持续时间
YEAR|1 bytes|1901/2155|YYYY|年份值
DATETIME|8 bytes|1000-01-01 00:00:00/9999-12-31 23:59:59|YYYY-MM-DD HH:MM:SS|混合日期和时间值
TIMESTAMP|4 bytes|1970-01-01 00:00:00/2038 结束时间是第 2147483647 秒，北京时间 2038-1-19 11:14:07，格林尼治时间 2038年1月19日 凌晨 03:14:07|YYYYMMDD HHMMSS|混合日期和时间值，时间戳

3. 字符串类型

类型|大小|用途
:---|:--|:--
CHAR|0-255 bytes|定长字符串
VARCHAR|0-65535 bytes|变长字符串
TINYBLOB|0-255 bytes|不超过 255 个字符的二进制字符串
TINYTEXT|0-255 bytes|短文本字符串
BLOB|0-65 535 bytes|二进制形式的长文本数据
TEXT|0-65 535 bytes|长文本数据
MEDIUMBLOB|0-16 777 215 bytes|二进制形式的中等长度文本数据
MEDIUMTEXT|0-16 777 215 bytes|中等长度文本数据
LONGBLOB|0-4 294 967 295 bytes|二进制形式的极大文本数据
LONGTEXT|0-4 294 967 295 bytes|极大文本数据

# 列属性(列约束)
1. PRIMARY 主键:
   * 一个表只能有一个主键。
   * 主键具有唯一性。
   * 主键字段的值不能为null。
2. UNIQUE 唯一索引（唯一约束）
   * 某字段的值也不能重复。
3. NULL 约束
4. DEFAULT 默认值属性
5. AUTO_INCREMENT 自动增长约束
   * 自动增长必须为索引（主键或unique）
   * 只能存在一个字段为自动增长。
6. COMMENT 注释

# SELECT
MySQL 数据库使用SQL SELECT语句来查询数据: `SELECT [ALL|DISTINCT] select_expr FROM -> WHERE -> GROUP BY [合计函数] -> HAVING -> ORDER BY -> LIMIT`
1. select_expr
   - 可以用 * 表示所有字段
   - 可以使用表达式（计算公式、函数调用、字段也是个表达式）
   - 可以使用 as 关键字为每个列使用别名，从而简化列标识， as 关键字也可省略
2. FROM 子句，用于标识查询来源
   - 可以使用 as 关键字为表起别名
   - 可以同时出现多个表，多个表会横向叠加到一起，而数据会形成一个笛卡尔积
3. WHERE 子句，从from获得的数据源中进行筛选
   - 整型1表示真，0表示假
   - 表达式由运算符和运算数组成
4. GROUP BY 子句, 分组子句
5. HAVING 子句，条件子句
6. ORDER BY 子句，排序子句
   - 升序：ASC，降序：DESC
8. LIMIT 子句，限制结果数量子句
9. DISTINCT, ALL 选项
```
mysql> select * from test;
+---------+--------------+------------+
| test_id | test_title   | test_date  |
+---------+--------------+------------+
|       1 | 学习 MySQL   | 2022-04-18 |
|       2 | JAVA 教程    | 2022-04-18 |
|       3 | MySQL 教程   | 2022-04-18 |
+---------+--------------+------------+
3 rows in set (0.00 sec)

mysql> select test_id as id  from test where test_id>1;
+----+
| id |
+----+
|  2 |
|  3 |
+----+
2 rows in set (0.00 sec)
```

# UNION
将多个select查询的结果组合成一个结果集合 

# 子查询
1. from型
   - from后要求是一个表，必须给子查询结果取个别名
   - from型需将结果生成一个临时表格，可用以原表的锁定的释放
   - 子查询返回一个表，表型子查询
2. where型
   - 子查询返回一个值，标量子查询
   - 不需要给子查询取别名
   - where子查询内的表，不能直接用以更新

# join
连接查询(join)将多个表的字段进行连接，可以指定连接条件
1. 内连接(inner join)
2. 外连接(outer join)
3. 自然连接(natural join)

# TRUNCATE
TRUNCATE 清空数据，删除重建表: `TRUNCATE [TABLE] tbl_name`  
TRUNCATE 与 delete 区别:
1. truncate 是删除表再创建，delete 是逐条删除
2. truncate 重置auto_increment的值。而delete不会
3. truncate 不知道删除了几条，而delete知道
4. 当被用于带分区的表时，truncate 会保留分区
```
mysql> select * from test;
+---------+--------------+------------+
| test_id | test_title   | test_date  |
+---------+--------------+------------+
|       1 | 学习 MySQL   | 2022-04-18 |
|       2 | JAVA 教程    | 2022-04-18 |
|       3 | MySQL 教程   | 2022-04-18 |
+---------+--------------+------------+
3 rows in set (0.00 sec)

mysql> DELETE FROM test where test_id=3;
Query OK, 1 row affected (0.01 sec)

mysql> select * from test;
+---------+--------------+------------+
| test_id | test_title   | test_date  |
+---------+--------------+------------+
|       1 | 学习 MySQL   | 2022-04-18 |
|       2 | JAVA 教程    | 2022-04-18 |
+---------+--------------+------------+
2 rows in set (0.00 sec)

mysql> INSERT INTO test SET test_title="MySQL 教程", test_date=NOW();
Query OK, 1 row affected, 1 warning (0.01 sec)

mysql> select * from test;
+---------+--------------+------------+
| test_id | test_title   | test_date  |
+---------+--------------+------------+
|       1 | 学习 MySQL   | 2022-04-18 |
|       2 | JAVA 教程    | 2022-04-18 |
|       4 | MySQL 教程   | 2022-04-18 |
+---------+--------------+------------+
3 rows in set (0.00 sec)

mysql> TRUNCATE TABLE test;
Query OK, 0 rows affected (0.03 sec)

mysql> select * from test;
Empty set (0.00 sec)

mysql> INSERT INTO test SET test_title="MySQL 教程", test_date=NOW();
Query OK, 1 row affected, 1 warning (0.01 sec)

mysql> select * from test;
+---------+--------------+------------+
| test_id | test_title   | test_date  |
+---------+--------------+------------+
|       1 | MySQL 教程   | 2022-04-18 |
+---------+--------------+------------+
1 row in set (0.00 sec)
```

# 备份与还原
1. 导出，利用 mysqldump 指令完成
   - 备份表: `mysqldump [options] db_name [tables]`
   - 备份库: `mysqldump [options] --databases DB1 [DB2 DB3...]`
   - 备份所有库: `mysqldump [options] --all-databases`
2. 导入
   - 在登录mysql的情况下: `source 备份文件`
   - 在不登录的情况下: `mysql -u用户名 -p密码 库名 < 备份文件`
```
(base) echo@neko:~$ mysqldump -u root -p****** --databases runoob > runoob.sql
mysqldump: [Warning] Using a password on the command line interface can be insecure.
(base) echo@neko:~$ 
(base) echo@neko:~$ mysql -h 127.0.0.1 -P 3306 -u root -p******
mysql: [Warning] Using a password on the command line interface can be insecure.
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 181
Server version: 8.0.25 Source distribution

Copyright (c) 2000, 2021, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> DROP DATABASE runoob;
Query OK, 2 rows affected (0.03 sec)

mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| Disuz              |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.00 sec)

mysql> source /home/echo/runoob.sql;
Query OK, 0 rows affected (0.02 sec)

Query OK, 1 row affected (0.01 sec)

Database changed
Query OK, 0 rows affected (0.00 sec)

Query OK, 0 rows affected, 1 warning (0.03 sec)

Query OK, 0 rows affected (0.00 sec)

Query OK, 0 rows affected, 1 warning (0.03 sec)

Query OK, 0 rows affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 0 rows affected (0.01 sec)

mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| Disuz              |
| information_schema |
| mysql              |
| performance_schema |
| runoob             |
| sys                |
+--------------------+
6 rows in set (0.00 sec)
```

# 视图
## 定义:
1. 视图是存储在数据库中的查询的sql语句，它主要出于两种原因:
   - 安全原因，视图可以隐藏一些数据，如：社会保险基金表，可以用视图只显示姓名，地址，而不显示社会保险号和工资数等，
   - 另一原因是可使复杂的查询易于理解和使用。
2. 图是一个虚拟表，其内容由查询定义。同真实的表一样，视图包含一系列带有名称的列和行数据，行和列数据来自由定义视图的查询所引用的表，并且在引用视图时动态生成。
3. 视图具有表结构文件，但不存在数据文件。

## 作用:
1. 简化业务逻辑
2. 对客户端隐藏真实的表结构
   
## 相关操作
1. 创建视图: `CREATE [OR REPLACE] [ALGORITHM = {UNDEFINED | MERGE | TEMPTABLE}] VIEW view_name [(column_list)] AS select_statement;`
2. 查看结构: `SHOW CREATE VIEW view_name;`
3. 删除视图: `ROP VIEW [IF EXISTS] view_name ...`
4. 修改视图结构: `ALTER VIEW view_name [(column_list)] AS select_statement`

# 事务(transaction) 事务是指逻辑上的一组操作，组成这组操作的各个单元，要不全成功要不全失败
1. 事务开启: `START TRANSACTION;` 或者 `BEGIN;`
2. 事务提交: `COMMIT;`
3. 事务回滚: `ROLLBACK;`
```
mysql> SELECT * from test;
+---------+---------------+------------+
| test_id | test_title    | test_date  |
+---------+---------------+------------+
|       1 | MySQL 教程    | 2022-04-18 |
|       2 | Java 教程     | 2022-04-20 |
|       3 | Spring 教程   | 2022-04-19 |
+---------+---------------+------------+
3 rows in set (0.00 sec)

mysql> BEGIN;
Query OK, 0 rows affected (0.00 sec)

mysql> UPDATE test SET test_date="2022-03-22" where test_id = 3;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE test SET test_date="2022-03-25" where test_id = 2;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> COMMIT;
Query OK, 0 rows affected (0.00 sec)

mysql> SELECT * from test;
+---------+---------------+------------+
| test_id | test_title    | test_date  |
+---------+---------------+------------+
|       1 | MySQL 教程    | 2022-04-18 |
|       2 | Java 教程     | 2022-03-25 |
|       3 | Spring 教程   | 2022-03-22 |
+---------+---------------+------------+
3 rows in set (0.00 sec)
```

# 缩表与解锁
1. 锁定: `LOCK TABLES tbl_name [AS alias];`
2. 解锁: `UNLOCK TABLES;`

# 触发器