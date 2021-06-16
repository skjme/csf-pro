package wxmp.aobing.chain;

public class FirstInterview extends Handler{

    @Override
    public void handleRequest(Integer times) {

        // 条件判断是否是属于当前Handler的处理范围之内，不是则向下传递Handler处理器
        if(times ==1){
            // 假设这里是处理的业务逻辑代码
            System.out.println("第一次面试"+times);
        }
        handler.handleRequest(times);
    }

}
