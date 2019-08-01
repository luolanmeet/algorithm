package pers.sword;
/**
 * 请实现一个函数，将一个字符串中的空格替换成 "%20"
 * @author cck
 */
public class Algorithm4 {
    
    public String replace(String str) {
        
        char[] cs = str.toCharArray();
        
        StringBuilder strBuil = new StringBuilder();
        
        for (char c : cs) {
            if (c == ' ') {
                strBuil.append("%20");
            } else {
                strBuil.append(c);
            }
        }
    
        return strBuil.toString();
    }
    
    public static void main(String[] args) {
    
        Algorithm4 obj = new Algorithm4();
        String str = "a new day.";
        System.out.println(str.replaceAll(" ", "%20"));
        System.out.println(obj.replace(str));
    }
    
}
