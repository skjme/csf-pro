package cn.shukejian.java15.test;

public class SwitchExpressions {

    public static void main(String[] args) {

        int k = 3;
        System.out.println(switch (k){
          case 1 -> "one";
          case 2 -> "two";
            default -> "many";
        });
    }
}
