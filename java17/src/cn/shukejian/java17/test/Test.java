package cn.shukejian.java17.test;

import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {
        System.out.println("Hello Java 17!");
        
        System.out.println(formatterPatternSwitch(1));
        System.out.println(formatterPatternSwitch(1L));
        System.out.println(formatterPatternSwitch(1.1));
        System.out.println(formatterPatternSwitch("1.1"));
        
    }
    
    static String formatterPatternSwitch(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> o.toString();
        };
    }
    
}
