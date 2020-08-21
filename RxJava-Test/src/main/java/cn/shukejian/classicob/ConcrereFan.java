package cn.shukejian.classicob;

// 4.创建具体观察者(Concrere Observer 具体粉丝)
public class ConcrereFan implements Fan{
    
    private String fanName;
    
    public ConcrereFan(String fanName){
        this.fanName = fanName;
    }
    
    @Override
    public void update(String message){
//        System.out.println("AFan 收到了 AStar 发布的消息");
        System.out.println(fanName + " 收到了 关注star 发布的消息:" + message);
    }
    
}
