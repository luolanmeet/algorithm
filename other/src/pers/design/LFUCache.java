package pers.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 460. LFU 缓存
 * https://leetcode-cn.com/problems/lfu-cache/
 * @auther ken.ck
 * @date 2021/2/11 21:15
 */
public class LFUCache {

    // key 到 val 的映射
    private Map<Integer, Integer> keyToVal;
    // key 到 freq 的映射
    private Map<Integer, Integer> keyToFreq;
    // freq 到 keys 的映射
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 容量
    private int capacity;
    // 当前最小使用次数
    private int minFreq;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {

        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        // 增加key对应的freq
        increateFreq(key);

        return keyToVal.get(key);
    }

    public void put(int key, int value) {

        if (this.capacity <= 0) {
            return ;
        }

        // 原来的key存在，则更新值和freq
        Integer tmpVal = keyToVal.get(key);
        if (tmpVal != null) {
            if (tmpVal != value) {
                keyToVal.put(key, value);
            }
            increateFreq(key);
            return ;
        }

        // 容量已满的情况
        if (keyToVal.size() >= capacity) {
            removeMinFreqKey();
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);

        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);

        // 插入新的key，最小的freq是1
        this.minFreq = 1;
    }

    private void removeMinFreqKey() {

        // freq 最小的 key 列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);

        // 其中最先被插入的那个key就是该被淘汰的key
        Integer deleteKey = keyList.iterator().next();
        keyList.remove(deleteKey);

        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }

        keyToVal.remove(deleteKey);
        keyToFreq.remove(deleteKey);
    }

    private void increateFreq(Integer key) {

        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        // 从原来的调用次数集合中移除
        freqToKeys.get(freq).remove(key);

        // 添加到新的调用次数集合中
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        // 如果 freq 对应的列表空了，移除这个列表
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // 如果正好是minFreq，则更新minFreq
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

}
