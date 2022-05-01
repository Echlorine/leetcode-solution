# 不相交集(并查集)
## 描述
并查集是一种树型的数据结构，用于处理一些不相交集合的合并及查询问题。并查集用一个数组表示了整片森林（parent），树的根节点唯一标识了一个集合。**初始状态通常是每一个元素构成一个单元素集合**。

## 并查集的基础操作
0. 初始化: 把每一个元素构成一个单元素集合
```
// 初始化并查集
int[] parent = new int[isConnected.length];
for(int i = 0; i < isConnected.length; i++) {
    parent[i] = i;
}
```
1. 查询: 确定元素属于哪个集合，用于决定是否要执行合并
```
public int find(int x) {
    // 查询
    if(parent[x] == x){ // 只有根节点满足parent[x] = x
        return x;
    } else{
        return find(parent[x]); // 递归查询找到某一结点的根结点
    }
}
```
2. 合并: 将属于同一集合的元素合并
```
public void union(int x, int y) {
    // 合并
    if(find(x) != find(y)){
        parent[find(y)] = find(x);
        num++;
    }
}
```

## 并查集的进阶操作——合并优化
原因: 合并x和y所在树时，只是简单地将y所在树的根指向x所在树的根`parent[find(y)] = find(x)`，最坏的情况下将得到一棵链状的树，较高的树高将导致较高的查询(及合并)复杂度。
1. 按大小合并
2. 按秩(高度)求并

## 并查集的高级操作——路径压缩

## 例题
基础级例题:
题目名称|说明
:------|:---
[323. 无向图中连通分量的数目](https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph/)|
[547. 省份数量](https://leetcode-cn.com/problems/number-of-provinces/)|

进阶级例题:
题目名称|说明
:------|:---
[684. 冗余连接](https://leetcode-cn.com/problems/redundant-connection/)|
[130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)|
[1020. 飞地的数量](https://leetcode-cn.com/problems/number-of-enclaves/)|

BOSS级例题:
题目名称|说明
:------|:---
[399. 除法求值](https://leetcode-cn.com/problems/evaluate-division/)|带权并查集