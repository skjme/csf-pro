package enjoy.concurrency.guarded;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "enjoy")
public class GuardedObjectTimeOut {
    private Object response;

    Object lock = new Object();

    /**
     * 加锁获取 response的值 如果response 没有值则等待
     * @return
     */
    public Object getResponse(long millis){
        synchronized (lock) {
            //开始时间
            long begin = System.currentTimeMillis();
            //经历了多少时间 开始肯定是0
            long timePassed = 0;
            //没有次数 我也不知道是不是第一次
            while (response == null) {
                //睡多少时间
                long waitTime = millis-timePassed;
                log.debug("主线程  判断如果没有结果则wait{}毫秒",waitTime);
                if (waitTime <= 0) {
                    log.debug("超时了 直接结束while 不等了");
                    break;
                }
                try {
                    lock.wait(waitTime);//6s之后被notify 了  1、去经历的时间记录一下  2、看有没有结果 没有则继续等
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //如果被别人提前唤醒 先不结束 先計算一下经历时间   6   10
                timePassed = System.currentTimeMillis() - begin;
                log.debug("经历了: {}", timePassed);
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
