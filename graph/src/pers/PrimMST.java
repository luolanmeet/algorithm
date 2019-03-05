package pers;

/**
 * Prim普里姆最小生成树算法
 * 
 * 对于图G而言，V是所有顶点的集合；现在，设置两个新的集合U和T，其中U用于存放G的最小生成树中的顶点，T存放G的最小生成树中的边。 
 * 从所有uЄU，vЄ(V-U) (V-U表示出去U的所有顶点)的边中选取权值最小的边(u, v)，
 * 将顶点v加入集合U中，将边(u, v)加入集合T中，如此不断重复，直到U=V为止，最小生成树构造完毕，
 * 这时集合T中包含了最小生成树中的所有边。
 * @author cck
 */
public class PrimMST {
    
    private char[] mVexs;    // 顶点集合
    private int[][] mMatrix; // 邻接矩阵
    private final static int INF = Integer.MAX_VALUE; // 最大值
    
    /**
     * 创建图
     */
    public PrimMST(char[] vexs, int[][] matrix) {
        
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
    
    /**
     * 最小生成树
     * @param start 从这个顶点开始生成树
     */
    public void prim(int start) {
        
        int num = mVexs.length; // 顶点个数
        int index = 0;          // prim最小树的索引，即prim数组的索引
        char[] prims = new char[num]; // prim最小树的结果数组
        int[] weights = new int[num]; // 顶点间边的权值
        
        // prim最小数第一个数是"图中第start个顶点"，因为从start开始
        prims[index++] = mVexs[start];
        
        // 初始化"顶点的权值数组"
        // 即将每个顶点的权值初始化为"第start个顶点"到"该顶点"的权值
        for (int i = 0; i < num; i++) {
            weights[i] = mMatrix[start][i];
        }
        // 将第start顶点的权值初始化为0
        // 即start顶点到自身的距离为0
        weights[start] = 0;
        
        for (int i = 0; i < num; i++) {
            
            if (start == i) {
                continue;
            }
            
            int j = 0;
            int k = 0;
            int min = INF;
            
            // 在未被加入到最小生成树的顶点中，找出权值最小的顶点
            while (j < num) {
                // 若weight[j] == 0，表示第j个顶点已经加入到最小生成树中
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }
            
            // 经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点就是k顶点
            // 将第k个顶点加入到最小生成树的结果数组中
            prims[index++] = mVexs[k];
            // 将第k个顶点的权值设置为0，代表已经加入到最小生成树
            weights[k] = 0;
            
            // 顶点k加入到树后，需要更新weights中其他顶点的权值
            for (j = 0; j < num; j++) {
                if (weights[j] != 0 && mMatrix[k][j] < weights[j]) {
                    weights[j] = mMatrix[k][j];
                }
            }
        }
        
        // 计算最小生成树的权值
        int sum = 0;
        for (int i = 1; i < index; i++) {
            int min = INF;
            // 获取prims[i]在mMatrix中的位置
            int n = getPosition(prims[i]);
            // 在vexs[0..i]中，找出j的权值最小的顶点
            for (int j = 0; j < i; j++) {
                int m = getPosition(prims[j]);
                if (mMatrix[m][n] < min) {
                    min = mMatrix[m][n];
                }
            }
            sum += min;
        }
        
        // 打印最小生成树
        System.out.printf("PRIM(%c)=%d: ", mVexs[start], sum);
        for (int i = 0; i < index; i++) {
            System.out.printf("%c ", prims[i]);
        }
        System.out.println();
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
        
        PrimMST mst = new PrimMST(vexs, matrix);
        mst.prim(0);
    }
    
}
