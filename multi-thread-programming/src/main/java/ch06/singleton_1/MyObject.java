package ch06.singleton_1;


/**
 * 懒汉模式（延迟加载，调用get方法时才实例化）
 */
public class MyObject {

    private static MyObject myObject;

    private MyObject(){

    }

    public static MyObject getInstance(){

        // 延迟加载
        if(myObject != null){

        }else{
            myObject = new MyObject();
        }

        return myObject;
    }

}
