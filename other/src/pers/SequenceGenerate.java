package pers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 用于生成升序序列的场景，如 a b c 分配序列后，b 因为某些原因拆为 b1, b2
 * a b1 b2 c 仍需要保持升序且要求不更新 c 的序列。同理 b1 又可再拆分
 *
 * 有符号 long 类型是 63 位
 * 以 6 位为一个区间，划分为 11 个区间，最后一个区间 3 位。
 * 支持连续拆分11次
 * 每个区间以1开始，每次可以分配63个序列。最后一个区间能分配7个序列。
 *
 * @auther ken.ck
 * @date 2023/12/29 20:31
 */
public class SequenceGenerate {

    // 存储当前区域左移位数
    static Map<Integer, Integer> bitRegion = new HashMap<>();
    // 存储每个区域的最大值
    static List<Long> regionMaxValues = new ArrayList<>();

    static {
        for (int i = 1; i < 11; i++) {
            int bitNum = 63 - 6 * i;
            bitRegion.put(i, bitNum);
            regionMaxValues.add(63L << bitNum);
        }
        bitRegion.put(11, 0);
        regionMaxValues.add(7L);
    }

    /**
     * 返回数值在所在区间内自增
     * @param num
     * @return
     */
    public static long increate(long num) {
        int region = getRegion(num);
        num += (1L << bitRegion.get(region));
        if (getRegion(num) != region) {
            throw new RuntimeException(num + " out of range");
        }
        return num;
    }

    /**
     * 获取数值所在的区间
     * @param num
     * @return
     */
    public static int getRegion(long num) {
        for (int i = regionMaxValues.size() - 1; i >= 0; i--) {
            if ((regionMaxValues.get(i) & num) > 0L) {
                return i + 1;
            }
        }
        throw new RuntimeException(num + " no in any region");
    }

    public static void main(String[] args) {

        // 注意，最高位是符号位

        System.out.println(getRegion(1)); // 区间11
        System.out.println(getRegion(64)); // 区间10
        System.out.println(getRegion(512)); // 区间9
        System.out.println(getRegion(1024)); // 区间9
        System.out.println(getRegion(65536)); // 区间8
        System.out.println(getRegion(8070450532247928832L)); // 区间1
        System.out.println("====================");
        System.out.println(increate(1)); // 2
        System.out.println(increate(8)); // 16
        System.out.println(increate(288230376151711744L)); // 432345564227567616
        System.out.println(increate(8070450532247928832L)); // 8214565720323784704
        System.out.println(increate(496)); // 504
//        System.out.println(increate(7)); // error
//        System.out.println(increate(504)); // error
    }

}
