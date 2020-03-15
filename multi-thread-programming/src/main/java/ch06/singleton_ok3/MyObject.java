package ch06.singleton_ok3;


/**
 * 懒汉模式（延迟加载，调用get方法时才实例化）
 */
public class MyObject {

    private static MyObject myObject;

    private MyObject() {

    }

    public static MyObject getInstance() {

        // 采用双检查锁机制解决多线程环境中的延迟加载单例设计模式
        if (myObject != null) {

        } else {
            try {
                Thread.sleep(3000);
                synchronized (MyObject.class) {
                    if(myObject ==null){
                        myObject = new MyObject();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return myObject;
    }


}
