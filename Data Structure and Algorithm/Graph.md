## 图的表示
1. 矩阵表示
2. 邻接表

## 图的遍历
### 深度优先遍历
进阶题型: (不仅仅记录了某一结点是否访问过，还需要记录其它信息)  
题目名称|说明
:------|:---
[133. 克隆图](https://leetcode-cn.com/problems/clone-graph/)|涉及图的遍历与表示
[785. 判断二分图](https://leetcode-cn.com/problems/is-graph-bipartite/)|需要标记当前结点的颜色状态，需要保证当前结点的颜色与相邻结点不同
[802. 找到最终的安全状态](https://leetcode-cn.com/problems/find-eventual-safe-states/)|需要设置一个新的状态判断某一结点是否在环中
[886. 可能的二分法](https://leetcode-cn.com/problems/possible-bipartition/)|题目本质与785相同，记录的时候需要比较相邻结点的颜色信息

### 广度优先遍历

## 拓扑排序
在图论中，一个有向无环图必然存在至少一个拓扑序与之对应，反之亦然。  
题目名称|说明
:------|:---
[207. 课程表](https://leetcode-cn.com/problems/course-schedule/)|图的表示，拓扑排序
[210. 课程表 II](https://leetcode-cn.com/problems/course-schedule-ii/)|图的表示，拓扑排序
[802. 找到最终的安全状态](https://leetcode-cn.com/problems/find-eventual-safe-states/)|反向拓扑排序

## 关键路径
### AOE网
边表示活动(Activity)，边的权值表示活动的持续时间(Duration)，顶点称为事件(Event)，表示其入边的活动（或任务）已完成，出边的活动（任务）可开始的状态，这样的**有向、无环、加权图**为AOE网。

### 关键路径与关键活动
源点: 入度为0的点。
汇点: 出度为0的点。
关键路径: 从源点到汇点具有最大长度的路径称为关键路径。
关键活动: 关键路径上的活动称为关键活动，关键活动的最迟开始时间等于最早开始时间。

### 关键活动算法
1. 对AOE网进行**拓扑排序**，按拓扑次序求出各顶点事件的最早发生时间$ve$；若网中有回路终止算法;
2. 按拓扑序列的**逆序**求各顶点事件的最迟发生时间$vl$；
3. 根据$ve$和$vl$的值，求各活动的最早开始时间$e(i)$与最迟开始时间$l(i)$，若$e(i)=l(i)$，则 i 是关键活动。

题目名称|说明
:------|:---
[1136. 平行课程](https://leetcode-cn.com/problems/parallel-courses/)