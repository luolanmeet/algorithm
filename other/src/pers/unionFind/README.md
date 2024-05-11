# 并查集
```java
class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            // 每个节点初始化的父节点是自身
            parent[i] = i;
            // 维护节点的高度，后续可按秩合并
            rank[i] = 1;            
        }
    }

    /**
     * 把 节点1 和 节点2 合并到同一个根节点下
     */
    public void union(int index1, int index2) {
        // 设置 节点2的根节点 的父节点 为 节点1的根节点
        parent[find(index2)] = find(index1);
    }

    /**
     * 把 节点1 和 节点2 合并到同一个根节点下
     * 按秩合并 
     */
    public void union2(int index1, int index2) {
        int r1 = find(index1);
        int r2 = find(index1);
        
        // 把简单的树合并到复杂的树上
        if (rank[r1] <= rank[r2]) {
            parent[r1] = r2;
        } else {
            parent[r2] = r1;
        }
        if (rank[r1] == rank[r2] && r1 != r2) {
            rank[r2]++;
        }
    }

    /**
     * 递归查找根节点
     */
    public int find(int index) {
        if (parent[index] != index) {
            // 压缩路径。并查集里的节点只关心节点的根节点而已
            // 在查找的时候，可以顺便进行压缩，直接指向根节点
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
```