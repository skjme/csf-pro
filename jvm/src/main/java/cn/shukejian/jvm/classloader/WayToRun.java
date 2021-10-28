package cn.shukejian.jvm.classloader;

// add vm options
// -Xmixed 默认混合运行
// -Xint 解释运行
// -Xcomp 编译运行
public class WayToRun {
    
    public static void main(String[] args) {
        for(int i = 0;  i < 10_0000; i++){
            m();
        }
        
        long start = System.currentTimeMillis();
    
        for(int i = 0;  i < 10_0000; i++){
            m();
        }
        
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        
    }
    
    public static void m(){
        for(long i = 0; i < 10_0000L; i++){
            long j = i%3;
        }
    }

}
