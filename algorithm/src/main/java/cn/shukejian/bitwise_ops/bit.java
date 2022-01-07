package cn.shukejian.bitwise_ops;

/**
 * @author chaseshu
 * @date 2021/12/14 14:48
 * @apiNote
 */
public class bit {
    
    public static void main(String[] args) {
        
        // int a = -2;
        int a = 2;
        print(-2);
        print(2);
        
        // -2^31.
        System.out.println(Integer.MIN_VALUE);
        // 2^31-1.
        System.out.println(Integer.MAX_VALUE);
        print(Integer.MIN_VALUE);
        print(Integer.MAX_VALUE);
    
        System.out.println("0111111111111111111111111111110".length());
       
        System.out.println("-------------");
        // 0 取反加一 还是零
        int min = Integer.MIN_VALUE;
        int min2 = ~min + 1;
        System.out.println(min);
        System.out.println(min2);
    
        System.out.println(~(-2)+1);
    }
    
    /**
     * 打印32位
     * @param num
     */
    public static void print(int num){
        for(int i = 31; i >= 0; i--){
            System.out.print((num & (i << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    
}
