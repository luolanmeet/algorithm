package pers.object;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 无向图 邻接表
 * @author cck
 */
public class ListNDG {
    
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
    
    public ListNDG(char[] vertexs, char[][] edges) {
        
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
            int p2 = getPosition(c[1]);
            vertexList[p2].add(c[0]);
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
    
    public void DFS() {
        
        boolean[] beTraversed = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!beTraversed[i]) {
                DFS(beTraversed, vertexList[i]);
            }
        }
        
    }
    
    public void DFS(boolean[] beTraversed, Vertex node) {
        
        System.out.print(node.c + " ");
        beTraversed[getPosition(node.c)] = true;
        
        while (node != null) {
            
            if (!beTraversed[getPosition(node.c)]) {
                DFS(beTraversed, vertexList[getPosition(node.c)]);
            }
            node = node.next;
        }
    }
    
    public void BFS() {
        
        boolean[] beTraversed = new boolean[size];
        
        System.out.print(vertexList[0].c + " ");
        beTraversed[0] = true;
        BFS(0, beTraversed);
    }
    
    private void BFS(int x, boolean[] beTraversed) {
        
        Vertex vertex = vertexList[x];
        Queue<Vertex> queue = new ArrayDeque<>();
        
        while (vertex != null) {
            
            int index = getPosition(vertex.c);
            if (!beTraversed[index]) {
                System.out.print(vertex.c + " ");
                queue.offer(vertex);
                beTraversed[index] = true;
            }
            vertex = vertex.next;
        }
        
        while (!queue.isEmpty()) {
            int index = getPosition(queue.poll().c);
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
        
        ListNDG listNDG = new ListNDG(vers , edges);
        listNDG.print();
        listNDG.DFS();
        System.out.println();
        listNDG.BFS();
    }
    
}
