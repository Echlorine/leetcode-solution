# 不相交集(并查集)
## 描述
并查集是一种树型、用来维护连通性的数据结构，可以处理一些不相交集合的合并及查询问题。并查集用一个数组表示了整片森林（parent），树的根节点唯一标识了一个集合。**初始状态通常是每一个元素构成一个单元素集合**。

## 并查集的基础操作
0. 初始化: 把每一个元素构成一个单元素集合
```
// 初始化并查集
int[] parent = new int[n];
for (int i = 0; i < n; i++) {
    parent[i] = i;
}
```
1. 查询: 确定元素属于哪个集合，用于决定是否要执行合并
```
public int find(int x) {
    // 查询
    if (parent[x] == x) { // 只有根节点满足parent[x] = x
        return x;
    } else {
        return find(parent[x]); // 递归查询找到某一结点的根结点
    }
}
```
2. 合并: 将属于同一集合的元素合并
```
public void union(int x, int y) {
    // 合并
    if (find(x) != find(y)) {
        parent[find(y)] = find(x);
        num++;
    }
}
```

## 并查集的进阶操作——合并优化
原因: 合并x和y所在树时，只是简单地将y所在树的根指向x所在树的根`parent[find(y)] = find(x)`，最坏的情况下将得到一棵链状的树，较高的树高将导致较高的查询(及合并)复杂度。
### 按大小合并
让较小的树挂到较大的树上，因为较小的树的树高总是倾向于较低。
```
public void unionBySize(int x, int y) {
    // Union方法：按大小求并，size记录每个树的大小
    int xRoot = find(x), yRoot = find(y);
    // 根节点不同才求并
    if (xRoot != yRoot) {
        if (size[yRoot] <= size[xRoot]) { // 当y所在树比x所在树小时
            parent[yRoot] = xRoot; // 将yRoot挂在xRoot上
            size[xRoot] += size[yRoot]; // 更新x所在树的大小
        } else {
            parent[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        }
    }
}
```
### 按秩(高度)求并
让高度较低的树挂到高度较高的树上，当两棵树的树高相同时，才需要更新树高
```
public void unionByrank(int x, int y) {
    // union方法：按秩(高度)求并
    int xRoot = find(x), yRoot = find(y);
    if (xRoot != yRoot) {
        if (rank[yRoot] <= rank[xRoot]) parent[yRoot] = xRoot;
        else parent[xRoot] = yRoot;
        if (rank[xRoot] == rank[yRoot]) rank[xRoot]++; 
    }
}
```
## 并查集的高级操作——路径压缩
```
public int find(int x) {
    // 带路径压缩的find方法
    if (parent[x] != x) {
        parent[x] = find(parent[x]);
    }
    return parent[x];
}
```

## 并查集类的模板
```java
public class DisjointSet {

private int[] parent;
    private int[] size; // 按大小合并，根据实际情况确定是按大小合并还是按秩合并
    private int[] rank; // 按秩合并，根据实际情况确定是按大小合并还是按秩合并
    private int num; // 统计合并操作次数，方便确定连通分量个数
    private int[] weight; // 当前结点到并查集中代表结点的权值，带权并查集中使用

    public DisjointSet(int n) {
        // 初始化并查集
        this.parent = new int[n];
        this.rank = new int[n];
        this.size = new int[n];
        this.weight = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            size[i] = 1;
            weight[i] = 1;
        }
    }

    /**
     * 直接查找
     * @param x
     * @return int
     */
    public int findDirect(int x) {
        if (parent[x] == x) return x;
        else return findDirect(parent[x]);
    }

    /**
     * 带路径压缩的查找
     * @param x
     * @return int
     */
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /**
     * 带权并查集中带路径压缩的查找
     * @param x
     * @return
     */
    public int findWithValue(int x) {
        if (parent[x] != x) {
            int origin = parent[x];
            parent[x] = findWithValue(parent[x]);
            weight[x] *= weight[origin];
        }
        return parent[x];
    }

    /**
     * 直接求并
     * @param x
     * @param y
     */
    public void unionDirect(int x, int y) {
        if (find(x) != find(y)) {
            num++; // 根据实际情况确定
            parent[find(y)] = find(x);
        }
    }

    /**
     * 按大小合并
     * @param x
     * @param y
     */
    public void unionBySize(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot != yRoot) {
            num++; // 根据实际情况确定
            if (size[xRoot] <= size[yRoot]) {
                parent[xRoot] = yRoot;
                size[yRoot] += size[xRoot];
            }
            else {
                parent[yRoot] = xRoot;
                size[xRoot] += size[yRoot];
            }
        }
    }

    /**
     * 按秩合并
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot != yRoot) {
            num++; // 根据实际情况确定
            if (rank[xRoot] <= rank[yRoot]) {
                parent[xRoot] = yRoot;
            }
            else {
                parent[yRoot] = xRoot;
            }
            if (rank[xRoot] == rank[yRoot]) rank[yRoot]++;
        }
    }

    /**
     * 带权并查集的合并操作
     * @param x
     * @param y
     * @param value, x --> y 之间的权值
     */
    public void union(int x, int y, int value) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot != yRoot) {
            if (rank[xRoot] <= rank[yRoot]) {
                parent[xRoot] = yRoot;
                weight[xRoot] = weight[y] * value / weight[x];
            }
            else {
                parent[yRoot] = xRoot;
                weight[yRoot] = weight[x] / (value * weight[y]);
            }
            if (rank[xRoot] == rank[yRoot]) rank[yRoot]++;
        }
    }

    /**
     * @return int 返回连通分量的数量
     */
    public int getConnectedNum() {
        return parent.length - num;
    }

    /**
     * 得到并查集中 x --> y 之间的权值
     * @param x
     * @param y
     * @return
     */
    public int getWeight(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot != yRoot) {
            return -1;
        }
        return weight[x] / weight[y];
    }
}
```

