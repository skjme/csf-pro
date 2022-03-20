package cn.shukejian.jvm;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author chaseshu
 * @date 2022/3/16 09:00
 * @apiNote
 */
public class ObjSize {
    
    static L l = new L();
    
    public static void main(String[] args) {
        // System.out.println(VM.current().details());
        // System.out.println(ClassLayout.parseClass(L.class).toPrintable());
    
        System.out.println(Integer.toHexString(l.hashCode()));
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
    }
    
}
