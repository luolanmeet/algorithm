package pers;

/**
 * Kruskal克鲁斯卡尔最小生成树
 * 按照权值从小到大的顺序选择n-1条边，并保证这n-1条边不构成回路。 
 * 具体做法：首先构造一个只含n个顶点的森林，然后依权值从小到大从连通网中选择边加入到森林中，并使森林中不产生回路，直至森林变成一棵树为止。
 * @author cck
 */
public class KruskalMST {
    
    private int mEdgNum;     // 边的数量
    private char[] mVexs;    // 顶点集合
    private int[][] mMatrix; // 邻接矩阵
    private final static int INF = Integer.MAX_VALUE; // 最大值
    
    /**
     * 创建图
     */
    public KruskalMST(char[] vexs, int[][] matrix) {
        
        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        
        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            mVexs[i] = vexs[i];
        }
        
        // 初始化"边"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                mMatrix[i][j] = matrix[i][j];
            }
        }
        
        // 统计"边"
        mEdgNum = 0;
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (mMatrix[i][j] != INF) {
                    mEdgNum++;
                }
            }
        }
    }

    private int getPosition(char c) {
        for (int i = 0; i < mVexs.length; i++) {
            if (mVexs[i] == c) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 打印矩阵队列图
     */
    public void print() {
        System.out.println("Martix Graph");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++) {
                System.out.printf("%10d ", mMatrix[i][j]);
            }
            System.out.println();
        }
        
    }
    
    public void kruskal() {
        
        int index = 0;                     // rets数组的索引
        int[] vends = new int[mEdgNum];    // 用于保存"已有最小生成树"中每个顶点在该最小生成树中的终点
        EData[] rets = new EData[mEdgNum]; // 结果数组，保存kruskal最小生成树的边
        EData[] edges;                     // 图对应的所有边
        
        // 获取图中所有的边
        edges = getEdges();
        // 将边按照权重的大小进行排序（小到到）
        sortEdges(edges, mEdgNum);
        
        for (int i = 0; i < mEdgNum; i++) {
            
            int p1 = getPosition(edges[i].start);  // 获取第i条边的起点的序号
            int p2 = getPosition(edges[i].end);  // 获取第i条边的终点的序号
            
            int m = getEnd(vends, p1); // 获取p1在已有的最小生成树中的终点
            int n = getEnd(vends, p2); // 获取p2在已有的最小生成树中的终点
            // 如果m != n ，意味着边i与已经添加到最小生成树中的顶点没有形成环路
            if (m != n) {
                vends[m] = n;  // 设置m在已有的最小生成树中的终点为n
                rets[index++] = edges[i];  // 保存结果
            }
        }
        
        // 统计并打印kruskal最小生成树的信息
        int length = 0;
        for (int i = 0; i < index; i++) {
            length += rets[i].weight;
        }
        System.out.printf("kruskal=%d: ", length);
        for (int i = 0; i < index; i++) {
            System.out.printf("(%c, %c) ", rets[i].start, rets[i].end);
        }
    }
    
    /**
     * 获取图中的边
     */
    private EData[] getEdges() {
        
        int index = 0;
        EData[] edges = new EData[mEdgNum];
        
        for (int i = 0; i < mVexs.length; i++) {
            
            for (int j = i + 1; j < mVexs.length; j++) {
                if (mMatrix[i][j] != INF) {
                    edges[index++] = new EData(mVexs[i], mVexs[j], mMatrix[i][j]);
                }
            }
        }
        
        return edges;
    }
    
    /**
     * 对边按照权值大小进行排序
     */
    private void sortEdges(EData[] edges, int elen) {
        
        for (int i = 0; i < elen; i++) {
            for (int j = i + 1; j < elen; j++) {
                if (edges[i].weight > edges[j].weight) {
                    // 交换边i和边j
                    EData tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }
    
    /**
     * 获取i的终点
     */
    private int getEnd(int[] vends, int i) {
        while (vends[i] != 0) {
            i = vends[i];
        }
        return i;
    }
    
    /**
     * 边的结构体
     */
    private static class EData {
        char start; // 边的起点
        char end;   // 边的终点
        int weight; // 边的权重
        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    
    public static void main(String[] args) {
        
        char[] vexs = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        
        KruskalMST mst = new KruskalMST(vexs, matrix);
        mst.kruskal();
    }
    
}
