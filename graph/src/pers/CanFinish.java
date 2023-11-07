package pers;

import java.util.*;

/**
 * 207. 课程表
 * https://leetcode.cn/problems/course-schedule/description/
 * @auther ken.ck
 * @date 2023/11/6 23:52
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 入度数组
        int[] ind = new int[numCourses];
        // 邻接表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            ind[prerequisites[i][0]]++;
            List<Integer> list = map.computeIfAbsent(prerequisites[i][1], k -> new ArrayList<>());
            list.add(prerequisites[i][0]);
        }

        // 入度为0的节点入队
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(ind[i] == 0) {
                queue.push(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Integer pop = queue.pop();
            List<Integer> list = map.get(pop);
            if (list == null) {
                continue;
            }
            for (Integer tmp : list) {
                // 去掉一个入度
                ind[tmp]--;
                if (ind[tmp] == 0) {
                    queue.push(tmp);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        CanFinish obj = new CanFinish();
        System.out.println(obj.canFinish(2, new int[][]{{1,0}}));
        System.out.println(obj.canFinish(2, new int[][]{{1,0},{0,1}}));
    }

}
