package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/submissions/
 * @author cck
 */
public class ReconstructQueue {
    
    public int[][] reconstructQueue(int[][] people) {
        
        if (people.length == 0) {
            return people;
        }
        
        // 按照身高降序 K升序排序 
        Arrays.sort(people, (p1, p2) -> {
            return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
        });

        List<int[]> list = new ArrayList<>();
        //K值定义为 排在h前面且身高大于或等于h的人数 
        //因为从身高降序开始插入，此时所有人身高都大于等于h
        //因此K值即为需要插入的位置
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }
    
    public static void main(String[] args) {
        
        ReconstructQueue obj = new ReconstructQueue();
        int[][] is = obj.reconstructQueue(new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
        
        for (int[] i : is) {
            System.out.println(i[0] + " " + i[1]);
        }
        
    }
    
}
