package com.chaseshu;

import org.apache.zookeeper.*;

/**
 * Hello world!
 *
 */
public class App implements Watcher
{

    private static ZooKeeper zk;
    public static void main( String[] args ) throws Exception {

        String connectString = "192.168.56.101:2181";
        int sessionTimeout = 5000;
        zk = new ZooKeeper(connectString, sessionTimeout, new App());
        System.out.println(zk.getState());
        Thread.sleep(Integer.MAX_VALUE);

    }

    private void doSomething(){

        try{

            //Sync 同步創建節點
//            String path = zk.create("/node_1", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT );
//            System.out.println("return path:" + path);

            //ASync 異步創建節點
             zk.create("/node_2", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT,
                    new IStringCallback(), "this is content");



        }catch (Exception ex){
            System.out.println(ex);
        }

        System.out.println("do something");
    }


    @Override
    public void process(WatchedEvent event) {
        System.out.println("Receive watched event:" + event);
        if(event.getState() == Event.KeeperState.SyncConnected){
            System.out.println("ZooKeeper session established.");
            doSomething();
        }

    }

    private class IStringCallback implements AsyncCallback.StringCallback {


        @Override
        public void processResult(int rc, String path, Object ctx, String name) {

            System.out.println("rc:" + rc);
            System.out.println("path:" + path);
            System.out.println("ctx:" + ctx);
            System.out.println("name:" + name);
        }
    }
}
