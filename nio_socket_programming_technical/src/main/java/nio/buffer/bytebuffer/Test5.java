package nio.buffer.bytebuffer;

import java.nio.ByteBuffer;

public class Test5 {

    public static void main(String[] args) {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        int getArrayIndex = 0;
        while(getArrayIndex < bytes.length){
            int readLength = Math.min(byteBuffer.remaining(), bytes.length - getArrayIndex);
            System.out.println("readLength:" + readLength);

            byteBuffer.put(bytes, getArrayIndex, readLength);
            byteBuffer.flip();
            byte[] getArray = byteBuffer.array();
            System.out.println("getArray:" + getArray.length);
            for(int i = 0; i < byteBuffer.limit(); i++){
                System.out.print( getArray[i] + " ");
            }
            getArrayIndex = getArrayIndex + readLength;
            System.out.println();
            System.out.println();
            byteBuffer.clear();
        }
    }
}
