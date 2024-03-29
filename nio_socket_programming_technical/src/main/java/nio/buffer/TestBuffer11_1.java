package nio.buffer;

import java.nio.CharBuffer;

public class TestBuffer11_1 {

    public static void main(String[] args) {

        CharBuffer charBuffer = CharBuffer.allocate(20);
        System.out.println("A position = " + charBuffer.position() + " limit = " + charBuffer.limit());
        System.out.println(charBuffer);//输出20个空格：                    

        charBuffer.put("我是中国人我在中华人民共和国"); // 一共输入14个字
        System.out.println("B position = " + charBuffer.position() + " limit = " + charBuffer.limit());
        System.out.println(charBuffer);//输出6个空格：      

        charBuffer.position(0);// 位置position还原成0

        System.out.println("C position = " + charBuffer.position() + " limit = " + charBuffer.limit());
        System.out.println(charBuffer);//输出：我是中国人我在中华人民共和国      

        for(int i = 0; i < charBuffer.limit(); i++){
            System.out.print(charBuffer.get());
        }
        System.out.println();
        // 以上都是错误读取数据的代码

        // 以下是正确读取数据的代码
        System.out.println("D position = " + charBuffer.position() + " limit = " + charBuffer.limit());
        // 还原缓冲区
        charBuffer.clear();
        System.out.println("E position = " + charBuffer.position() + " limit = " + charBuffer.limit());

        // 继续写入
        charBuffer.put("我是美国人");
        System.out.println("F position = " + charBuffer.position() + " limit = " + charBuffer.limit());

        // 使用flip方法
        charBuffer.flip();
        // flip等价一下两行代码
//        charBuffer.limit(charBuffer.position());
//        charBuffer.position(0);
        System.out.println("G position = " + charBuffer.position() + " limit = " + charBuffer.limit());

        for(int i = 0; i < charBuffer.limit(); i++){
            System.out.print(charBuffer.get());
        }

    }
}
