package wxmp.aobing.chain;

public class ThreeInterview extends Handler {
    @Override
    public void handleRequest(Integer times) {
        if (times == 3) {
            System.out.println("第三次面试"+ times + "，恭喜面试通过，HR会跟你联      系！！！");
        }
    }


}