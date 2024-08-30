import java.util.*;

/**
 * 
 * @auther ken.ck
 * @date 2024/4/20 15:39
 */
public class Test extends Thread {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        back(1, res, new Stack<Integer>(), k, n);
        return res;
    }

    private void back(int idx, List<List<Integer>> res, Stack<Integer> tmp, int k, int n) {

        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(tmp));
            return ;
        }
        if (idx > 9 || k < 0 || n < 0) {
            return ;
        }

        tmp.push(idx);
        back(idx + 1, res, tmp, k - 1, n - idx);
        tmp.pop();
        back(idx + 1, res, tmp, k, n);
    }

    public static void main(String[] args) {
        int[] code = new int[3];
//        Test obj = new Test();
////        System.out.println(obj.combinationSum3(3, 7));
////        System.out.println(obj.combinationSum3(3, 9));
////
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        ListIterator<Integer> listIterator = list.listIterator();
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.previous());
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.next());

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "1");
        treeMap.put(3, "3");
        treeMap.put(2, "2");
        System.out.println(treeMap.lowerKey(2));
        System.out.println(treeMap.higherKey(2));
    }

}
