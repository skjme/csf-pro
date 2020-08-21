package cn.shukejian.classicob;

public class Test {

    // https://juejin.im/post/6844903969731379207
    public static void main(String[] args) {

        // 1  创建多个观察者 （粉丝）
        Fan fan1 = new ConcrereFan("粉丝1");
        Fan fan2 = new ConcrereFan("粉丝2");
        Fan fan3 = new ConcrereFan("粉丝3");

        // 2 创建一个明星
        Star star = new ConcrereStar("吴亦凡");

        // 3 订阅（注册）
        star.addFan(fan1);
        star.addFan(fan2);
        star.addFan(fan3);

        // 4 发布消息
        star.notifyFan("我的最新节目就要上线了，大家准备赶紧看吧");
    }
}
