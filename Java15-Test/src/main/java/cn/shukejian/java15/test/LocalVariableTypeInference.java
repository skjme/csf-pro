package cn.shukejian.java15.test;

import java.time.LocalDate;
import java.util.HashMap;

public class LocalVariableTypeInference {

    public static void main(String[] args) {
        var greetingMessage = "hello!";
        System.out.println(greetingMessage);

        var date = LocalDate.parse("2020-12-31");
        System.out.println(date);
        var dayOfWeek = date.getDayOfWeek();
        var dayOfMonth = date.getDayOfMonth();
        System.out.println(dayOfWeek);
        System.out.println(dayOfMonth);

        var myMap = new HashMap<>();
        var myMap2 = new HashMap<String, String>();
    }
}
