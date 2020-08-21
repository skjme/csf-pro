package cn.shukejian.classicob;


// 2.创建抽象观察者(Observer)
public interface Fan {

    /**
     * 更新动态
     */
    void update(String message);
}
