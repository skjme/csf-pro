package ch02.t9;

public class MyService {

    public MyOneList addServiceMethod(MyOneList list, String data){
        try {
            synchronized (list){ // 对list参数进行同步处理
                if (list.getSize() < 1) {
                    Thread.sleep(2000); // 模拟远程花费2秒取回数据
                    list.add(data);
                }
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return list;
    }
}
