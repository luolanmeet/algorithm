package pers.bfs;

import java.util.*;

/**
 * 752. 打开转盘锁
 * https://leetcode-cn.com/problems/open-the-lock/
 * @author cck
 * @date 2021/1/5 23:06
 */
public class OpenLock {

    public int openLock(String[] deadends, String target) {

        Set<String> deadSet = new HashSet<>();
        Collections.addAll(deadSet, deadends);

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int step = 0;

        while (!q.isEmpty()) {

            int sz = q.size();

            for (int i = 0; i < sz; i++) {

                String cur = q.poll();
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (target.equals(cur)) {
                    return step;
                }

                // 一共四位数，每一位都可以 +1 -1
                for (int j = 0; j < 4; j++) {
                    String tmp = plusOne(cur, j);
                    if (!visited.contains(tmp)) {
                        visited.add(tmp);
                        q.offer(tmp);
                    }
                    tmp = minusOne(cur, j);
                    if (!visited.contains(tmp)) {
                        visited.add(tmp);
                        q.offer(tmp);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    private String plusOne(String cur, int i) {
        char[] cs = cur.toCharArray();
        if (cs[i] == '9') {
            cs[i] = '0';
        } else {
            cs[i]++;
        }
        return new String(cs);
    }

    private String minusOne(String cur, int i) {
        char[] cs = cur.toCharArray();
        if (cs[i] == '0') {
            cs[i] = '9';
        } else {
            cs[i]--;
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        OpenLock obj = new OpenLock();
//        System.out.println(obj.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
        System.out.println(obj.openLock(new String[]{"0000"}, "8888"));
//        System.out.println(obj.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }

}
