package ch04.condition_test_more_to_more;

/**
 * 实现生产/消费者模式：多对多交替打印
 */
public class Run {

    public static void main(String[] args) {
        MyService service = new MyService();
        for(int i = 0; i < 10; i++){
            new ThreadA(service).start();
            new ThreadB(service).start();
        }


    }
}
