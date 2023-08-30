package pers;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 933. 最近的请求次数
 * https://leetcode.cn/problems/number-of-recent-calls/
 * @auther ken.ck
 * @date 2023/8/30 11:53
 */
public class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

//    List<Integer> pings;
//    public RecentCounter() {
//        pings = new LinkedList<>();
//    }
//    public int ping(int t) {
//        pings.add(t);
//        int l = t - 3000;
//        if (l < 0) {
//            l = 0;
//        }
//        int i = 0;
//        for ( ; i < pings.size(); i++) {
//            if (pings.get(i) >= l) {
//                break;
//            }
//        }
//        int res = pings.size() - i;
//        if (i > 0) {
//            // 移除
//            pings = pings.subList(i, pings.size());
//        }
//        return res;
//    }

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(642));
        System.out.println(obj.ping(1849));
        System.out.println(obj.ping(4921));
        System.out.println(obj.ping(5936));
        System.out.println(obj.ping(5957));
    }

}
