package pers.design;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 355. 设计推特
 * https://leetcode-cn.com/problems/design-twitter/
 */
class Twitter {

    private Map<Integer, Set<Integer>> fMap;
    private Map<Integer, Deque<Msg>> msgMap;
    private AtomicLong nums = new AtomicLong(0);

    static class Msg {
        private int tid;
        private long num;
        Msg(int tid, long num) {this.tid = tid; this.num = num;}
        int getTid() {return this.tid;}
        long getNum() {return this.num;}
    }

    /** Initialize your data structure here. */
    public Twitter() {
        fMap = new HashMap<>();
        msgMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Deque<Msg> ms = msgMap.get(userId);
        if (ms == null) {
            ms = new ArrayDeque<>();
            msgMap.put(userId, ms);
        }
        ms.offer(new Msg(tweetId, nums.incrementAndGet()));

        if (ms.size() > 10) {
            ms.pop();
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        Set<Integer> ids = fMap.computeIfAbsent(userId, k -> new HashSet<>());
        ids.add(userId); // 获取消息时，需要获取自己

        // 从自己的每个好友中都获取10条消息，然后组合在一起，按照时间排序，再取10条返回。
        List<Msg> tmp = new ArrayList<>();

        for (Integer id : ids) {
            Deque<Msg> msgs = msgMap.get(id);
            if (msgs == null) continue;
            tmp.addAll(new ArrayList<>(msgs));
        }

        tmp.sort((m1, m2) -> - Long.compare(m1.getNum(), m2.getNum()));

        List<Integer> resp = new ArrayList<>();
        for (int i = 0; i < 10 && i < tmp.size(); i++) {
            resp.add(tmp.get(i).getTid());
        }

        return resp;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> ids = fMap.computeIfAbsent(followerId, k -> new HashSet<>());
        ids.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> ids = fMap.get(followerId);
        if (ids == null) {
            return ;
        }
        ids.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter obj = new Twitter();

        obj.postTweet(1, 5);
        obj.postTweet(1, 3);
        System.out.println(obj.getNewsFeed(1));

        /*obj.postTweet(1, 5);
        System.out.println(obj.getNewsFeed(1));
        obj.follow(1,2);
        obj.postTweet(2, 6);
        System.out.println(obj.getNewsFeed(1));
        obj.unfollow(1,2);
        System.out.println(obj.getNewsFeed(1));*/
    }

}
