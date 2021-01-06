package pers.bfs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 双向BFS
 * @author cck
 * @date 2021/1/6 7:57
 */
public class OpenLock2 {

    public int openLock(String[] deadends, String target) {

        Set<String> deadSet = new HashSet<>();
        Collections.addAll(deadSet, deadends);

        Set<String> visited = new HashSet<>();

        Set<String> q1 = new HashSet<>();
        q1.add("0000");
        Set<String> q2 = new HashSet<>();
        q2.add(target);

        int step = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {

            Set<String> tmpSet = new HashSet<>();

            for (String cur : q1) {

                if (q2.contains(cur)) {
                    return step;
                }
                if (deadSet.contains(cur)) {
                    continue;
                }
                visited.add(cur);

                // 一共四位数，每一位都可以 +1 -1
                for (int i = 0; i < 4; i++) {
                    String tmp = plusOne(cur, i);
                    if (!visited.contains(tmp)) {
                        tmpSet.add(tmp);
                    }
                    tmp = minusOne(cur, i);
                    if (!visited.contains(tmp)) {
                        tmpSet.add(tmp);
                    }
                }

                step++;

                // 转变扩散的方向
                q1 = q2;
                q2 = tmpSet;
            }
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
        System.out.println(obj.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
        System.out.println(obj.openLock(new String[]{"0000"}, "8888"));
        System.out.println(obj.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }

}
