package ch06.singleton_staticinnerclass2;


import java.io.Serializable;

/**
 * 静态内部类
 */
public class MyObject implements Serializable {

    private static final long serialVersionUID = 888L;

    private static class MyObjectHandler {
        private static MyObject myObject = new MyObject();
    }

    private MyObject() {

    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;

    }

}
