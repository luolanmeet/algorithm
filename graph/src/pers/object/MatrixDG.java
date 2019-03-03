package pers.object;

/**
 * 有向图 邻接矩阵
 * @author cck
 */
public class MatrixDG {
    
    int size; // 图顶点数量
    char[] vertexs; // 图顶点名称
    int[][] matrix; // 图关系矩阵
    
    /**
     * 
     * @param vertexs
     * @param edges [N][2]
     */
    public MatrixDG(char[] vertexs, char[][] edges) {
        
        this.size = vertexs.length;
        this.matrix = new int[size][size];
        this.vertexs = vertexs;
        
        for (char[] c : edges) {
            
            int p1 = getPosition(c[0]);   
            int p2 = getPosition(c[1]);   
            
            matrix[p1][p2] = 1;
        }
        
    }

    private int getPosition(char c) {
        
        for (int i = 0; i < vertexs.length; i++) {
            
            if (vertexs[i] == c) {
                return i;
            }
        }
        return -1;
    }
    
    public void print() {
        
        for (int[] a : matrix) {
            
            for (int b : a) {
                System.out.print(b + " ");
            }
            
            System.out.println();
        }
        
    }
    
    public static void main(String[] args) {
        
        char[] vers = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        char[][] edges = new char[][] {
            {'A', 'C'},
            {'A', 'D'},
            {'A', 'F'},
            {'B', 'C'},
            {'C', 'D'},
            {'E', 'G'},
            {'D', 'G'},
            {'I', 'J'},
            {'J', 'G'},
            {'E', 'H'},
            {'H', 'K'}
        };
        
        MatrixDG matrixDG = new MatrixDG(vers , edges);
        matrixDG.print();
    }
    
}
