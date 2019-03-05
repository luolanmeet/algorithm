package pers;

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
    }
    
}
