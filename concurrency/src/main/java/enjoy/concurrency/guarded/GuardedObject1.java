package enjoy.concurrency.guarded;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "enjoy")
public class GuardedObject1 {
    private Object response;

    Object lock = new Object();

    /**
     * 加锁获取 response的值 如果response 没有值则等待
     *
     *
     * millis ==10  5 =10-5  1 =5-1=4
     * @return
     */
    public Object getResponse(long millis){
        synchronized (lock) {
            log.debug("主线程 获取 response 如果为null则wait");
            while (response == null) {
                try {
                    lock.wait(millis);
                    //如果我被别人叫醒了？ 我要去再次查看结果 如果没有结果我则继续等待
                    //确定我等了多少时间？ 和 millis 对比如果大于了millis  则则可以直接结束 如果
                    /**
                     * 1、passedTime   经历了多少时间
                     * 2、开始时间
                     * 3、结束时间
                     */
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }


    /**
     * t1 给response设置值
     * @param response
     */
    public void setResponse(Object response) {
        synchronized (lock) {
            this.response = response;
            //设置完成之后唤醒主线程
            lock.notifyAll();
        }
    }
}
