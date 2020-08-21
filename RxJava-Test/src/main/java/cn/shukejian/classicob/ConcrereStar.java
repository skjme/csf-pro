package cn.shukejian.classicob;


import java.util.ArrayList;
import java.util.List;

// 3.创建具体被观察者（Concrete Subject 具体明星）
public class ConcrereStar implements Star{

    private String starName;
    private List<Fan> fanList = null;

    public ConcrereStar(String starName){
        this.starName = starName;
        fanList = new ArrayList<Fan>();
    }
    
    @Override
    public void addFan(Fan fan){
        fanList.add(fan);
    }
    
    @Override
    public void removeFan(Fan fan){
        fanList.remove(fan);
    }
    
    @Override
    public void notifyFan(String message){
        for(Fan fan : fanList){
            fan.update(this.starName + " 发布了 "+message+" 信息");
        }
    }
}
