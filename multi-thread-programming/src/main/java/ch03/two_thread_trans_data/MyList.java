package ch03.two_thread_trans_data;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    private static List list  = new ArrayList();

    public static void add() {
        list.add("舒克");
    }

    public static int size(){
        return list.size();
    }
}
