package ch02.t9;

import java.util.ArrayList;
import java.util.List;

public class MyOneList {

    private List list = new ArrayList();

    synchronized public void add(String data){
        this.list.add(data);
    }

    synchronized public int getSize(){
        return list.size();
    }

}
