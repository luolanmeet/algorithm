package pers;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 通过继承LinkedHashMap，重写removeEldestEntry方法的方式
 *
 * LinkedHashMap提供了一个钩子方法removeEldestEntry，
 * 在新插入元素后可以决定是否删除最老的元素。
 */
public class LRUCacheTwo extends LinkedHashMap {

    private int maxSize;

    public LRUCacheTwo(int maxSize) {
        // 容量为最大值/0.75，即最大负载容量为maxSize
        // accessOrder=true  根据查询排序，即最近被使用的放到后面
        super(maxSize, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxSize;
    }

    public static void main(String[] args) {
        LRUCacheTwo cache = new LRUCacheTwo(2); // 缓存容量
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3,3);     // 该操作会使得密钥 2 作废

        System.out.println("size: " + cache.size());

        System.out.println(cache.get(2));       // 返回 null (未找到)
        cache.put(4,4);     // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 null (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

}
