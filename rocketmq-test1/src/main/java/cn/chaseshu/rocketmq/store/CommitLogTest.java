package cn.chaseshu.rocketmq.store;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.sysflag.MessageSysFlag;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommitLogTest {

    private static final String CHARSET_UTF8 = "utf-8";

    /**
     * 读取文件内容
     * @param path
     * @return
     * @throws Exception
     */
    public static ByteBuffer read(String path)throws Exception{
        File file = new File(path);
        FileInputStream fin = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fin.read(bytes);
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        return buffer;
    }

    /**
     * commitlog 文件解析
     * @param byteBuffer
     * @return
     * @throws Exception
     */
    public static MessageExt decodeCommitLog(ByteBuffer byteBuffer)throws Exception {

        MessageExt msgExt = new MessageExt();

        // 1 TOTALSIZE
        int storeSize = byteBuffer.getInt();
        msgExt.setStoreSize(storeSize);

        if (storeSize<=0){
            return null;
        }

        // 2 MAGICCODE
        byteBuffer.getInt();

        // 3 BODYCRC
        int bodyCRC = byteBuffer.getInt();
        msgExt.setBodyCRC(bodyCRC);

        // 4 QUEUEID
        int queueId = byteBuffer.getInt();
        msgExt.setQueueId(queueId);

        // 5 FLAG
        int flag = byteBuffer.getInt();
        msgExt.setFlag(flag);

        // 6 QUEUEOFFSET
        long queueOffset = byteBuffer.getLong();
        msgExt.setQueueOffset(queueOffset);

        // 7 PHYSICALOFFSET
        long physicOffset = byteBuffer.getLong();
        msgExt.setCommitLogOffset(physicOffset);

        // 8 SYSFLAG
        int sysFlag = byteBuffer.getInt();
        msgExt.setSysFlag(sysFlag);

        // 9 BORNTIMESTAMP
        long bornTimeStamp = byteBuffer.getLong();
        msgExt.setBornTimestamp(bornTimeStamp);

        // 10 BORNHOST
//        int bornhostIPLength = (sysFlag & MessageSysFlag.BORNHOST_V6_FLAG) == 0 ? 4 : 16;
//        byte[] bornHost = new byte[bornhostIPLength];
//        byteBuffer.get(bornHost, 0, bornhostIPLength);
//        int port = byteBuffer.getInt();
//        msgExt.setBornHost(new InetSocketAddress(InetAddress.getByAddress(bornHost), port));

        // 11 STORETIMESTAMP
        long storeTimestamp = byteBuffer.getLong();
        msgExt.setStoreTimestamp(storeTimestamp);

        // 12 STOREHOST
//        int storehostIPLength = (sysFlag & MessageSysFlag.STOREHOSTADDRESS_V6_FLAG) == 0 ? 4 : 16;
//        byte[] storeHost = new byte[storehostIPLength];
//        byteBuffer.get(storeHost, 0, storehostIPLength);
//        port = byteBuffer.getInt();
//        msgExt.setStoreHost(new InetSocketAddress(InetAddress.getByAddress(storeHost), port));

        // 13 RECONSUMETIMES
        int reconsumeTimes = byteBuffer.getInt();
        msgExt.setReconsumeTimes(reconsumeTimes);

        // 14 Prepared Transaction Offset
        long preparedTransactionOffset = byteBuffer.getLong();
        msgExt.setPreparedTransactionOffset(preparedTransactionOffset);

        // 15 BODY
        int bodyLen = byteBuffer.getInt();
        if (bodyLen > 0) {
            byte[] body = new byte[bodyLen];
            byteBuffer.get(body);
            msgExt.setBody(body);
        }

        // 16 TOPIC
        byte topicLen = byteBuffer.get();
        byte[] topic = new byte[(int) topicLen];
        byteBuffer.get(topic);
//        msgExt.setTopic(new String(topic, CHARSET_UTF8));

        // 17 properties
        short propertiesLength = byteBuffer.getShort();
        if (propertiesLength > 0) {
            byte[] properties = new byte[propertiesLength];
            byteBuffer.get(properties);
            String propertiesString = new String(properties, CHARSET_UTF8);
            Map<String, String> map = string2messageProperties(propertiesString);
        }
//        int msgIDLength = storehostIPLength + 4 + 8;
//        ByteBuffer byteBufferMsgId = ByteBuffer.allocate(msgIDLength);
//        String msgId = createMessageId(byteBufferMsgId, msgExt.getStoreHostBytes(), msgExt.getCommitLogOffset());
//        msgExt.setMsgId(msgId);

        return msgExt;
    }

    private static Map<String,String> string2messageProperties(String propertiesString) {
        return null;
    }

    private static String createMessageId(ByteBuffer byteBufferMsgId, ByteBuffer storeHostBytes, long commitLogOffset) {
        return "";
    }


    public static void main(String[] args) throws Exception {
        String filePath = "/Users/ask123/store/commitlog/00000000000000000000";
        ByteBuffer buffer = read(filePath);
        List<MessageExt> messageList = new ArrayList<>();
        while (true){
            MessageExt message = decodeCommitLog(buffer);
            if (message==null){
                break;
            }
            messageList.add(message);
        }
        for (MessageExt ms:messageList) {
            System.out.println("主题:"+ms.getTopic()+" 消息:"+
                    new String(ms.getBody())+"队列ID:"+ms.getQueueId()+" 存储地址:"+ms.getStoreHost());
        }
    }



}
