package cn.shukejian.jvm.hmjgs;

import java.util.ArrayList;
import java.util.List;
 
public class TestHeap {
 
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        while (true){
            User user = new User();
            user.setId(1L);
            user.setUsername("user");
            user.setPassword("pass");
 
            if(System.currentTimeMillis() % 2 ==0 ){
                userList.add(user);
                System.out.println("add to list, size = " + userList.size());
            }
 
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
 
        }
    }
}