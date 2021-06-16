package wxmp.aobing.chain;

public class SecondInterview extends Handler{

    @Override
    public void handleRequest(Integer times) {

        // 条件判断是否是属于当前Handler的处理范围之内，不是则向下传递Handler处理器
        if(times == 2){
            // 假设这里是处理的业务逻辑代码
            System.out.println("第二次面试"+times);
        }
        handler.handleRequest(times);
    }

}
