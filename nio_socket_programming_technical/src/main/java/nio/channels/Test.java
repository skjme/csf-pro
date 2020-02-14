package nio.channels;

import java.nio.channels.Channel;

public class Test {

    public static class DBOperate implements AutoCloseable{

        @Override
        public void close() throws Exception {
            System.out.println("关闭连接");
        }
    }
    public static void main(String[] args) {

//        try (DBOperate dbOperate = new DBOperate()){
//            System.out.println(dbOperate);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }

//        Channel
    }
}
