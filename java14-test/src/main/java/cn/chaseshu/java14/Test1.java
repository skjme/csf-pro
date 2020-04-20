package cn.chaseshu.java14;

public class Test1 {

    public static void main(String[] args) {
        new Test1().test("abc");
        new Test1().test14("abc");
    }

    private void test( Object obj ) {
        if( obj instanceof String  ) {
            String str = (String) obj;  // 需手动强制转换！
            System.out.println( str.isEmpty() );
        }
    }

    // instanceof用法增强
    private void test14( Object obj ) {
        if( obj instanceof String str ) { // 校验通过，直接后面定义变量，无需强转！
            System.out.println( str.isEmpty() );
        }
    }
}
