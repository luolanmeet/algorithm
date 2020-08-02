package pers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 最频繁栈
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。FreqStack 有两个函数： 
 * push(int x)，将整数 x 推入栈中。pop()，它移除并返回栈中出现最频繁的元素。
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 */
public class FreqStack {

    // <数据，数据次数>，在pop的时候是没用的，但在push时有用
    // 用于记录数据当前在栈中的数量
    Map<Integer, Integer> freq;
    // <次数，相同次数的数据（有序）>
    // 注意！push(5);push(5);push(5);
    // 则会有<1, [5]> <2, [5]> <3, [5]> 这样的数据产生
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq) maxfreq = f;
        group.computeIfAbsent(f, z -> new Stack<>()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }

    public static void main(String[] args) {

        FreqStack freqStack = new FreqStack();
        // 5,7,5,7,4,5
        freqStack.push(5);freqStack.push(7);freqStack.push(5);
        freqStack.push(7);freqStack.push(4);freqStack.push(5);

        System.out.println(freqStack.pop()); // 5
        System.out.println(freqStack.pop()); // 7
        System.out.println(freqStack.pop()); // 5
        System.out.println(freqStack.pop()); // 4

    }

}
