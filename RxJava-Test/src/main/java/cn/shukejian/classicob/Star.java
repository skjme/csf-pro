package cn.shukejian.classicob;

// 1.创建抽象被观察者(Subject)：
public interface Star {
    /**
     * 添加粉丝
     */
    void addFan(Fan fan);

    /**
     * 取消粉丝
     */
    void removeFan(Fan fan);

    /**
     * 分享动态
     */
    void notifyFan(String message);

}
