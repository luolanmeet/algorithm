package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * Dijkstra迪杰斯特拉最短路径算法
 * @author cck
 */
public class ShortesPathDijkstra {
    
    /** 邻接矩阵 */
    private int[][] matrix;
    /** 表示正无穷 */
    private int MAX_WEIGHT = Integer.MAX_VALUE;
    /** 顶点集合 */
    private String[] vertexes;
    
    /**
     * Dijkstra最短路径
     * @param vs 起点start vertex，要求的图中各顶点到该点的距离
     */
    public void dijkstra(int vs) {
        // flag[i]==true 表示vs到顶点i的最短路径已成功获取
        boolean[] flag = new boolean[vertexes.length];
        // U记录还未求出最短路径的顶点（以及该顶点到起点vs的距离），与flag配合使用，flag[i]==true，表示U中i顶点已被移除
        int[] U = new int[vertexes.length];
        // 前驱节点数组，prev[i]的值是顶点vs到顶点i的最短路径所经历的全部顶点中，位于顶点i之前的那个顶点
        int[] prev = new int[vertexes.length];
        // S的作用是记录已求出最短路径的顶点
        String[] S = new String[vertexes.length];
        
        // 步骤一：初始化时，S中只有起点vs，U中是除了vs之外的顶点，并且U中顶点的路径是起点vs到该顶点的路径
        for (int i = 0; i < vertexes.length; i++) {
            flag[i] = false; // 顶点i的最短路径还未获取到
            U[i] = matrix[vs][i]; // 顶点i到顶点vs的初始路径长度
            prev[i] = 0; // 顶点i的前驱顶点为0
        }
        
        // 将vs顶点从U中移除，（设置flag）
        flag[vs] = true;
        U[vs] = 0;
        // 将vs顶点加入到S
        S[0] = vertexes[vs];
            
        
        // 步骤四：重复步骤二三，直到遍历完所有顶点
        // 每次遍历都是找出一个顶点的最短路径
        int k = 0;
        for (int i = 1; i < vertexes.length; i++) {
            
            // 步骤二：从U中找出路径最短的顶点，并将其加入到S中，如果vs顶点到x顶点还有更短的路径的话，
            // 那么必定会有一个y顶点到vs顶点的路径比前者更短，且没有加入S中
            // 所以，U中路径最短顶点的路径就是该顶点的最短路径
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点k
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < vertexes.length; j++) {
                if (!flag[j] && min > U[j]) {
                    min = U[j];
                    k = j;
                }
            }
            // 将k放入到S中
            S[i] = vertexes[k];
            
            
            // 步骤三：更新U中的顶点和vs顶点对应的路径
            // 标识k已经取得最短路径
            flag[k] = true;
            
            // 修正当前最短路径和前驱顶点（更新U中剩余顶点对应的路径）
            // 即，当k顶点已经获取到最短路径后，更新U中还没有获取最短路径的顶点的最短路径和前驱顶点
            for (int j = 0; j < vertexes.length; j++) {
                
                // 以k顶点所在位置连接其他顶点，判断其他顶点经过最短路径顶点k到达vs顶点是否小于目前的最短路径
                // 是则更新入U，否则不处理 
                
                // 防止溢出
                int temp = matrix[k][j] == MAX_WEIGHT ? MAX_WEIGHT : matrix[k][j] + min;
                
                if (!flag[j] && U[j] > temp) {
                    U[j] = temp;
                    // 更新j顶点的前驱顶点为K
                    prev[j] = k;
                }
            }
            
        }
        
        
        // 打印dijkstra最短路径的结果
        System.out.println("起始顶点：" + vertexes[vs]);
        for (int i = 0; i < vertexes.length; i++) {
            
            System.out.print("最短路径(" + vertexes[vs] + "," + vertexes[i] + "):" + U[i] + " ");
            List<String> path = new ArrayList<>();
            int j = i;
            while (true) {
                path.add(vertexes[j]);
                if (j == 0) {
                    break;
                }
                j = prev[j];
            }
            
            for (int x = path.size() - 1; x >= 0; x--) {
                if (x == 0) {
                    System.out.println(path.get(x));
                } else {
                    System.out.print(path.get(x) + "->");
                }
            }
        }

        System.out.println("顶点放入s中的顺序");
        for (int i = 0; i < vertexes.length; i++) {
            
            System.out.print(S[i]);
            if (i != vertexes.length - 1) {
                System.out.print("-->");
            }
        }
    }
    
    /**
     * 创建图
     */
    private void createGraph(int index) {
        
        matrix = new int[index][index];
        vertexes = new String[index];
        
        int[] v0 = { 0, 1, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT };
        int[] v1 = { 1, 0, 3, 7, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT };
        int[] v2 = { 5, 3, 0, MAX_WEIGHT, 1, 7, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT };
        int[] v3 = { MAX_WEIGHT, 7, MAX_WEIGHT, 0, 2, MAX_WEIGHT, 3, MAX_WEIGHT, MAX_WEIGHT };
        int[] v4 = { MAX_WEIGHT, 5, 1, 2, 0, 3, 6, 9, MAX_WEIGHT };
        int[] v5 = { MAX_WEIGHT, MAX_WEIGHT, 7, MAX_WEIGHT, 3, 0, MAX_WEIGHT, 5, MAX_WEIGHT };
        int[] v6 = { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 3, 6, MAX_WEIGHT, 0, 2, 7 };
        int[] v7 = { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 9, 5, 2, 0, 4 };
        int[] v8 = { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 7, 4, 0 };
        matrix[0] = v0;
        matrix[1] = v1;
        matrix[2] = v2;
        matrix[3] = v3;
        matrix[4] = v4;
        matrix[5] = v5;
        matrix[6] = v6;
        matrix[7] = v7;
        matrix[8] = v8;
        
        vertexes[0] = "v0";
        vertexes[1] = "v1";
        vertexes[2] = "v2";
        vertexes[3] = "v3";
        vertexes[4] = "v4";
        vertexes[5] = "v5";
        vertexes[6] = "v6";
        vertexes[7] = "v7";
        vertexes[8] = "v8";
        
    }
    
    public static void main(String[] args) {
        
        ShortesPathDijkstra dijkstra = new ShortesPathDijkstra();
        dijkstra.createGraph(9);
        dijkstra.dijkstra(0);
    }
    
}
