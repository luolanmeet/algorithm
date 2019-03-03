package pers.object;

/**
 * 有向图 邻接表
 * @author cck
 */
public class ListDG {
    
    Vertex[] vertexList; // 邻接表数组
    int size;
    
    class Vertex {
        
        char c;
        Vertex next;
        
        Vertex (char c) {
            this.c = c;
        }
        
        void add(char c) {
            
            Vertex node = this;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Vertex(c);
        }
    }
    
    public ListDG(char[] vertexs, char[][] edges) {
        
        this.size = vertexs.length;
        this.vertexList = new Vertex[this.size];
        
        // 设置邻接表的每个节点
        for (int i = 0; i < this.size; i++) {
            this.vertexList[i] = new Vertex(vertexs[i]);
        }
        
        // 存储边信息
        for (char[] c : edges) {
            int p1 = getPosition(c[0]);
            vertexList[p1].add(c[1]);
        }
        
    }
    
    private int getPosition(char c) {
        
        for (int i = 0; i < vertexList.length; i++) {
            
            if (vertexList[i].c == c) {
                return i;
            }
        }
        return -1;
    }
    
    private void print() {
        
        for (Vertex vertex : vertexList) {
            while (vertex != null) {
                System.out.print(vertex.c + " ");
                vertex = vertex.next;
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
        
        ListDG listDG = new ListDG(vers , edges);
        listDG.print();
    }
    
}
