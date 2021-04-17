package pers.design;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个LRU(最近最少使用)缓存机制。它应该支持以下操作：
 *
 * 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) ，如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) ，如果密钥不存在，则写入其数据值。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *      LRUCache cache = new LRUCache(2) // 缓存容量
 *      cache.put(1,1);
 *      cache.put(2,2);
 *      cache.get(1);       // 返回  1
 *      cache.put(3,3);     // 该操作会使得密钥 2 作废
 *      cache.get(2);       // 返回 -1 (未找到)
 *      cache.put(4,4);     // 该操作会使得密钥 1 作废
 *      cache.get(1);       // 返回 -1 (未找到)
 *      cache.get(3);       // 返回  3
 *      cache.get(4);       // 返回  4
 *
 * LRU 的几个需求
 * 1. 快速定位数组  --> 哈希表
 * 2. 快速维护数据(新增、删除)  --> 链表
 * 3. 数据有序  --> 数组或链表
 *
 * 146. LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/submissions/
 */
class LRUCache {
    
    private Map<Integer, Integer> map;
    private int capacity;
    
    /**
     * 除了满足功能外，需要考虑性能，获取数据，维护数据
     * 利用hash快速获取数据
     * 利用链表方便维护数据（最常使用的放在链表最后）
     * @param capacity
     */
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
    
        Integer val = map.remove(key);
        if (val == null) {
            return -1;
        }
        map.put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
    
        Integer tmpVal = map.remove(key);
        if (tmpVal != null) {
            map.put(key, value);
            return ;
        }
    
        if (map.size() >= capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }
    
    public static void main(String[] args) {
    
        LRUCache cache = new LRUCache(2); // 缓存容量
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3,3);     // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4,4);     // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
        
    }
    
}