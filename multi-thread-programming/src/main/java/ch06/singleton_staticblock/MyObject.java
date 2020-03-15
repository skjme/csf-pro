package ch06.singleton_staticblock;

public class MyObject {

    private static MyObject myObject = null;
    private MyObject(){

    }

    static {
        myObject = new MyObject();
    }

    public static MyObject getInstance(){
        return myObject;
    }
}
