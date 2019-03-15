package pers;

/**
 * 331. 验证二叉树的前序序列化
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * @author cck
 */
public class IsValidSerialization {

    // 树的出度入度
    public boolean isValidSerialization(String preorder) {
        
        String[] ss = preorder.split(",");
        
        int count = 1;
        
        for (String s : ss) {
            
            count--;
            
            if (count < 0) {
                return false;
            }
            
            if (!"#".equals(s)) {
                count += 2;
            }
        }
        
        return count == 0;
    }
    
    public static void main(String[] args) {
        
        IsValidSerialization obj = new IsValidSerialization();
        System.out.println(obj.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(obj.isValidSerialization("1,#"));
        System.out.println(obj.isValidSerialization("9,#,#,1"));
    }
    
}
