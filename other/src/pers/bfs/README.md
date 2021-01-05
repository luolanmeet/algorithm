### BFS

#### BFS常见的场景
* 求图中从起点到终点的最近距离 

#### 算法框架
```java
// 计算从起点start到终点target的最短距离
int BFS(Node start, Node target) ｛
    // 核心数据结构
    Queue<Node> q;

    // 避免走回头路
    Set<Node> visited; 

    // 将起点加入队列
    q.offer(start);
    visited.add(start);
    
    // 记录扩散的步数
    int step = 0;
    
    while (q not empty) {

        int sz = q.size();
        // 当前队列中所有节点向四周扩散
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            // 判断是否到达终点
            if (cur == target) {
                return step;
            }
            // 将和cur相邻的节点加入队列
            for (Node x : cur.adj()) {
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
            }
        }
        // 更新步数，一次 for 中，所有节点齐头并进，扩散一次，因此加一步是对的
        step++;
    }
｝
```
