package ch06.singleton_0;


/**
 * 饿汉模式（立即加载，直接new实例化）
 */
public class MyObject {

    private static MyObject myObject = new MyObject();

    private MyObject(){

    }

    public static MyObject getInstance(){
        return myObject;
    }

}
