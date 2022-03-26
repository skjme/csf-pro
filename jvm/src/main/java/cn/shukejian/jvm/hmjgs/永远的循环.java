package cn.shukejian.jvm.hmjgs;

/**
 * @author chaseshu
 * @date 2022/3/24 09:59
 * @apiNote
 *
 *  Add VM options
 * -XX:+PrintCompilation 查看即时编译情况 JIT优化
 * -Xint 强制解释执行（禁用JIT优化）
 */
public class 永远的循环 {
    
    static boolean stop = false;
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop = true;
            System.out.println(">>>>>>>>>> stop");
        }).start();
        
        foo();
    }
    static void foo() {
        while (true) {
            boolean b = stop;
            if(b) {
                break;
            }
        }
    }
}
