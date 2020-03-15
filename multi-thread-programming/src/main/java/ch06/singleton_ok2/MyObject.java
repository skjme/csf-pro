package ch06.singleton_ok2;


/**
 * 懒汉模式（延迟加载，调用get方法时才实例化）
 */
public class MyObject {

    private static MyObject myObject;

    private MyObject(){

    }

     public static MyObject getInstance(){

        synchronized (MyObject.class){
            // 延迟加载
            if(myObject != null){

            }else{
                try {
                    Thread.sleep(3000);
                    myObject = new MyObject();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return myObject;
        }

    }

}
