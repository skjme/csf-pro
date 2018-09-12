package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {


//    private int port = 8000;
//    private InetSocketAddress address = null;
//    private Selector selector;
//
//
//    public NIOServer(int port) {
//        this.port = port;
//        address = new InetSocketAddress(this.port);
//        try {
//            ServerSocketChannel server = ServerSocketChannel.open();
//            server.socket().bind(address);
//            server.configureBlocking(false);
//            selector = Selector.open();
//
//            server.register(selector, SelectionKey.OP_ACCEPT);
//            System.out.println("服务器成功启动：" + this.port);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    //通道管理器
    private Selector selector;

    /**
     * 获得一个ServerSocket通道，并对该通道做一些初始化的操作
     * @param port 绑定的端口号
     * @throws IOException
     */
    public void initServer(int port) throws IOException {
        //获得一个ServerSocket通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        //将该通道对应的ServerSocket绑定到port端口
        serverSocketChannel.bind(new InetSocketAddress(port));
        //获得一个通道管理器
        this.selector = Selector.open();
        //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件，注册该事件后
        //当该事件到达后,selector.select()会返回，如果该事件没到达selector.select()会一直阻塞
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }


    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件，如果有的话，则进行处理
     *
     * @throws IOException
     */
    public void listen() throws IOException {
        System.out.println("服务端启动成功！");
        //轮询访问selector
        while (true) {
            //当注册的事件到达时，方法返回；否则，该方法会一直阻塞
            selector.select();
            //获得selector中选中的项的迭代器，选中的项为注册的事件
            Iterator<?> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                //删除已经选择的key，防止重复处理
                iterator.remove();
                handler(key);
            }
        }
    }

    /**
     * 处理请求
     *
     * @param key
     */
    public void handler(SelectionKey key) throws IOException {
        //客户端请求连接事件
        if (key.isAcceptable()) {
            handlerAccept(key);
        }
        //获得了可读事件
        else if (key.isReadable()) {
            handlerRead(key);
        }
    }

    /**
     * 处理连接请求
     *
     * @param key
     * @throws IOException
     */
    public void handlerAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        //获得和客户端连接的通道
        SocketChannel channel = serverSocketChannel.accept();
        //设置成非阻塞
        channel.configureBlocking(false);
        //在这里可以给客户端发送信息
        System.out.println("新的客户端连接");
        //在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限
        channel.register(this.selector, SelectionKey.OP_READ);
    }

    /**
     * 处理读的事件
     *
     * @param key
     * @throws IOException
     */
    public void handlerRead(SelectionKey key) throws IOException {
        //服务器可以读取消息：获取事件发生的socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        //创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);
        if (read > 0) {
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            System.out.println("服务端收到信息：" + msg);
            //回写数据
            ByteBuffer outBuffer = ByteBuffer.wrap("服务端收到了你的消息".getBytes());
            channel.write(outBuffer);
        } else {
            System.out.println("客户端关闭");
            key.cancel();
        }
    }

}