## 例题
基础级例题:
题目名称|说明|答案
:------|:---|:--:
[323. 无向图中连通分量的数目](https://leetcode.cn/problems/number-of-connected-components-in-an-undirected-graph/)|题目名称就暗示了使用并查集|[Java](../Java/Solution323.java)
[547. 省份数量](https://leetcode.cn/problems/number-of-provinces/)|确定图的连通分量数量|[Java](../Java/Solution547.java)
[990. 等式方程的可满足性](https://leetcode.cn/problems/satisfiability-of-equality-equations/)|确定图的连通分量|[Java](../Java/Solution990.java)
[1319. 连通网络的操作次数](https://leetcode.cn/problems/number-of-operations-to-make-network-connected/)|确定连通分量的数量|[Java](../Java/Solution1319.java)

进阶级例题:
题目名称|说明|答案
:------|:---|:--:
[684. 冗余连接](https://leetcode.cn/problems/redundant-connection/)|~|[Java](../Java/Solution684.java)
[130. 被围绕的区域](https://leetcode.cn/problems/surrounded-regions/)|二维平面问题的并查集解法|[Java](../Java/Solution130.java)
[1020. 飞地的数量](https://leetcode.cn/problems/number-of-enclaves/)|二维平面问题的并查集解法，利用并查集建模问题|[Java](../Java/Solution1020.java)
[765. 情侣牵手](https://leetcode.cn/problems/couples-holding-hands/)|确定并查集的连通分量数量比确定并查集内每一个连通分量的大小更容易|[Java](../Java/Solution765.java)
[305. 岛屿数量 II](https://leetcode.cn/problems/number-of-islands-ii/)|确定连通分量的数量是并查集的典型应用|[Java](../Java/Solution305.java)
[778. 水位上升的泳池中游泳](https://leetcode.cn/problems/swim-in-rising-water/)|本质是单源最短路径问题|[Java](../Java/Solution778.java)
[1102. 得分最高的路径](https://leetcode.cn/problems/path-with-maximum-minimum-value/)|巧妙运用并查集|[Java](../Java/Solution1102.java)
[1202. 交换字符串中的元素](https://leetcode.cn/problems/smallest-string-with-swaps/)|学习如何利用哈希表保存并查集内不同的连通分量|[Java](../Java/Solution1202.java)
[947. 移除最多的同行或同列石头](https://leetcode.cn/problems/most-stones-removed-with-same-row-or-column/)|合并次数即为最终结果|[Java](../Java/Solution947.java)
[959. 由斜杠划分区域](https://leetcode.cn/problems/regions-cut-by-slashes/)|难在如何将问题建模|[Java](../Java/Solution959.java)
[1631. 最小体力消耗路径](https://leetcode.cn/problems/path-with-minimum-effort/)|连通性问题就可以考虑使用并查集|[Java](../Java/Solution1631.java)

BOSS级例题:
题目名称|说明|答案
:------|:---|:--:
[399. 除法求值](https://leetcode.cn/problems/evaluate-division/)|带权并查集|[Java](../Java/Solution399.java)
[803. 打砖块](https://leetcode.cn/problems/bricks-falling-when-hit/)|并查集的反向应用|[Java](../Java/Solution803.java)