package pers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1146. 快照数组
 * https://leetcode-cn.com/contest/weekly-contest-148/problems/snapshot-array/
 * @author cck
 */
public class SnapshotArray {
    
    private static class Value {
        int version;
        int value;
        public Value(int version, int value) {
            this.version = version;
            this.value = value;
        }
    }

    private int version = 0;

    // <第几个数，List<这个数的版本>>
    private Map<Integer, List<Value>> map = new HashMap<>();

    public SnapshotArray(int length) {

        for (int i = 0; i < length; i++) {
            List<Value> list = new ArrayList<>();
            list.add(new Value(this.version, 0));
            map.put(i, list);
        }
    }
    
    public void set(int index, int val) {

        List<Value> vs = map.get(index);
        Value v = vs.get(vs.size() - 1);

        // 当前数据在当前版本存在，则更新当前版本的值
        if (v.version == this.version) {
            v.value = val;
            return ;
        }

        // 当前数据在当前版本不存在，则为此数增加版本
        vs.add(new Value(this.version, val));
    }
    
    public int snap() {
        // 当前版本自增
        return this.version++;
    }
    
    public int get(int index, int snap_id) {

        List<Value> vs = map.get(index);

        // 二分查找，找到对应的版本
        // 如果找不到，则是返回最大的那个版本，从最大的那个版本到this.version,这个数一直没变化

        int left = 0;
        int right = vs.size();

        while (right > left) {

            int mid = left + (right - left) / 2;

            Value v = vs.get(mid);

            if (v.version == snap_id) {
                return v.value;
            }

            if (v.version < snap_id) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return vs.get(--right).value;
    }


    public static void main(String[] args) {

     /*   SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
        snapshotArr.set(0,5);  // 令 array[0] = 5
        System.out.println(snapshotArr.snap());  // 获取快照，返回 snap_id = 0
        snapshotArr.set(0,6);
        System.out.println(snapshotArr.get(0,0));  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5*/

        SnapshotArray snapshotArr = new SnapshotArray(4); // 初始化一个长度为 4 的快照数组
        System.out.println(snapshotArr.snap());  // 获取快照，返回 snap_id = 0
        System.out.println(snapshotArr.snap());  // 获取快照，返回 snap_id = 1
        System.out.println(snapshotArr.get(3,1));  // 获取 snap_id = 1 的快照中 array[3] 的值，返回 0
        snapshotArr.set(2,4);  // 令 array[2] = 4
        System.out.println(snapshotArr.snap());  // 获取快照，返回 snap_id = 2
        snapshotArr.set(1,4);  // 令 array[1] = 4
    }

}
