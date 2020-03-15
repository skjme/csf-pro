package ch06.singleton_staticinnerclass;


/**
 * 静态内部类
 */
public class MyObject {

    private static class MyObjectHandler {
        private static MyObject myObject = new MyObject();
    }

    private MyObject() {

    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;

    }

}
