package pers;

/**
 * 944. 删列造序 
 * https://leetcode-cn.com/problems/delete-columns-to-make-sorted/
 * @author cck
 */
public class MinDeletionSize {

    // 题的标签是 贪心算法。自己的解法完全是暴力破解。。
    public int minDeletionSize(String[] A) {
        
        int res = 0;
        
        TAG:
        for (int i = 0; i < A[0].length(); i++) {
            
            char pre = 'a' - 1;
            
            for (int j = 0; j < A.length; j++) {
                
                if (A[j].charAt(i) < pre) {
                    res++;
                    continue TAG;
                }
                pre = A[j].charAt(i);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        MinDeletionSize obj = new MinDeletionSize();
        System.out.println(obj.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        System.out.println(obj.minDeletionSize(new String[]{"a", "b"}));
        System.out.println(obj.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }
    
}
