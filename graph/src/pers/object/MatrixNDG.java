package pers.object;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 无向图 邻接矩阵
 * @author cck
 */
public class MatrixNDG {
    
    int size; // 图顶点数量
    char[] vertexs; // 图顶点名称
    int[][] matrix; // 图关系矩阵
    
    /**
     * 
     * @param vertexs
     * @param edges [N][2]
     */
    public MatrixNDG(char[] vertexs, char[][] edges) {
        
        this.size = vertexs.length;
        this.matrix = new int[size][size];
        this.vertexs = vertexs;
        
        for (char[] c : edges) {
            
            int p1 = getPosition(c[0]);   
            int p2 = getPosition(c[1]);   
            
            // 无向图
            matrix[p1][p2] = 1;
            matrix[p2][p1] = 1;
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
    
    public void DFS() {
        
        boolean[] beTraversad = new boolean[size];
        
        // 不把第一元素遍历掉，进入DFS方法时，由于y=0，vertexs[0]会被再遍历一次
        System.out.print(vertexs[0] + " ");
        beTraversad[0] = true;
        DFS(0, 0, beTraversad);
    }
    
    private void DFS(int x, int y, boolean[] beTraversed) {
        
        while (y <= size - 1) {
            
            if (matrix[x][y] != 0 && !beTraversed[y]) {
                System.out.print(vertexs[y] + " ");
                beTraversed[y] = true;
                // y表示的是当前所在的顶点的下一个顶点，所在这样就是DFS了
                DFS(y, 0, beTraversed);
            }
            y++;
        }
    }
    
    public void BFS() {
        
        boolean[] beTraversad = new boolean[size];
        System.out.print(vertexs[0] + " ");
        beTraversad[0] = true;
        BFS(0, beTraversad);
    }
    
    private void BFS(int x, boolean[] beTraversed) {
        
        int y = 0;
        Queue<Character> queue = new ArrayDeque<>();
        while (y <= size - 1) {
            
            if (matrix[x][y] == 1 && !beTraversed[y]) {
                System.out.print(vertexs[y] + " ");
                beTraversed[y] = true;  
                queue.offer(vertexs[y]);
            }
            y++;
        }
        
        while (!queue.isEmpty()) {
            
            int index = getPosition(queue.poll());
            BFS(index, beTraversed);
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
        
        MatrixNDG matrixNDG = new MatrixNDG(vers , edges);
        matrixNDG.print();
        matrixNDG.DFS();
        System.out.println();
        matrixNDG.BFS();
    }
    
}
